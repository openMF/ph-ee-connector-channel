package org.mifos.connector.channel.GSMA_API;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

public class ChannelGSMAAPIController implements GSMA_API {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String gsma(HttpServletResponse response) throws Exception {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:get-channel-gsma", exchange);
        response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));

        return exchange.getIn().getBody(String.class);
    }
}
