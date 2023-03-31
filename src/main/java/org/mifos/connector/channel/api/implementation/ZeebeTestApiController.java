package org.mifos.connector.channel.api.implementation;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.ZeebeTestApi;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZeebeTestApiController implements ZeebeTestApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Object workflow(String requestBody) {

        Headers headers = new Headers.HeaderBuilder().build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers,requestBody);

        producerTemplate.send("direct:zeebe-flow-test", exchange);
        return exchange.getIn().getBody();
    }
}
