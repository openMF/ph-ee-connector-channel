package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.gsmaapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.*;

@RestController
public class CollectionApiController implements CollectionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto collection(String tenant, String correlationId, CollectionRequestDTO requestBody) throws ExecutionException, InterruptedException, JsonProcessingException {

        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        System.out.println("INput: " + objectMapper.writeValueAsString(requestBody));
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        exchange.getIn().setHeader("X-CorrelationID", correlationId);
        Exchange ex = producerTemplate.send("direct:post-collection", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, GsmaP2PResponseDto.class);    }

}
