package org.mifos.connector.channel.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mifos.connector.channel.camel.config.Client;
import org.mifos.connector.channel.camel.config.ClientProperties;
import org.mifos.connector.channel.camel.routes.ChannelRouteBuilder;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.common.channel.dto.TransactionStatusResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class TxnStateService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ChannelRouteBuilder routeBuilder;
    @Autowired
    private ClientProperties clientProperties;
    @Value("#{'${dfspids}'.split(',')}")
    private List<String> dfspIds;
    @Value("${operations.auth-enabled}")
    private Boolean operationsAuthEnabled;

    public TxnStateResponseDTO getTxnState(Headers headers, String correlationId, String requestType)
            throws JsonProcessingException {
        String tenantId = (String) headers.get("Platform-TenantId");
        if (tenantId == null || !dfspIds.contains(tenantId)) {
            throw new RuntimeException("Requested tenant " + tenantId + " not configured in the connector!");
        }

        Client client = clientProperties.getClient(tenantId);
        requestType = routeBuilder.getRequestType(requestType);
        HttpEntity<String> entity = routeBuilder.buildHeader(tenantId, null);

        if (operationsAuthEnabled) {
            UriComponentsBuilder builder = routeBuilder.buildParams(client);
            ResponseEntity<String> exchange = routeBuilder.callAuthApi(builder, entity);
            JSONObject jsonObject = new JSONObject(exchange.getBody());
            String token = jsonObject.getString("access_token");
            entity = routeBuilder.buildHeader(tenantId, token);
        } else {
            entity = routeBuilder.buildHeader(tenantId, null);
        }

        ResponseEntity<String> exchange = routeBuilder.callOpsTxnApi(requestType, correlationId, entity);
        JSONArray contents = new JSONObject(exchange.getBody()).getJSONArray("content");

        TransactionStatusResponseDTO response = new TransactionStatusResponseDTO();
        if (contents.length() != 1) {
            response = routeBuilder.setTxnNotFound(response, correlationId);
        } else {
            JSONObject transfer = contents.getJSONObject(0);
            response = routeBuilder.setTxnFound(response, transfer);

            exchange = routeBuilder.fetchApibyWorkflowKey(entity, transfer.getLong("workflowInstanceKey"));
            JSONArray variables = new JSONObject(exchange.getBody()).getJSONArray("variables");
            String transferCode = routeBuilder.getVariableValue(variables.iterator(), "transferCode");
            response.setTransferId(transferCode == null ? null : transferCode.replace("\"", ""));
            response.setClientRefId(correlationId);
        }
        logger.info("response is : {}", response);
        TxnStateResponseDTO responseDTO = new TxnStateResponseDTO();
        responseDTO.setTransactionId(response.getTransactionId());
        responseDTO.setTransferState(String.valueOf(response.getTransferState()));

        logger.info("responseDTO is : {}", response);

        return responseDTO;
    }
}
