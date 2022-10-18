package org.mifos.connector.channel.gsmaapi;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.*;
import org.apache.camel.support.*;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class GSMATransferApiController implements GSMATransferAPI{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto gsmatransfer(String tenant, String correlationId, GSMATransaction requestBody) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-gsma-transfer", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body,GsmaP2PResponseDto.class);
    }
}
