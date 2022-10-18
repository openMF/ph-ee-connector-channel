package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.gsmaapi.*;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TransactionApiController implements TransactionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto transaction(String tenant, TransactionChannelRequestDTO requestBody) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(requestBody);
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        System.out.println("request = " + requestBody);
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-transaction-request", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, GsmaP2PResponseDto.class);
    }
}
