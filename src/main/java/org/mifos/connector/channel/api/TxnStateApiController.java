package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.gsmaapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxnStateApiController implements TxnStateApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public TxnStateResponseDTO txnState(String tenant,String requestType) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        exchange.getIn().setHeader("requestType", requestType);

        producerTemplate.send("direct:get-txnState-correlationId", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, TxnStateResponseDTO.class);   }
}
