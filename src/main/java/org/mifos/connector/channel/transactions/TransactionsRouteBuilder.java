package org.mifos.connector.channel.transactions;

import io.zeebe.client.ZeebeClient;
import org.apache.camel.LoggingLevel;
import org.json.JSONObject;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.mifos.connector.common.camel.AuthProcessor;
import org.mifos.connector.common.camel.AuthProperties;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.mifos.connector.channel.camel.config.CamelProperties.TRANSACTION_ID;
import static org.mifos.connector.channel.zeebe.ZeebeMessages.OPERATOR_MANUAL_RECOVERY;

@Component
public class TransactionsRouteBuilder extends ErrorHandlerRouteBuilder {

    private String paymentTransferFlow;
    private ZeebeProcessStarter zeebeProcessStarter;
    private ZeebeClient zeebeClient;

    public TransactionsRouteBuilder(@Value("${bpmn.flows.payment-transfer}") String paymentTransferFlow,
                                    ZeebeClient zeebeClient,
                                    ZeebeProcessStarter zeebeProcessStarter,
                                    @Autowired(required = false) AuthProcessor authProcessor,
                                    @Autowired(required = false) AuthProperties authProperties) {
        super(authProcessor, authProperties);
        super.configure();
        this.paymentTransferFlow = paymentTransferFlow;
        this.zeebeProcessStarter = zeebeProcessStarter;
        this.zeebeClient = zeebeClient;
    }

    @Override
    public void configure() {
        from("rest:POST:/channel/transactions")
                .id("inbound-payment-request")
                .log(LoggingLevel.INFO, "## CHANNEL -> PAYER inbound payment request")
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