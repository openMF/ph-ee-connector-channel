package org.mifos.connector.channel.api.implementation;

import static org.mifos.connector.channel.camel.config.CamelProperties.BATCH_ID;
import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.TransferApi;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.channel.dto.TransactionStatusResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferApiController implements TransferApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public GsmaP2PResponseDto transfer(String tenant, String batchId, String correlationId, TransactionChannelRequestDTO requestBody)
            throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder().addHeader("Platform-TenantId", tenant).addHeader(BATCH_ID, batchId)
                .addHeader(CLIENTCORRELATIONID, correlationId).build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers,
                objectMapper.writeValueAsString(requestBody));
        logger.info("Client correlation id: " + correlationId);
        logger.info("Batch id: " + batchId);
        producerTemplate.send("direct:post-transfer", exchange);
        String responseBody = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(responseBody, GsmaP2PResponseDto.class);
    }

    @Override
    public TransactionStatusResponseDTO transferId(String transactionId, String tenant) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder().addHeader("Platform-TenantId", tenant).addHeader("transactionId", transactionId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers, null);
        producerTemplate.send("direct:get-transfer-transaction-id", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, TransactionStatusResponseDTO.class);
    }
}
