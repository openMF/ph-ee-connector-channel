package org.mifos.connector.channel.gsma_api;

import static org.mifos.connector.channel.camel.config.CamelProperties.BATCH_ID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.api.command.ClientStatusException;
import io.grpc.Status;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.channel.dto.PhErrorDTO;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GSMATransferAPIController implements GSMATransferAPI {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ResponseEntity<Object> gsmatransfer(String tenant, String correlationId, String batchId, GSMATransaction requestBody)
            throws JsonProcessingException {
        org.mifos.connector.channel.utils.Headers headers = new Headers.HeaderBuilder().addHeader("Platform-TenantId", tenant)
                .addHeader("X-CorrelationID", correlationId).addHeader(BATCH_ID, batchId).build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers,
                objectMapper.writeValueAsString(requestBody));
        logger.info("Batch id: " + batchId);
        producerTemplate.send("direct:post-gsma-transfer", exchange);
        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        if (cause instanceof ClientStatusException) {
            throw new ClientStatusException(Status.FAILED_PRECONDITION, cause);
        }

        String body = exchange.getIn().getBody(String.class);
        try {
            if (body.contains("error")) {
                return new ResponseEntity<>(objectMapper.readValue(body, PhErrorDTO.class), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(objectMapper.readValue(body, GsmaP2PResponseDto.class), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
