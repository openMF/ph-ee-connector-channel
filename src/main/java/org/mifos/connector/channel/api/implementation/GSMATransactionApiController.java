package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.*;
import org.mifos.connector.channel.api.definition.GSMATransactionApi;
import org.mifos.connector.channel.utils.GsmaP2PResponseDto;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GSMATransactionApiController implements GSMATransactionApi {


    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public GsmaP2PResponseDto gsmatransaction(GsmaTransfer requestBody, String correlationId, String amsName, String accountHoldId) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .addHeader("X-CorrelationID", correlationId)
                .addHeader("amsName",amsName)
                .addHeader("accountHoldingInstitutionId",accountHoldId)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers,objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-gsma-transaction", exchange);
        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body,GsmaP2PResponseDto.class);
    }
}

