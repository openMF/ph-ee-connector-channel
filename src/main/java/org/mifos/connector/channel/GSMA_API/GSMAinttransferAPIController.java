package org.mifos.connector.channel.GSMA_API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.springframework.beans.factory.annotation.Autowired;

public class GSMAinttransferAPIController implements GSMAinttransferAPI{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto gsmaintransfer(String tenant, GSMATransaction requestBody) throws JsonProcessingException {
        org.mifos.connector.channel.utils.Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-gsma-payer-int-transfer", exchange);

        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body,GsmaP2PResponseDto.class);
    }
}
