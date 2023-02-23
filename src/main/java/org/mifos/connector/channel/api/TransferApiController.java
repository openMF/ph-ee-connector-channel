package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TransferApiController implements TransferApi{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public String transfer(String tenant, TransactionChannelRequestDTO requestBody) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-transfer", exchange);

        return exchange.getIn().getBody(String.class);
    }

    @Override
    public String transferId(String transactionId,String tenant) {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:get-transfer-transaction-id", exchange);

        return exchange.getIn().getBody(String.class);
    }
}
