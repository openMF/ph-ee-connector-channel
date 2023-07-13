package org.mifos.connector.channel.api.implementation;

import javax.servlet.http.HttpServletResponse;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.IndexApi;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexApiController implements IndexApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String index(HttpServletResponse response) throws Exception {
        Headers headers = new Headers.HeaderBuilder().build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers, null);
        producerTemplate.send("direct:get-index", exchange);
        response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));

        return exchange.getIn().getBody(String.class);
    }

}
