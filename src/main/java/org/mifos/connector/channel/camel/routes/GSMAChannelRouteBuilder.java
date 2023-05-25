package org.mifos.connector.channel.camel.routes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.camunda.zeebe.client.ZeebeClient;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mifos.connector.channel.properties.TenantImplementation;
import org.mifos.connector.channel.properties.TenantImplementationProperties;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.connector.common.channel.dto.PhErrorDTO;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.exception.PaymentHubError;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.mifos.connector.common.gsma.dto.GsmaParty;
import org.mifos.connector.common.gsma.dto.RequestStateDTO;
import org.mifos.connector.common.mojaloop.dto.*;
import org.mifos.connector.common.mojaloop.type.IdentifierType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mifos.connector.channel.zeebe.ZeebeVariables.*;
import static org.mifos.connector.common.mojaloop.type.InitiatorType.CONSUMER;
import static org.mifos.connector.common.mojaloop.type.Scenario.TRANSFER;
import static org.mifos.connector.common.mojaloop.type.TransactionRole.PAYER;

@Component
public class GSMAChannelRouteBuilder extends ErrorHandlerRouteBuilder {



    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String baseTransaction;
    private String intTransfer;
    private String payeeProcess;
    private String billPayment;
    private String linkBasedPayment;
    private String internationalRemittancePayee;
    private String internationalRemittancePayer;
    private ZeebeProcessStarter zeebeProcessStarter;
    private ZeebeClient zeebeClient;
    private List<String> dfspIds;
    private ObjectMapper objectMapper;
    private String payeeTenantName;

    @Autowired
    TenantImplementationProperties tenantImplementationProperties;

    public GSMAChannelRouteBuilder(@Value("#{'${dfspids}'.split(',')}") List<String> dfspIds,
                               @Value("${bpmn.flows.gsma-base-transaction}") String baseTransaction,
                               @Value("${bpmn.flows.gsma-int-transfer}") String intTransfer,
                               @Value("${bpmn.flows.gsma-payee-process}") String payeeProcess,
                               @Value("${bpmn.flows.gsma-bill-payment}") String billPayment,
                               @Value("${bpmn.flows.gsma-link-based-payment}") String linkBasedPayment,
                               @Value("${gsma.payee.tenant}") String payeeTenantName,
                               @Value("${bpmn.flows.international-remittance-payee}") String internationalRemittancePayee,
                               @Value("${bpmn.flows.international-remittance-payer}") String internationalRemittancePayer,
                               ZeebeClient zeebeClient,
                               ZeebeProcessStarter zeebeProcessStarter,
                               ObjectMapper objectMapper) {
        super.configure();
        this.baseTransaction = baseTransaction;
        this.intTransfer = intTransfer;
        this.payeeProcess = payeeProcess;
        this.billPayment = billPayment;
        this.linkBasedPayment = linkBasedPayment;
        this.internationalRemittancePayee = internationalRemittancePayee;
        this.internationalRemittancePayer = internationalRemittancePayer;
        this.zeebeProcessStarter = zeebeProcessStarter;
        this.zeebeClient = zeebeClient;
        this.dfspIds = dfspIds;
        this.objectMapper = objectMapper;
        this.payeeTenantName = payeeTenantName;
    }

    @Override
    public void configure() {
        onException(BeanValidationException.class)
                .process(e -> {
                    JSONArray violations = new JSONArray();
                    e.getProperty(Exchange.EXCEPTION_CAUGHT, BeanValidationException.class).getConstraintViolations().forEach(v -> {
                        violations.put(v.getPropertyPath() + " --- " + v.getMessage());
                    });

                    JSONObject response = new JSONObject();
                    response.put("violations", violations);
                    e.getIn().setBody(response.toString());
                    e.removeProperties("*");
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .stop();

        onException(InvalidFormatException.class)
                .process(e -> {
                    JSONArray violations = new JSONArray();
                    violations.put(e.getProperty(Exchange.EXCEPTION_CAUGHT, InvalidFormatException.class).getMessage());

                    JSONObject response = new JSONObject();
                    response.put("violations", violations);
                    e.getIn().setBody(response.toString());
                    e.removeProperties("*");
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .stop();

        from("direct:get-channel-gsma")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant("It Works!"));

        from("direct:post-gsma-transfer")
                .id("gsma-payer-transfer")
                .log(LoggingLevel.INFO, "## CHANNEL -> GSMA PAYER initiated transfer")
                .unmarshal().json(JsonLibrary.Jackson, GSMATransaction.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class); // GSMA Object

                    // validation of request
                    PhErrorDTO validationResponse = validateGsmaRequest(exchange);
                    if (validationResponse != null) {
                        // validation failed, means request has some validation faults
                        exchange.getIn().setBody(objectMapper.writeValueAsString(validationResponse));
                        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
                        logger.info("Validation failed: {}", validationResponse);
                        return;
                    }

                    TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object
                    String clientCorrelationId = exchange.getIn().getHeader("X-CorrelationID", String.class);
                    Party payer = partyMapper(gsmaChannelRequest.getDebitParty());
                    Party payee = partyMapper(gsmaChannelRequest.getCreditParty());
                    MoneyData amount = amountMapper(gsmaChannelRequest.getAmount(), gsmaChannelRequest.getCurrency());


                    channelRequest.setPayer(payer);
                    channelRequest.setPayee(payee);
                    channelRequest.setAmount(amount);

                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYER);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(TRANSFER);

                    Map<String, Object> extraVariables = new HashMap<>();
                    extraVariables.put(IS_RTP_REQUEST, false);
                    extraVariables.put(TRANSACTION_TYPE, "transfer");
                    extraVariables.put("initiator", transactionType.getInitiator().name());
                    extraVariables.put("initiatorType", transactionType.getInitiatorType().name());
                    extraVariables.put("scenario", transactionType.getScenario().name());
                    extraVariables.put("amount", new FspMoneyData(channelRequest.getAmount().getAmountDecimal(),
                            channelRequest.getAmount().getCurrency()));
                    extraVariables.put("processType","api");
                    extraVariables.put("payeeTenantId", payeeTenantName);
                    extraVariables.put("clientCorrelationId", clientCorrelationId);

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    extraVariables.put(TENANT_ID, tenantId);
                    channelRequest.setTransactionType(transactionType);

                    PartyIdInfo requestedParty = (boolean)extraVariables.get(IS_RTP_REQUEST) ? channelRequest.getPayer().getPartyIdInfo() : channelRequest.getPayee().getPartyIdInfo();
                    extraVariables.put(PARTY_ID_TYPE, requestedParty.getPartyIdType());
                    extraVariables.put(PARTY_ID, requestedParty.getPartyIdentifier());

                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));
                    extraVariables.put(NOTE,gsmaChannelRequest.getDescriptionText());
                    logger.info("Payee Tenant ID {}", extraVariables.get("payeeTenantId"));
                    String bpmn = getWorkflowForTenant(tenantId);
                    String tenantSpecificBpmn = bpmn.equals("default")?baseTransaction .replace("{dfspid}",
                            tenantId):bpmn.replace("{dfspid}", tenantId);
                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });


        from("direct:post-gsma-payer-int-transfer")
                .id("gsma-payer-inttransfer")
                .log(LoggingLevel.INFO, "## CHANNEL -> GSMA PAYER initiated international transfer")
                .unmarshal().json(JsonLibrary.Jackson, GSMATransaction.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class); // GSMA Object
                    TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object

                    Party payer = partyMapper(gsmaChannelRequest.getDebitParty());
                    Party payee = partyMapper(gsmaChannelRequest.getCreditParty());
                    MoneyData amount = amountMapper(gsmaChannelRequest.getAmount(), gsmaChannelRequest.getCurrency());

                    channelRequest.setPayer(payer);
                    channelRequest.setPayee(payee);
                    channelRequest.setAmount(amount);

                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYER);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(TRANSFER);

                    Map<String, Object> extraVariables = new HashMap<>();
                    extraVariables.put(IS_RTP_REQUEST, false);
                    extraVariables.put(TRANSACTION_TYPE, "inttransfer");

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    extraVariables.put(TENANT_ID, tenantId);
                    String bpmn = getWorkflowForTenant(tenantId);
                    String tenantSpecificBpmn = bpmn.equals("default")?internationalRemittancePayer:bpmn
                            .replace("{dfspid}", tenantId);
                    channelRequest.setTransactionType(transactionType);

                    PartyIdInfo requestedParty = (boolean)extraVariables.get(IS_RTP_REQUEST) ? channelRequest.getPayer().getPartyIdInfo() : channelRequest.getPayee().getPartyIdInfo();
                    extraVariables.put(PARTY_ID_TYPE, requestedParty.getPartyIdType());
                    extraVariables.put(PARTY_ID, requestedParty.getPartyIdentifier());

                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });


        from("direct:post-gsma-deposit")
                .id("gsma-payee-deposit")
                .log(LoggingLevel.INFO, "## CHANNEL -> GSMA PAYEE deposit")
                .unmarshal().json(JsonLibrary.Jackson, GSMATransaction.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class); // GSMA Object
                    TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object
                    String clientCorrelationId = exchange.getIn().getHeader("X-CorrelationID", String.class);
                    Party payer = partyMapper(gsmaChannelRequest.getDebitParty());
                    Party payee = partyMapper(gsmaChannelRequest.getCreditParty());
                    MoneyData amount = amountMapper(gsmaChannelRequest.getAmount(), gsmaChannelRequest.getCurrency());

                    channelRequest.setPayer(payer);
                    channelRequest.setPayee(payee);
                    channelRequest.setAmount(amount);

                    Map<String, Object> extraVariables = new HashMap<>();

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    extraVariables.put(TENANT_ID, tenantId);
                    String bpmn = getWorkflowForTenant(tenantId);
                    String tenantSpecificBpmn = bpmn.equals("default")?internationalRemittancePayee:bpmn
                            .replace("{dfspid}", tenantId);

                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));
                    extraVariables.put(NOTE,gsmaChannelRequest.getDescriptionText());

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);

                    RequestStateDTO gsmaResponse = new RequestStateDTO();
                    gsmaResponse.setServerCorrelationId(transactionId);
                    gsmaResponse.setStatus("pending");
                    gsmaResponse.setNotificationMethod("polling");
                    gsmaResponse.setObjectReference("");
                    gsmaResponse.setPollLimit("");
                    extraVariables.put("clientCorrelationId", clientCorrelationId);

                    exchange.getIn().setBody(objectMapper.writeValueAsString(gsmaResponse));
                    exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(202));
                });

    }

    // validates and return errorDTO if validation is failed or else null
    private PhErrorDTO validateGsmaRequest(Exchange exchange) {
        GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class);

        String defaultMessageInCaseOfMissingMandatoryField = gsmaMandatoryFieldValidation(gsmaChannelRequest);
        if (defaultMessageInCaseOfMissingMandatoryField != null) {
            return new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.MandatoryValueNotSupplied)
                    .developerMessage("Make sure all mandatory fields are provided, check the API spec for more info.")
                    .defaultUserMessage(defaultMessageInCaseOfMissingMandatoryField).build();
        }

        double amount;
        try {
            amount = Double.parseDouble(gsmaChannelRequest.getAmount());
        } catch (Exception e) {
            return new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.FormatError)
                    .developerMessage("Amount field supports decimal values, with non negative value.")
                    .defaultUserMessage("Invalid amount format.").build();
        }
        if (amount <= 0) {
            return new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.NegativeValue)
                    .developerMessage("Amount field supports decimal values, with non negative value.")
                    .defaultUserMessage("Invalid amount format.").build();
        }
        if (gsmaChannelRequest.getDebitParty()[0].getKey().equals(gsmaChannelRequest.getCreditParty()[0].getKey()) &&
        gsmaChannelRequest.getDebitParty()[0].getValue().equals(gsmaChannelRequest.getCreditParty()[0].getValue())) {
            return new PhErrorDTO.PhErrorDTOBuilder(PaymentHubError.SamePartiesError)
                    .developerMessage("Credit and Debit MSISDNs can't be same")
                    .defaultUserMessage(PaymentHubError.SamePartiesError.getErrorDescription()).build();
        }

        return null;
    }

    // check if mandatory field is non-empty or returns developer message
    public String gsmaMandatoryFieldValidation(GSMATransaction gsmaChannelRequest) {
        if (gsmaChannelRequest.getAmount().isEmpty()) {
            return "Amount can't be empty";
        }
        if (gsmaChannelRequest.getCreditParty().length == 0) {
            return "Credit party can't pe empty";
        }
        if (gsmaChannelRequest.getDebitParty().length == 0) {
            return "Debit party can't be empty";
        }
        if (gsmaChannelRequest.getCurrency().isEmpty()) {
            return "Currency can't be empty";
        }

        return null;
    }

    public Party partyMapper(GsmaParty[] gsmaParties) {
        IdentifierType identifierType = IdentifierType.MSISDN;

        switch (gsmaParties[0].getKey()) {
            case "accountid":
                identifierType = IdentifierType.ACCOUNT_ID;
                break;
            case "identityalias":
                identifierType = IdentifierType.ALIAS;
                break;
            case "iban":
                identifierType = IdentifierType.IBAN;
                break;
            case "emailaddress":
                identifierType = IdentifierType.EMAIL;
                break;
        }

        PartyIdInfo partyIdInfo = new PartyIdInfo(identifierType, gsmaParties[0].getValue());
        return new Party(partyIdInfo);
    }
    
//    public Party partyMapper(GsmaParty[] gsmaParties, Kyc kyc) {
//        return new Party(); // To be taken care of
//    }

    public MoneyData amountMapper(String amount, String currency) {
        MoneyData moneyData = new MoneyData();
        amount.trim();
        moneyData.setAmount(amount);
        moneyData.setCurrency(currency);

        return moneyData;
    }
    public String getWorkflowForTenant(String tenantId) {
        for (TenantImplementation tenant : tenantImplementationProperties.getTenants()) {
            if (tenant.getId().equals(tenantId)) {
                return tenant.getFlows().getOrDefault("gsma-base-transaction", "default");
            }}
        return "default";
    }
}
