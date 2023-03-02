package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.*;
import org.apache.camel.support.*;
import org.mifos.connector.channel.api.definition.GSMATransactionApi;
import org.mifos.connector.channel.GSMA_API.*;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.beans.factory.annotation.*;

public class GSMATransactionApiController implements GSMATransactionApi {


    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto gsmatransaction(GsmaTransfer requestBody) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-gsma-transaction", exchange);
        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body,GsmaP2PResponseDto.class);
    }
}

