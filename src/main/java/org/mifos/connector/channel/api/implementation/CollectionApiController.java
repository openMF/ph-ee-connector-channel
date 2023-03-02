package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.CollectionApi;
import org.mifos.connector.channel.GSMA_API.GsmaP2PResponseDto;
import org.mifos.connector.channel.model.CollectionRequestDTO;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.*;

@RestController
public class CollectionApiController implements CollectionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto collection(String tenant, String correlationId, CollectionRequestDTO requestBody) throws ExecutionException, InterruptedException, JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .addHeader("X-CorrelationID", correlationId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(requestBody));
        Exchange ex = producerTemplate.send("direct:post-collection", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, GsmaP2PResponseDto.class);    }

}
