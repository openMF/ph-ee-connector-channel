package org.mifos.connector.channel.GSMA_API;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.*;
import org.apache.camel.support.*;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class GSMATransferAPIController implements GSMATransferAPI{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto gsmatransfer(String tenant, String correlationId, GSMATransaction requestBody) throws JsonProcessingException {
        org.mifos.connector.channel.utils.Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .addHeader("X-CorrelationID",correlationId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-gsma-transfer", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body,GsmaP2PResponseDto.class);
    }
}
