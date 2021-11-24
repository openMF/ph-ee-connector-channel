package org.mifos.connector.channel.zeebe;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Start a Zeebe workflow
 */
@Component
public class ZeebeProcessStarter {
    private static Logger logger = LoggerFactory.getLogger(ZeebeProcessStarter.class);

    @Autowired
    private ZeebeClient zeebeClient;


    public String startZeebeWorkflow(String workflowId, String request, Map<String, Object> extraVariables) {
        String transactionId = generateTransactionId();

        Map<String, Object> variables = new HashMap<>();
        variables.put(ZeebeVariables.TRANSACTION_ID, transactionId);
        variables.put(ZeebeVariables.CHANNEL_REQUEST, request);
        variables.put(ZeebeVariables.ORIGIN_DATE, Instant.now().toEpochMilli());
        if (extraVariables != null) {
            variables.putAll(extraVariables);
        }

        logger.info("starting workflow HERE:");
        // TODO if successful transfer response arrives in X timeout return it otherwise do callback
        ProcessInstanceEvent instance = zeebeClient.newCreateInstanceCommand()
                .bpmnProcessId(workflowId)
                .latestVersion()
                .variables(variables)
                .send()
                .join();

        logger.info("zeebee workflow instance from process {} started with transactionId {}, instance key: {}", workflowId, transactionId, instance.getProcessInstanceKey());
        return transactionId;
    }

    // TODO generate proper cluster-safe transaction id
    private String generateTransactionId() {
        return UUID.randomUUID().toString();
    }
}
