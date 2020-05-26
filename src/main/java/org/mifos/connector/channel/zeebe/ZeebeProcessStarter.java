package org.mifos.connector.channel.zeebe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zeebe.client.ZeebeClient;
import io.zeebe.client.api.response.WorkflowInstanceEvent;
import org.mifos.connector.channel.camel.config.CamelProperties;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
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

    @Autowired
    private ObjectMapper objectMapper;

    public void startZeebeWorkflow(String workflowId, String request, TransactionType transactionType, Map<String, Object> extraVariables) throws JsonProcessingException {
        String transactionId = generateTransactionId();

        Map<String, Object> variables = new HashMap<>();
        variables.put(CamelProperties.TRANSACTION_ID, transactionId);

        TransactionChannelRequestDTO channelRequest = objectMapper.readValue(request, TransactionChannelRequestDTO.class);
        channelRequest.setTransactionType(transactionType);

        variables.put(CamelProperties.CHANNEL_REQUEST, objectMapper.writeValueAsString(channelRequest));
        variables.put(CamelProperties.ORIGIN_DATE, Instant.now().toEpochMilli());
        if(extraVariables != null) {
            variables.putAll(extraVariables);
        }

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
