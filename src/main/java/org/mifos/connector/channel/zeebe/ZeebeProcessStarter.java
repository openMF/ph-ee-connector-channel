package org.mifos.connector.channel.zeebe;

import org.mifos.connector.channel.camel.config.CamelProperties;
import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * Start a Zeebe workflow
 */
@Component
public class ZeebeProcessStarter {
    private static Logger logger = LoggerFactory.getLogger(ZeebeProcessStarter.class);

    @Autowired
    private ZeebeClient zeebeClient;

    public void startZeebeWorkflow(String workflowId, String request, Consumer<Map<String, Object>> variablesLambda) {
        String transactionId = generateTransactionId();

        Map<String, Object> variables = new HashMap<>();
        variables.put(CamelProperties.TRANSACTION_ID, transactionId);
        variables.put(CamelProperties.TRANSACTION_REQUEST, request);
        variables.put(CamelProperties.ORIGIN_DATE, Instant.now().toEpochMilli());
        variablesLambda.accept(variables);

        // TODO if successful transfer response arrives in X timeout return it otherwise do callback
        WorkflowInstanceEvent join = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(workflowId)
                .latestVersion()
                .variables(variables)
                .send()
                .join();

        logger.info("zeebee workflow instance from process {} started with transactionId {}", workflowId, transactionId);
    }

    // TODO generate proper cluster-safe transaction id
    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
