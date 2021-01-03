package org.mifos.connector.channel.camel.routes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.zeebe.client.ZeebeClient;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mifos.connector.channel.camel.config.Client;
import org.mifos.connector.channel.camel.config.ClientProperties;
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
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.util.Base64.getEncoder;
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
    private String debitPartyProcess;
    private String payeeDepositTransfer;
    private ZeebeProcessStarter zeebeProcessStarter;
    private ZeebeClient zeebeClient;
    private List<String> dfspIds;
    private ObjectMapper objectMapper;
    private String institutionName;
    private ClientProperties clientProperties;
    private RestTemplate restTemplate;
    private String restAuthHost;
    private String operationsUrl;


    public GSMAChannelRouteBuilder(@Value("#{'${dfspids}'.split(',')}") List<String> dfspIds,
                               @Value("${bpmn.flows.gsma-base-transaction}") String baseTransaction,
                               @Value("${bpmn.flows.gsma-int-transfer}") String intTransfer,
                               @Value("${bpmn.flows.gsma-payee-process}") String payeeProcess,
                               @Value("${bpmn.flows.gsma-bill-payment}") String billPayment,
                               @Value("${bpmn.flows.gsma-link-based-payment}") String linkBasedPayment,
                               @Value("${bpmn.flows.international-remittance-payee}") String internationalRemittancePayee,
                               @Value("${bpmn.flows.international-remittance-payer}") String internationalRemittancePayer,
                               @Value("${bpmn.flows.debit-party-process}") String debitPartyProcess,
                               @Value("${institution-name}") String institutionName,
                               @Value("${rest.authorization.host}") String restAuthHost,
                               @Value("${operations.url}") String operationsUrl,
                               ZeebeClient zeebeClient,
                               ZeebeProcessStarter zeebeProcessStarter,
                               ObjectMapper objectMapper,
                               ClientProperties clientProperties,
                               RestTemplate restTemplate) {
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
        this.debitPartyProcess = debitPartyProcess;
        this.institutionName = institutionName;
        this.clientProperties = clientProperties;
        this.restTemplate = restTemplate;
        this.restAuthHost = restAuthHost;
        this.operationsUrl = operationsUrl;
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
                    extraVariables.put("DFSPID", institutionName + "-" + tenantId);
                    extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));
                    String tenantSpecificBpmn = baseTransaction.replace("{dfspid}", tenantId);
                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
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
                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class); // GSMA Object
                    TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object

                    Party payer = partyMapper(gsmaChannelRequest.getDebitParty());
                    Party payee = partyMapper(gsmaChannelRequest.getCreditParty());

                    JSONObject imu = new JSONObject();
                    imu.put("amount", gsmaChannelRequest.getAmount());
                    imu.put("from", gsmaChannelRequest.getCurrency());
                    imu.put("to", gsmaChannelRequest.getInternationalTransferInformation().getReceivingCurrency());
                    imu.put("failWhenExpired", true);

                    if(gsmaChannelRequest.getConvLockKey() != null) {
                        imu.put("lockKey", gsmaChannelRequest.getConvLockKey());
                    }
                    if(gsmaChannelRequest.getInternationalTransferInformation().getReceivingCurrency() !=null &&
                        !gsmaChannelRequest.getCurrency().equals(gsmaChannelRequest.getInternationalTransferInformation().getReceivingCurrency())) {
                        convertCurrency(tenantId, imu, gsmaChannelRequest);
                    }

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
                    extraVariables.put(PARTY_ID_TYPE, channelRequest.getPayee().getPartyIdInfo().getPartyIdType());
                    extraVariables.put(PARTY_ID, channelRequest.getPayee().getPartyIdInfo().getPartyIdentifier());
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

        from("rest:POST:/channel/transaction")
                .id("transaction-transaction")
                .log(LoggingLevel.INFO, "## CHANNEL ->  transaction")
                .unmarshal().json(JsonLibrary.Jackson, GSMATransaction.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    GSMATransaction gsmaChannelRequest = exchange.getIn().getBody(GSMATransaction.class); // GSMA Object
                    TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object

                    if("CASHIN".equalsIgnoreCase(gsmaChannelRequest.getType())){
                        exchange.getIn().setBody(deposit(tenantId, gsmaChannelRequest));
                    }else if("CASHOUT".equalsIgnoreCase(gsmaChannelRequest.getType())){
                        exchange.getIn().setBody(debitAccount(tenantId, gsmaChannelRequest));
                    }else if("SNDTOBNK".equalsIgnoreCase(gsmaChannelRequest.getType())){
                        exchange.getIn().setBody(debitAccount(tenantId, gsmaChannelRequest));
                    }else if("transfer".equalsIgnoreCase(gsmaChannelRequest.getType())){
                        exchange.getIn().setBody(intTransfer(tenantId, gsmaChannelRequest));
                    }
                });
    }

    public String deposit(String tenantId, GSMATransaction gsmaChannelRequest) throws JsonProcessingException {
        TransactionChannelRequestDTO channelRequest = new TransactionChannelRequestDTO(); // Fineract Object

        Party payer = partyMapper(gsmaChannelRequest.getDebitParty());
        Party payee = partyMapper(gsmaChannelRequest.getCreditParty());
        MoneyData amount = amountMapper(gsmaChannelRequest.getAmount(), gsmaChannelRequest.getCurrency());

        channelRequest.setPayer(payer);
        channelRequest.setPayee(payee);
        channelRequest.setAmount(amount);

        Map<String, Object> extraVariables = new HashMap<>();

        extraVariables.put(TENANT_ID, tenantId);
        String tenantSpecificBpmn = internationalRemittancePayee.replace("{dfspid}", tenantId);

        extraVariables.put(GSMA_CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaChannelRequest));
        extraVariables.put(PARTY_ID_TYPE, channelRequest.getPayee().getPartyIdInfo().getPartyIdType());
        extraVariables.put(PARTY_ID, channelRequest.getPayee().getPartyIdInfo().getPartyIdentifier());
        String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                objectMapper.writeValueAsString(channelRequest),
                extraVariables);

        RequestStateDTO gsmaResponse = new RequestStateDTO();
        gsmaResponse.setServerCorrelationId(transactionId);
        gsmaResponse.setStatus("pending");
        gsmaResponse.setNotificationMethod("polling");
        gsmaResponse.setObjectReference("");
        gsmaResponse.setPollLimit("");

        return objectMapper.writeValueAsString(gsmaResponse);
    }

    public String intTransfer(String tenantId, GSMATransaction gsmaChannelRequest) throws JsonProcessingException {
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
        return response.toString();
    }

    public String debitAccount(String tenantId, GSMATransaction gsmaChannelRequest) throws JsonProcessingException {
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

        extraVariables.put(TENANT_ID, tenantId);
        String tenantSpecificBpmn = debitPartyProcess.replace("{dfspid}", tenantId);
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
        return response.toString();
    }

    public String createBeneficiary(String tenantId, JSONObject request){

        Client client = clientProperties.getClient(tenantId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Platform-TenantId", tenantId);
        httpHeaders.add("Authorization",
                "Basic " + getEncoder().encodeToString((client.getClientId() + ":" + client.getClientSecret()).getBytes()));

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(restAuthHost + "/oauth/token?grant_type=client_credentials", HttpMethod.POST, entity, String.class);
        String token = new JSONObject(exchange.getBody()).getString("access_token");

        httpHeaders.remove("Authorization");
        httpHeaders.add("Authorization", "Bearer " + token);
        httpHeaders.add("Content-Type", "application/json");
        JSONObject reqBody = new JSONObject();

        reqBody.put("custIdentifier", "");
        reqBody.put("identifier", "");
        reqBody.put("name", "");
        reqBody.put("nickName", "");
        reqBody.put("accountNo", "");
        reqBody.put("leId", "");
        reqBody.put("currencyCode", "");
        reqBody.put("countryCode", "");

        entity = new HttpEntity<>(reqBody.toString(), httpHeaders);
        exchange = restTemplate.exchange(operationsUrl + "/beneficiary", HttpMethod.POST, entity, String.class);
        return exchange.getBody();

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
        moneyData.setAmount(amount);
        moneyData.setCurrency(currency);

        return moneyData;
    }

    public void convertCurrency(String tenantId, JSONObject convJson, GSMATransaction gsmaTransaction) throws JsonProcessingException {
        if (tenantId == null || !dfspIds.contains(tenantId)) {
            throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
        }
        Client client = clientProperties.getClient(tenantId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Platform-TenantId", tenantId);
        httpHeaders.add("Authorization",
                "Basic " + getEncoder().encodeToString((client.getClientId() + ":" + client.getClientSecret()).getBytes()));

        httpHeaders.add("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(restAuthHost + "/oauth/token?grant_type=client_credentials", HttpMethod.POST, entity, String.class);
        String token = new JSONObject(exchange.getBody()).getString("access_token");

        httpHeaders.remove("Authorization");
        httpHeaders.add("Authorization", "Bearer " + token);

        entity = new HttpEntity<>(convJson.toString(), httpHeaders);

        exchange = restTemplate.exchange(operationsUrl + "/imuexchange/preview", HttpMethod.POST, entity, String.class);

        JSONObject conv =  new JSONObject(exchange.getBody());
        String amount = conv.getBigDecimal("convertedAmount").toString();
        String rate =  conv.getBigDecimal("rate").toString();

        gsmaTransaction.getInternationalTransferInformation().setCurrencyPair(gsmaTransaction.getCurrency()+"/"+
                gsmaTransaction.getInternationalTransferInformation().getReceivingCurrency());
        gsmaTransaction.getInternationalTransferInformation().setSenderAmount(gsmaTransaction.getAmount());
        gsmaTransaction.setAmount(amount);
        gsmaTransaction.getInternationalTransferInformation().setCurrencyPairRate(rate);
        gsmaTransaction.getInternationalTransferInformation().setOriginCurrency(gsmaTransaction.getCurrency());
        gsmaTransaction.setCurrency(gsmaTransaction.getInternationalTransferInformation().getReceivingCurrency());
    }
}
