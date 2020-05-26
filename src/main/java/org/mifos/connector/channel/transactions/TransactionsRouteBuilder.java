package org.mifos.connector.channel.transactions;

import io.zeebe.client.ZeebeClient;
import org.apache.camel.LoggingLevel;
import org.json.JSONObject;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.connector.common.camel.AuthProcessor;
import org.mifos.connector.common.camel.AuthProperties;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.mifos.connector.channel.camel.config.CamelProperties.TRANSACTION_ID;
import static org.mifos.connector.channel.zeebe.ZeebeExpressionVariables.AUTH_RETRIES_LEFT;
import static org.mifos.connector.channel.zeebe.ZeebeExpressionVariables.IS_AUTHORISATION_REQUIRED;
import static org.mifos.connector.channel.zeebe.ZeebeExpressionVariables.IS_RTP_REQUEST;
import static org.mifos.connector.channel.zeebe.ZeebeMessages.OPERATOR_MANUAL_RECOVERY;
import static org.mifos.connector.common.mojaloop.type.InitiatorType.CONSUMER;
import static org.mifos.connector.common.mojaloop.type.Scenario.TRANSFER;
import static org.mifos.connector.common.mojaloop.type.Scenario.WITHDRAWAL;
import static org.mifos.connector.common.mojaloop.type.TransactionRole.PAYEE;
import static org.mifos.connector.common.mojaloop.type.TransactionRole.PAYER;

@Component
public class TransactionsRouteBuilder extends ErrorHandlerRouteBuilder {

    private String paymentTransferFlow;
    private String paymentRequestFlow;
    private ZeebeProcessStarter zeebeProcessStarter;
    private ZeebeClient zeebeClient;

    public TransactionsRouteBuilder(@Value("${bpmn.flows.payment-transfer}") String paymentTransferFlow,
                                    @Value("${bpmn.flows.payment-request}") String paymentRequestFlow,
                                    ZeebeClient zeebeClient,
                                    ZeebeProcessStarter zeebeProcessStarter,
                                    @Autowired(required = false) AuthProcessor authProcessor,
                                    @Autowired(required = false) AuthProperties authProperties) {
        super(authProcessor, authProperties);
        super.configure();
        this.paymentTransferFlow = paymentTransferFlow;
        this.paymentRequestFlow = paymentRequestFlow;
        this.zeebeProcessStarter = zeebeProcessStarter;
        this.zeebeClient = zeebeClient;
    }

    @Override
    public void configure() {
        from("rest:POST:/channel/transfer")
                .id("inbound-transaction-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PAYER inbound transfer request")
                .process(exchange -> {
                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYER);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(WITHDRAWAL);

                    Map<String, Object> extraVariables = new HashMap<>();
                    extraVariables.put(IS_RTP_REQUEST, false);

                    zeebeProcessStarter.startZeebeWorkflow(paymentTransferFlow, exchange.getIn().getBody(String.class), transactionType,extraVariables);
                });

        from("rest:POST:/channel/transactionRequest")
                .id("inbound-payment-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PAYEE inbound transaction request")
                .process(exchange -> {
                    TransactionType transactionType = new TransactionType();
                    transactionType.setInitiator(PAYEE);
                    transactionType.setInitiatorType(CONSUMER);
                    transactionType.setScenario(TRANSFER);

                    Map<String, Object> variables = new HashMap<>();
                    variables.put(IS_RTP_REQUEST, true);
//                    variables.put(AUTH_RETRIES_LEFT, 3); // TODO if auth enabled
                    variables.put(IS_AUTHORISATION_REQUIRED, false); // TODO how to decide?
                    zeebeProcessStarter.startZeebeWorkflow(paymentRequestFlow, exchange.getIn().getBody(String.class), transactionType, variables);
                });

        from("rest:POST:/channel/transaction/{" + TRANSACTION_ID + "}/resolve")
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
                            .join();
                });

        from("rest:POST:/channel/job/resolve")
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
                            .join();

                    zeebeClient.newUpdateRetriesCommand(incident.getLong("jobKey"))
                            .retries(incident.getInt("newRetries"))
                            .send()
                            .join();

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send()
                            .join();
                });

        from("rest:POST:/channel/workflow/resolve")
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
                            .join();

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send()
                            .join();
                });
    }
}