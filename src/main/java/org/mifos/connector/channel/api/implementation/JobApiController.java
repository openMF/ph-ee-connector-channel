package org.mifos.connector.channel.api.implementation;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.api.definition.JobApi;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobApiController implements JobApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Object job(String requestBody) {
        Headers headers = new Headers.HeaderBuilder()
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers,requestBody);
        producerTemplate.send("direct:post-job-resolve", exchange);
        return exchange.getIn().getBody(null);
    }
}