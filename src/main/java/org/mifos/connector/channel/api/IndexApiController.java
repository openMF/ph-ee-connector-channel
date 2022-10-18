package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexApiController implements IndexApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String index(HttpServletResponse response) {

        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:get-index", exchange);

        try {
            response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));
        } catch (Exception e) { }

        return exchange.getIn().getBody(String.class);
    }

}
