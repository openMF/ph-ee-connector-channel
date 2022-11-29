package org.mifos.connector.channel.api;

import io.swagger.v3.oas.annotations.Operation;
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

        return exchange.getIn().getBody(String.class);
    }

}
