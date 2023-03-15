package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.CollectionApi;
import org.mifos.connector.channel.utils.GsmaP2PResponseDto;
import org.mifos.connector.channel.model.CollectionRequestDTO;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.channel.dto.PhErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.*;

@RestController
public class CollectionApiController implements CollectionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<Object> collection(String tenant, String correlationId, CollectionRequestDTO requestBody) throws ExecutionException, InterruptedException, JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .addHeader("X-CorrelationID", correlationId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(requestBody));
        Exchange ex = producerTemplate.send("direct:post-collection", exchange);

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
