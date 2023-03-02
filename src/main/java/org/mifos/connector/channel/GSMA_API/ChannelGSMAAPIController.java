package org.mifos.connector.channel.GSMA_API;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

public class ChannelGSMAAPIController implements GSMA_API {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String gsma(HttpServletResponse response) throws Exception {
        Headers headers = new Headers.HeaderBuilder()
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers,null);
        producerTemplate.send("direct:get-channel-gsma", exchange);
        response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));

        return exchange.getIn().getBody(String.class);
    }
}
