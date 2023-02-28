package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.api.definition.TxnStateApi;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

@RestController
public class TxnStateApiController implements TxnStateApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public TxnStateResponseDTO txnState(String tenant,String correlationId ,String requestType) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .addHeader("requestType", requestType)
                .addHeader(CLIENTCORRELATIONID,correlationId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, null);
        producerTemplate.send("direct:get-txnState-correlationId", exchange);
        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, TxnStateResponseDTO.class);   }
}
