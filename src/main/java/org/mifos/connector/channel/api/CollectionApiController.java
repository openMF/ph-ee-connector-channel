package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CollectionApiController implements CollectionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String collection(String tenant, String requestBody, HttpServletResponse response) {

        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(requestBody);
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-collection", exchange);

        try {
            response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));
        } catch (Exception e) { }

        return exchange.getIn().getBody(String.class);
    }

}
