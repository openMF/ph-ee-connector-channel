package org.mifos.connector.channel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mifos.connector.channel.camel.config.Client;
import org.mifos.connector.channel.camel.config.ClientProperties;
import org.mifos.connector.channel.camel.routes.ChannelRouteBuilder;
import org.mifos.connector.channel.model.OpsTxnResponseDTO;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.mifos.connector.channel.utils.Constants;
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
    private ObjectMapper objectMapper = new ObjectMapper();

    public TxnStateResponseDTO getTxnState(Headers headers, String correlationId, String requestType) throws JsonProcessingException {
        String tenantId = (String) headers.get(Constants.PLATFORM_TENANT_ID);
        validateTenantId(tenantId);

        Client client = clientProperties.getClient(tenantId);
        requestType = routeBuilder.getRequestType(requestType);
        HttpEntity<String> entity = routeBuilder.buildHeader(tenantId, null);

        if (operationsAuthEnabled) {
            performAuth(tenantId, client, entity);
        } else {
            entity = routeBuilder.buildHeader(tenantId, null);
        }

        ResponseEntity<String> responseEntity = routeBuilder.callOpsTxnApiUsingWebClient(requestType, correlationId, entity);
        JsonNode contentNode = objectMapper.readTree(responseEntity.getBody()).get(Constants.CONTENT);
        OpsTxnResponseDTO txnResponseDTO = objectMapper.treeToValue(contentNode.get(0), OpsTxnResponseDTO.class);

        TransactionStatusResponseDTO response = processContents(correlationId, txnResponseDTO, entity, responseEntity);

        TxnStateResponseDTO responseDTO = new TxnStateResponseDTO();
        responseDTO.setTransactionId(response.getTransactionId());
        responseDTO.setTransferState(String.valueOf(response.getTransferState()));

        return responseDTO;
    }

    private void validateTenantId(String tenantId) {
        if (tenantId == null || !dfspIds.contains(tenantId)) {
            throw new RuntimeException("Requested tenant not configured in the connector!");
        }
    }

    private void performAuth(String tenantId, Client client, HttpEntity<String> entity) {
        UriComponentsBuilder builder = routeBuilder.buildParams(client);
        ResponseEntity<String> responseEntity = routeBuilder.callAuthApi(builder, entity);
        JSONObject jsonObject = new JSONObject(responseEntity.getBody());
        String token = jsonObject.getString(Constants.ACCESS_TOKEN);
        entity = routeBuilder.buildHeader(tenantId, token);
    }

    private TransactionStatusResponseDTO processContents(String correlationId, OpsTxnResponseDTO txnResponseDTO, HttpEntity<String> entity,
            ResponseEntity<String> responseEntity) {
        TransactionStatusResponseDTO response = new TransactionStatusResponseDTO();
        if (txnResponseDTO == null) {
            response = routeBuilder.setTxnNotFound(response, correlationId);
        } else {
            response = routeBuilder.setTxnFound(response, txnResponseDTO);

            responseEntity = routeBuilder.fetchApibyWorkflowKey(entity, txnResponseDTO.getWorkflowInstanceKey());
            JSONArray variables = new JSONObject(responseEntity.getBody()).getJSONArray(Constants.VARIABLES);
            String transferCode = routeBuilder.getVariableValue(variables.iterator(), Constants.TRANSFER_CODE);
            response.setTransferId(transferCode == null ? null : transferCode.replace("\"", ""));
            response.setClientRefId(correlationId);
        }
        return response;
    }
}
