package org.mifos.connector.channel.transactions;

import io.zeebe.client.ZeebeClient;
import org.apache.camel.LoggingLevel;
import org.json.JSONObject;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.phee.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.phee.common.mojaloop.type.TransferState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.mifos.connector.channel.camel.config.CamelProperties.TRANSACTION_ID;
import static org.mifos.connector.channel.camel.config.CamelProperties.TRANSFER_STATE;
import static org.mifos.connector.channel.zeebe.ZeebeMessages.OPERATOR_MANUAL_RECOVERY;

@Component
public class TransactionsRouteBuilder extends ErrorHandlerRouteBuilder {

    @Value("${bpmn.flows.payment-transfer}")
    private String paymentTransferFlow;

    @Autowired
    private ZeebeProcessStarter zeebeProcessStarter;

    @Autowired
    private ZeebeClient zeebeClient;

    public TransactionsRouteBuilder() {
        super.configure();
    }

    @Override
    public void configure() {
        from("rest:POST:/channel/transactions")
                .id("inbound-payment-request")
                .log(LoggingLevel.INFO, "## channel -> hub inbound payment request")
                .process(exchange -> zeebeProcessStarter.startZeebeWorkflow(paymentTransferFlow, exchange.getIn().getBody(String.class), variables -> {
                }));

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
                            .send();
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
                            .send();

                    zeebeClient.newUpdateRetriesCommand(incident.getLong("jobKey"))
                            .retries(incident.getInt("newRetries"))
                            .send();

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send();
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
                            .send();

                    zeebeClient.newResolveIncidentCommand(incident.getLong("key"))
                            .send();
                });
    }
}