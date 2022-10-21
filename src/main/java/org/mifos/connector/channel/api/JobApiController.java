package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class JobApiController implements JobApi{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Object job(String requestBody) {

        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(requestBody);
        producerTemplate.send("direct:post-job-resolve", exchange);

        return exchange.getIn().getBody(null);
    }
}
