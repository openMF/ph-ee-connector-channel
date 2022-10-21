package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class TransactionApiController implements TransactionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String transaction(String tenant, String requestBody){
//        System.out.println("Body- .." + requestBody);
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(requestBody);
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-transaction-request", exchange);

//        System.out.println(" DHruv \n\n" + exchange.getIn().getBody());
        return exchange.getIn().getBody(String.class);
    }

    @Override
    public Object transactionId(String requestBody,String transactionId){
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:post-transaction-transaction-id-resolve", exchange);

        return exchange.getIn().getBody();
    }

}
