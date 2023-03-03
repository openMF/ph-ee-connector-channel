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
import org.mifos.connector.channel.GSMA_API.GsmaP2PResponseDto;
import org.mifos.connector.channel.camel.config.Client;
import org.mifos.connector.channel.camel.config.ClientProperties;
import org.mifos.connector.channel.utils.AMSProps;
import org.mifos.connector.channel.utils.AMSUtils;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.connector.common.camel.AuthProcessor;
import org.mifos.connector.common.camel.AuthProperties;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.connector.common.channel.dto.RegisterAliasRequestDTO;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.channel.dto.TransactionStatusResponseDTO;
import org.mifos.connector.common.gsma.dto.GsmaTransfer;
import org.mifos.connector.common.mojaloop.dto.FspMoneyData;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
import org.mifos.connector.common.mojaloop.type.TransferState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static java.util.Base64.getEncoder;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;
import static org.mifos.connector.channel.camel.config.CamelProperties.*;
import static org.mifos.connector.channel.zeebe.ZeebeMessages.OPERATOR_MANUAL_RECOVERY;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.ACCOUNT;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.CHANNEL_REQUEST;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.IS_AUTHORISATION_REQUIRED;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.IS_RTP_REQUEST;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.PARTY_ID;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.PARTY_ID_TYPE;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.AMS;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.TENANT_ID;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.TRANSACTION_ID;
import static org.mifos.connector.common.mojaloop.type.InitiatorType.CONSUMER;
import static org.mifos.connector.common.mojaloop.type.Scenario.TRANSFER;
import static org.mifos.connector.common.mojaloop.type.TransactionRole.PAYEE;
import static org.mifos.connector.common.mojaloop.type.TransactionRole.PAYER;

@Component
public class ChannelRouteBuilder extends ErrorHandlerRouteBuilder {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AMSUtils amsUtils;

    private String paymentTransferFlow;
    private String specialPaymentTransferFlow;
    private String transactionRequestFlow;
    private String partyRegistration;
    private String mpesaFlow;
    private String restAuthHost;
    private String operationsUrl;
    private Boolean operationsAuthEnabled;
    private String transfersEndpoint;
    private String transactionEndpoint;
    private Boolean isNotificationSuccessServiceEnabled;
    private Boolean isNotificationFailureServiceEnabled;
    private ZeebeProcessStarter zeebeProcessStarter;
    private ZeebeClient zeebeClient;
    private List<String> dfspIds;
    private ObjectMapper objectMapper;
    private ClientProperties clientProperties;
    private RestTemplate restTemplate;
    private String timer;
    private String restAuthHeader;

    private String paygopsHost;

    private String rosterHost;


    public ChannelRouteBuilder(@Value("#{'${dfspids}'.split(',')}") List<String> dfspIds,
                               @Value("${bpmn.flows.payment-transfer}") String paymentTransferFlow,
                               @Value("${bpmn.flows.special-payment-transfer}") String specialPaymentTransferFlow,
                               @Value("${bpmn.flows.transaction-request}") String transactionRequestFlow,
                               @Value("${bpmn.flows.party-registration}") String partyRegistration,
                               @Value("${bpmn.flows.mpesa-flow}") String mpesaFlow,
                               @Value("${rest.authorization.host}") String restAuthHost,
                               @Value("${operations.url}") String operationsUrl,
                               @Value("${operations.auth-enabled}") Boolean operationsAuthEnabled,
                               @Value("${operations.endpoint.transfers}") String transfersEndpoint,
                               @Value("${operations.endpoint.transactionReq}") String transactionEndpoint,
                               @Value("${mpesa.notification.success.enabled}") Boolean isNotificationSuccessServiceEnabled,
                               @Value("${mpesa.notification.failure.enabled}") Boolean isNotificationFailureServiceEnabled,
                               @Value("${timer}") String timer,
                               @Value("${paygops.host}") String paygopsHost,
                               @Value("${roster.host}") String rosterHost,
                               @Value("${rest.authorization.header}") String restAuthHeader,
                               ZeebeClient zeebeClient,
                               ZeebeProcessStarter zeebeProcessStarter,
                               @Autowired(required = false) AuthProcessor authProcessor,
                               @Autowired(required = false) AuthProperties authProperties,
                               ObjectMapper objectMapper,
                               ClientProperties clientProperties,
                               RestTemplate restTemplate) {
        super(authProcessor, authProperties);
        super.configure();
        this.paymentTransferFlow = paymentTransferFlow;
        this.specialPaymentTransferFlow = specialPaymentTransferFlow;
        this.transactionRequestFlow = transactionRequestFlow;
        this.mpesaFlow = mpesaFlow;
        this.partyRegistration = partyRegistration;
        this.zeebeProcessStarter = zeebeProcessStarter;
        this.zeebeClient = zeebeClient;
        this.dfspIds = dfspIds;
        this.objectMapper = objectMapper;
        this.clientProperties = clientProperties;
        this.restTemplate = restTemplate;
        this.restAuthHost = restAuthHost;
        this.operationsUrl = operationsUrl;
        this.transfersEndpoint = transfersEndpoint;
        this.transactionEndpoint = transactionEndpoint;
        this.isNotificationSuccessServiceEnabled = isNotificationSuccessServiceEnabled;
        this.isNotificationFailureServiceEnabled = isNotificationFailureServiceEnabled;
        this.timer = timer;
        this.paygopsHost=paygopsHost;
        this.rosterHost=rosterHost;
        this.restAuthHeader = restAuthHeader;
        this.operationsAuthEnabled = operationsAuthEnabled;
    }

    @Override
    public void configure() {
        handleExceptions();
        indexRoutes();
        transferRoutes();
        collectionRoutes();
        transactionRoutes();
        partyRegistrationRoutes();
        jobRoutes();
        workflowRoutes();
        acknowledgementRoutes();
        paybillRoutes();
    }
    private void handleExceptions(){
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
    }

    private void indexRoutes(){
        from("direct:get-index")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant(""));
    }

    private void transferRoutes(){
        from("direct:get-transfer-transaction-id")
                .id("transfer-details")
                .log(LoggingLevel.INFO, "## CHANNEL -> inbound transferDetail request for ${header.transactionId}")
                .process(e -> {
                    String tenantId = e.getIn().getHeader("Platform-TenantId", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                    }
                    Client client = clientProperties.getClient(tenantId);
                    HttpHeaders httpHeaders = new HttpHeaders();
                    httpHeaders.add("Platform-TenantId", tenantId);
                    httpHeaders.add("Authorization",
                            "Basic " + getEncoder().encodeToString((client.getClientId() + ":" + client.getClientSecret()).getBytes()));

                    HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
                    ResponseEntity<String> exchange = restTemplate.exchange(restAuthHost + "/oauth/token?grant_type=client_credentials", HttpMethod.POST, entity, String.class);
                    String token = new JSONObject(exchange.getBody()).getString("access_token");

                    String transactionId = e.getIn().getHeader("transactionId", String.class);

                    httpHeaders.remove("Authorization");
                    httpHeaders.add("Authorization", "Bearer " + token);
                    entity = new HttpEntity<>(null, httpHeaders);
                    exchange = restTemplate.exchange(operationsUrl + "/transfers?page=0&size=20&transactionId=" + transactionId, HttpMethod.GET, entity, String.class);
                    JSONArray contents = new JSONObject(exchange.getBody()).getJSONArray("content");

                    TransactionStatusResponseDTO response = new TransactionStatusResponseDTO();
                    if (contents.length() != 1) {
                        response.setClientRefId("000000");
                        response.setCompletedTimestamp(null);
                        response.setTransactionId(transactionId);
                        response.setTransferState(TransferState.RECEIVED);
                        response.setTransferId(null);
                    } else {
                        JSONObject transfer = contents.getJSONObject(0);
                        long workflowInstanceKey = transfer.getLong("workflowInstanceKey");
                        String status = transfer.getString("status");
                        response.setCompletedTimestamp(transfer.isNull("completedAt") ? null : LocalDateTime.ofInstant(Instant.ofEpochMilli(transfer.getLong("completedAt")), ZoneId.systemDefault()));
                        response.setTransactionId(transactionId);
                        response.setTransferState("COMPLETED".equals(status) ? TransferState.COMMITTED : TransferState.RECEIVED);

                        exchange = restTemplate.exchange(operationsUrl + "/transfer/" + workflowInstanceKey, HttpMethod.GET, entity, String.class);
                        JSONArray variables = new JSONObject(exchange.getBody()).getJSONArray("variables");
                        String transferCode = getVariableValue(variables.iterator(), "transferCode");
                        response.setTransferId(transferCode == null ? null : transferCode.replace("\"", ""));

                        String channelRequest = getVariableValue(variables.iterator(), "channelRequest");
                        if (channelRequest != null) {
                            JSONObject channelRequestJson = new JSONObject(channelRequest.substring(1, channelRequest.length() - 1)
                                    .replace("\\\"", "\""));
                            String clientRefId = channelRequestJson.optString("clientRefId", null);
                            response.setClientRefId(clientRefId == null ? "000000" : clientRefId);
                        } else {
                            response.setClientRefId("000000");
                        }
                    }

                    e.getIn().setBody(objectMapper.writeValueAsString(response));
                });

        //fetch transfer details based on client correlation id
        from("direct:get-txnState-correlationId")
                .id("transfer-details-correlationId")
                .log(LoggingLevel.INFO, "## CHANNEL -> request for txn with client correlation Id" +
                        " ${header.X-CorrelationID}")
                .process(e -> {
                    String tenantId = e.getIn().getHeader("Platform-TenantId", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");}
                    Client client = clientProperties.getClient(tenantId);
                    String requestType = getRequestType(e.getIn().getHeader("requestType", String.class));
                    HttpEntity<String> entity = buildHeader(tenantId, null);
                    if(operationsAuthEnabled){
                        UriComponentsBuilder builder = buildParams(client);
                        ResponseEntity<String> exchange = callAuthApi(builder,entity);
                        JSONObject jsonObject = new JSONObject(exchange.getBody());
                        String token = jsonObject.getString("access_token");
                        entity = buildHeader(tenantId, token);
                    }
                    else {
                        entity = buildHeader(tenantId,null);
                    }
                    String correlationId = e.getIn().getHeader(CLIENTCORRELATIONID, String.class);
                    ResponseEntity<String> exchange = callOpsTxnApi(requestType,correlationId,entity);
                    JSONArray contents = new JSONObject(exchange.getBody()).getJSONArray("content");
                    TransactionStatusResponseDTO response = new TransactionStatusResponseDTO();
                    if (contents.length() != 1) {
                        response = setTxnNotFound(response, correlationId);
                    } else {
                        JSONObject transfer = contents.getJSONObject(0);
                        response = setTxnFound(response, transfer);
                        exchange = fetchApibyWorkflowKey(entity,transfer.getLong("workflowInstanceKey"));
                        JSONArray variables = new JSONObject(exchange.getBody()).getJSONArray("variables");
                        String transferCode = getVariableValue(variables.iterator(), "transferCode");
                        response.setTransferId(transferCode == null ? null :
                                transferCode.replace("\"", ""));
                        response.setClientRefId(correlationId);
                    }e.getIn().setBody(objectMapper.writeValueAsString(response));
                });

        from("direct:post-transfer")
                .id("inbound-transaction-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PAYER inbound transfer request: ${body}")
                .unmarshal().json(JsonLibrary.Jackson, TransactionChannelRequestDTO.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    Map<String, Object> extraVariables = new HashMap<>();
                    extraVariables.put(IS_RTP_REQUEST, false);

                    // adding batchId zeebeVariable form header
                    String batchIdHeader = exchange.getIn().getHeader(BATCH_ID, String.class);
                    extraVariables.put(BATCH_ID, batchIdHeader);

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                    }
                    extraVariables.put(TENANT_ID, tenantId);

                    TransactionChannelRequestDTO channelRequest = exchange.getIn().getBody(TransactionChannelRequestDTO.class);
                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYER);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(TRANSFER);
                    channelRequest.setTransactionType(transactionType);
                    extraVariables.put("initiator", transactionType.getInitiator().name());
                    extraVariables.put("initiatorType", transactionType.getInitiatorType().name());
                    extraVariables.put("scenario", transactionType.getScenario().name());
                    extraVariables.put("amount", new FspMoneyData(channelRequest.getAmount().getAmountDecimal(), channelRequest.getAmount().getCurrency()));

                    String tenantSpecificBpmn;
                    if(channelRequest.getPayer().getPartyIdInfo().getPartyIdentifier().startsWith("6666")) {
                        tenantSpecificBpmn = specialPaymentTransferFlow.replace("{dfspid}", tenantId);
                        extraVariables.put("specialTermination", true);
                    } else {
                        tenantSpecificBpmn = paymentTransferFlow.replace("{dfspid}", tenantId);
                        extraVariables.put("specialTermination", false);
                    }

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });
    }

    private ResponseEntity<String> fetchApibyWorkflowKey(HttpEntity<String> entity, long workflowInstanceKey) {
        return restTemplate.exchange(operationsUrl + "/transfer/" +
              workflowInstanceKey, HttpMethod.GET, entity, String.class);
    }

    private ResponseEntity<String> callOpsTxnApi(String requestType, String correlationId, HttpEntity<String> entity) {
        return restTemplate.exchange(operationsUrl + requestType +"clientCorrelationId=" +
                correlationId, HttpMethod.GET, entity, String.class);
    }

    private ResponseEntity<String> callAuthApi(UriComponentsBuilder builder, HttpEntity<String> entity) {
       return restTemplate.exchange(builder.toUriString(), HttpMethod.POST,
                entity, String.class);
    }

    private String getRequestType(String requestType) {
        requestType = requestType.isEmpty() ? "transfers" : requestType;
        requestType = requestType.equalsIgnoreCase("transfers") ? transfersEndpoint :
                transactionEndpoint;
        return requestType;
    }

    private void collectionRoutes(){
        from("direct:post-collection")
                .id("mpesa-payment-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> MPESA transaction request")
                .to("bean-validator:request") // todo revisit function is breaking
                .process(exchange -> {

                    amsUtils.postConstruct();


                    Map<String, Object> extraVariables = new HashMap<>();
                    extraVariables.put("initiator", "PAYEE");
                    extraVariables.put("initiatorType", "BUSINESS");
                    extraVariables.put("scenario", "MPESA");


                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    String clientCorrelationId = exchange.getIn().getHeader("X-CorrelationID", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                    }
                    extraVariables.put(TENANT_ID, tenantId);
                    String tenantSpecificBpmn;

                    String channelRequestBodyString = exchange.getIn().getBody(String.class);
                    JSONObject body = new JSONObject(channelRequestBodyString);
                    JSONArray payer = body.getJSONArray("payer");
                    String primaryIdentifierVal = "";
                    String  secondaryIdentifierVal = "";
                    String primaryIdentifierName = "";
                    String  secondaryIdentifierName = "";
                    String finalAmsVal = "value";
                    primaryIdentifierName= ((JSONObject) payer.get(0)).getString("key");
                    secondaryIdentifierName = ((JSONObject) payer.get(1)).getString("key");
                    primaryIdentifierVal = ((JSONObject) payer.get(0)).getString("value");
                    secondaryIdentifierVal = ((JSONObject) payer.get(1)).getString("value");
                    for ( AMSProps.AMS amsIdentifier : amsUtils.postConstruct()) {
                        logger.info("KEY VALUE PAIR : " + amsIdentifier.getIdentifier() + " " + amsIdentifier.getValue());
                        String identifier = amsIdentifier.getIdentifier();
                        if (identifier.equalsIgnoreCase(secondaryIdentifierName)) {
                            finalAmsVal = amsIdentifier.getValue();
                            logger.info("Assigned from secondary" + finalAmsVal);
                            break;
                        }
                        else if(identifier.equalsIgnoreCase(primaryIdentifierName)){
                            finalAmsVal = amsIdentifier.getValue();
                            // logic to keep correct primary/secondary identifier for line 345-346
                            String temp = primaryIdentifierVal;
                            primaryIdentifierVal = secondaryIdentifierVal;
                            secondaryIdentifierVal = temp;
                            logger.info("Assigned from primary" + finalAmsVal);
                            break;
                        }
                        else {
                            if(identifier.equalsIgnoreCase("default")){
                                finalAmsVal = amsIdentifier.getDefaultValue();
                                logger.info("Assigned default from secondary" + finalAmsVal);
                            }


                        }
                    }//end for loop

                    logger.info("Final Value for ams : " + finalAmsVal);
                    extraVariables.put(AMS,finalAmsVal);
                    tenantSpecificBpmn = mpesaFlow.replace("{dfspid}", tenantId)
                                 .replace("{ams}",finalAmsVal);

                    String amount = body.getJSONObject("amount").getString("amount");

                    extraVariables.put("accountId", secondaryIdentifierVal);
                    extraVariables.put("phoneNumber", primaryIdentifierVal);
                    extraVariables.put("amount", amount);
                    extraVariables.put("isNotificationsSuccessEnabled", isNotificationSuccessServiceEnabled);
                    extraVariables.put("isNotificationsFailureEnabled", isNotificationFailureServiceEnabled);
                    extraVariables.put("timer",timer);
                    extraVariables.put("clientCorrelationId", clientCorrelationId);


                    String transactionId = zeebeProcessStarter.startMpesaZeebeWorkflow(tenantSpecificBpmn,
                            channelRequestBodyString,
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });
    }

    private void transactionRoutes(){
        from("direct:post-transaction-request")
                .id("inbound-payment-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PAYEE inbound transaction request")
                .unmarshal().json(JsonLibrary.Jackson, TransactionChannelRequestDTO.class)
                .to("bean-validator:request")// todo revisit function is breaking
                .process(exchange -> {
                    Map<String, Object> extraVariables = new HashMap<>();
                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYEE);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(TRANSFER);
                    extraVariables.put("initiator", transactionType.getInitiator().name());
                    extraVariables.put("initiatorType", transactionType.getInitiatorType().name());
                    extraVariables.put("scenario", transactionType.getScenario().name());

                    extraVariables.put(IS_RTP_REQUEST, true);
//                    variables.put(AUTH_RETRIES_LEFT, 3); // TODO if auth enabled
                    extraVariables.put(IS_AUTHORISATION_REQUIRED, false); // TODO how to decide?
                    extraVariables.put(AUTH_TYPE, "NONE");

                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                    }
                    extraVariables.put(TENANT_ID, tenantId);
                    String tenantSpecificBpmn = transactionRequestFlow.replace("{dfspid}", tenantId);

                    TransactionChannelRequestDTO channelRequest = exchange.getIn().getBody(TransactionChannelRequestDTO.class);
                    channelRequest.setTransactionType(transactionType);

                    String transactionId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            extraVariables);
                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    exchange.getIn().setBody(response.toString());
                });

        from("direct:post-transaction-resolve")
                .id("transaction-resolve")
                .log(LoggingLevel.INFO, "## operator transaction resolve")
                .process(e -> {
                    Map<String, Object> variables = new HashMap<>();
                    JSONObject request = new JSONObject(e.getIn().getBody(String.class));
                    request.keys().forEachRemaining(k -> {
                        variables.put(k, request.get(k));
                    });

                    zeebeClient.newPublishMessageCommand()
                            .messageName(OPERATOR_MANUAL_RECOVERY)
                            .correlationKey(e.getIn().getHeader(TRANSACTION_ID, String.class))
                            .timeToLive(Duration.ofMillis(30000))
                            .variables(variables)
                            .send()
                    ;
                })
                .setBody(constant((Object) null));
    }

    private void partyRegistrationRoutes(){
        from("direct:post-party-registration")
                .id("inbound-party-registration-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PHEE inbound party registration request")
                .unmarshal().json(JsonLibrary.Jackson, RegisterAliasRequestDTO.class)
                .to("bean-validator:request")
                .process(exchange -> {
                    String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                    if (tenantId == null || !dfspIds.contains(tenantId)) {
                        throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                    }
                    RegisterAliasRequestDTO channelRequest = exchange.getIn().getBody(RegisterAliasRequestDTO.class);
                    Map<String, Object> variables = new HashMap<>();
                    variables.put(TENANT_ID, tenantId);
                    variables.put(PARTY_ID_TYPE, channelRequest.getIdType().name());
                    variables.put(PARTY_ID, channelRequest.getIdValue());
                    variables.put(ACCOUNT, channelRequest.getAccountId());
                    String tenantSpecificBpmn = partyRegistration.replace("{dfspid}", tenantId);

                    zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                            objectMapper.writeValueAsString(channelRequest),
                            variables);
                })
                .setBody(constant((Object) null));
    }

    private void jobRoutes(){
        from("direct:post-job-resolve")
                .id("job-resolve")
                .log(LoggingLevel.INFO, "## operator job resolve")
                .process(e -> {
                    JSONObject request = new JSONObject(e.getIn().getBody(String.class));
                    JSONObject incident = request.getJSONObject("incident");
                    Map<String, Object> newVariables = new HashMap<>();
                    JSONObject requestedVariables = request.getJSONObject("variables");
                    requestedVariables.keys().forEachRemaining(k -> {
                        newVariables.put(k, requestedVariables.get(k));
                    });

                    zeebeClient.newSetVariablesCommand(incident.getLong("elementInstanceKey"))
                            .variables(newVariables)
                            .send()
                    ;

                    zeebeClient.newUpdateRetriesCommand(incident.getLong("jobKey"))
                            .retries(incident.getInt("newRetries"))
                            .send()
                    ;

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send()
                    ;
                })
                .setBody(constant((Object) null));

    }

    private void workflowRoutes(){
        from("direct:post-workflow-resolve")
                .id("workflow-resolve")
                .log(LoggingLevel.INFO, "## operator workflow resolve")
                .process(e -> {
                    JSONObject request = new JSONObject(e.getIn().getBody(String.class));
                    JSONObject incident = request.getJSONObject("incident");
                    Map<String, Object> newVariables = new HashMap<>();
                    JSONObject requestedVariables = request.getJSONObject("variables");
                    requestedVariables.keys().forEachRemaining(k -> {
                        newVariables.put(k, requestedVariables.get(k));
                    });

                    zeebeClient.newSetVariablesCommand(incident.getLong("elementInstanceKey"))
                            .variables(newVariables)
                            .send()
                    ;

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send()
                    ;
                })
                .setBody(constant((Object) null));

        from("direct:post-workflow-instanceKey-cancel")
                .id("workflow-cancel")
                .log(LoggingLevel.INFO, "## operator workflow cancel ${header.workflowInstanceKey}")
                .process(e -> zeebeClient.newCancelInstanceCommand(Long.parseLong(e.getIn().getHeader("workflowInstanceKey", String.class)))
                        .send()
                )
                .setBody(constant((Object) null));
    }

    private void acknowledgementRoutes(){
        String id = "invoke-ack-workers";
        from("direct:" + id)
                .id(id)
                .log(LoggingLevel.INFO, "## CHANNEL -> Ack transaction request")
                .process(exchange -> {
                    // fetch transaction ids and batch id
                    Collection<String> transactionIds = exchange.getProperty("successfulTxIds", ArrayList.class);
                    String batchId = (String) exchange.getProperty(BATCH_ID);
                    for(String transactionId: transactionIds){
                        Map<String, Object> extraVariables = new HashMap<>();

                        String tenantId = exchange.getIn().getHeader("Platform-TenantId", String.class);
                        if (tenantId == null || !dfspIds.contains(tenantId)) {
                            throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
                        }
                        extraVariables.put(TENANT_ID, tenantId);

                        String tenantSpecificBpmn = mpesaFlow.replace("{dfspid}", tenantId);

                        String instanceId = zeebeProcessStarter.startZeebeWorkflow(tenantSpecificBpmn,
                                exchange.getIn().getBody(String.class),
                                extraVariables);
                        JSONObject response = new JSONObject();
                        response.put("instanceId", instanceId);
                        response.put("transactionId", transactionId);
                        response.put("batchId", batchId);
                        exchange.getIn().setBody(response.toString());
                    }
                });
    }
    private void paybillRoutes()
    {
        from("direct:post-validation-ams")
                .id("validation-ams")
                .log(LoggingLevel.INFO, "Validation Check for identifier type paygops")
                .process(e -> {
                    String paybillRequestBodyString = e.getIn().getBody(String.class);
                    logger.info("Payload : {}",paybillRequestBodyString);
                    JSONObject body = new JSONObject(paybillRequestBodyString);
                    String amsURL="";
                    // Finding the AMS connector
                    String finalAmsVal = amsUtils.getAMSName(body);
                    if(finalAmsVal.equalsIgnoreCase("paygops"))
                    {
                        amsURL=paygopsHost;
                    }
                    else if(finalAmsVal.equalsIgnoreCase("roster"))
                    {
                        amsURL=rosterHost;
                    }
                    logger.debug("Final Value for ams : " + finalAmsVal);
                    logger.debug("AMS URL : {}",amsURL);
                    e.getIn().setBody(body.toString());
                    e.setProperty("amsURL",amsURL);
                    e.setProperty("finalAmsVal",finalAmsVal);
                }).log("${header.amsURL},${header.finalAmsVal}")
                .toD("${header.amsURL}/api/v1/paybill/validate/${header.finalAmsVal}?bridgeEndpoint=true");

        from("direct:post-gsma-transaction")
                .id("gsma-transfer")
                .unmarshal().json(JsonLibrary.Jackson, GsmaTransfer.class)
                .log(LoggingLevel.INFO,"GSMA Transfer Body")
                .process(e->{
                    GsmaTransfer gsmaTranfer=e.getIn().getBody(GsmaTransfer.class);
                    logger.info("Gsma Transfer DTO : {}",String.valueOf(gsmaTranfer));
                    String subtype=gsmaTranfer.getSubType();
                    String type=gsmaTranfer.getType();
                    String amsName= e.getIn().getHeader("amsName").toString();
                    String accountHoldingInstitutionId=e.getIn().getHeader("accountHoldingInstitutionId").toString();
                    // inbound-transfer-mifos-lion
                    Map<String, Object> variables = new HashMap<>();
                    variables.put(TENANT_ID,accountHoldingInstitutionId);
                    variables.put(CHANNEL_REQUEST, objectMapper.writeValueAsString(gsmaTranfer));
                    String workflowName=new StringBuilder().append(subtype).append("_").append(type).append("-").append(amsName).append("-").append(accountHoldingInstitutionId).toString();
                    logger.info("Workflow Name:{}",workflowName);
                    String transactionId = zeebeProcessStarter.startZeebeWorkflowC2B(workflowName, variables);
                    GsmaP2PResponseDto responseDto = new GsmaP2PResponseDto();
                    responseDto.transactionId = transactionId;

                    JSONObject response = new JSONObject();
                    response.put("transactionId", transactionId);
                    e.getIn().setBody(response.toString());
                });
    }

    private String getVariableValue(Iterator<Object> iterator, String variableName) {
        String value = stream(spliteratorUnknownSize(iterator, Spliterator.ORDERED), false)
                .map(v -> (JSONObject) v)
                .filter(v -> variableName.equals(v.getString("name")))
                .findFirst()
                .map(v -> v.getString("value"))
                .orElse(null);
        logger.debug("Variable {} found, value: {}", variableName, value);
        return value;
    }

    private TransactionStatusResponseDTO setTxnFound(TransactionStatusResponseDTO response, JSONObject transfer) {
        String status = transfer.has("status")  ? transfer.getString("status") :
                transfer.getString("state");
        response.setCompletedTimestamp(transfer.isNull("completedAt") ? null :
                LocalDateTime.ofInstant(Instant.ofEpochMilli(transfer.getLong("completedAt")), ZoneId.systemDefault()));
        response.setTransactionId(transfer.getString("transactionId"));
        response.setTransferState("COMPLETED".equals(status) ? TransferState.COMMITTED : TransferState.RECEIVED);
        return response;
    }

    private TransactionStatusResponseDTO setTxnNotFound(TransactionStatusResponseDTO response, String correlationId) {
        logger.debug("Transaction not found for correlationId: {}", correlationId);
        response.setClientRefId(correlationId);
        response.setCompletedTimestamp(null);
        response.setTransactionId(null);
        response.setTransferState(TransferState.RECEIVED);
        response.setTransferId(null);
        return response;
    }

    private UriComponentsBuilder buildParams(Client client) {
        HttpsURLConnection.setDefaultHostnameVerifier((restAuthHost, session) -> true);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(restAuthHost + "/oauth/token")
                // Add query parameter
                .queryParam("username", client.getClientId())
                .queryParam("password", client.getClientSecret())
                .queryParam("grant_type", "password");
        logger.debug("Builder : {}", builder.toUriString());
        return builder;
    }

    private HttpEntity<String> buildHeader(String tenantId, String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        if (token == null) {
            httpHeaders.add("Platform-TenantId", tenantId);
            httpHeaders.add("Authorization", restAuthHeader);
            logger.debug("Headers {}", httpHeaders.toSingleValueMap());
        } else {
            httpHeaders.add("Platform-TenantId", tenantId);
            httpHeaders.remove("Authorization");
            httpHeaders.add("Authorization", "Bearer " + token);
        }
        HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
        return entity;
    }
}
