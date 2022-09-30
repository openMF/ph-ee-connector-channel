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
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.mifos.connector.common.gsma.dto.GsmaParty;
import org.mifos.connector.common.gsma.dto.RequestStateDTO;
import org.mifos.connector.common.mojaloop.dto.MoneyData;
import org.mifos.connector.common.mojaloop.dto.Party;
import org.mifos.connector.common.mojaloop.dto.PartyIdInfo;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
import org.mifos.connector.common.mojaloop.type.IdentifierType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public GSMAChannelRouteBuilder(@Value("#{'${dfspids}'.split(',')}") List<String> dfspIds,
                               @Value("${bpmn.flows.gsma-base-transaction}") String baseTransaction,
                               @Value("${bpmn.flows.gsma-int-transfer}") String intTransfer,
                               @Value("${bpmn.flows.gsma-payee-process}") String payeeProcess,
                               @Value("${bpmn.flows.gsma-bill-payment}") String billPayment,
                               @Value("${bpmn.flows.gsma-link-based-payment}") String linkBasedPayment,
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

        from("rest:GET:/channel/gsma")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant("It Works!"));

        from("rest:POST:/channel/gsma/transfer")
                .id("gsma-payer-transfer")
                .log(LoggingLevel.INFO, "## CHANNEL -> GSMA PAYER initiated transfer")
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
                    extraVariables.put(TRANSACTION_TYPE, "transfer");

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    extraVariables.put(TENANT_ID, tenantId);
                    channelRequest.setTransactionType(transactionType);

                    PartyIdInfo requestedParty = (boolean)extraVariables.get(IS_RTP_REQUEST) ? channelRequest.getPayer().getPartyIdInfo() : channelRequest.getPayee().getPartyIdInfo();
                    extraVariables.put(PARTY_ID_TYPE, requestedParty.getPartyIdType());
                    extraVariables.put(PARTY_ID, requestedParty.getPartyIdentifier());

                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(baseTransaction,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });


        from("rest:POST:/channel/gsma/inttransfer")
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
                    String tenantSpecificBpmn = internationalRemittancePayer.replace("{dfspid}", tenantId);
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


        from("rest:POST:/channel/gsma/deposit")
                .id("gsma-payee-deposit")
                .log(LoggingLevel.INFO, "## CHANNEL -> GSMA PAYEE deposit")
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

                    Map<String, Object> extraVariables = new HashMap<>();

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    extraVariables.put(TENANT_ID, tenantId);
                    String tenantSpecificBpmn = internationalRemittancePayee.replace("{dfspid}", tenantId);

                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);

                    RequestStateDTO gsmaResponse = new RequestStateDTO();
                    gsmaResponse.setServerCorrelationId(transactionId);
                    gsmaResponse.setStatus("pending");
                    gsmaResponse.setNotificationMethod("polling");
                    gsmaResponse.setObjectReference("");
                    gsmaResponse.setPollLimit("");

                    exchange.getIn().setBody(objectMapper.writeValueAsString(gsmaResponse));
                    exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, constant(202));
                });

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

}
