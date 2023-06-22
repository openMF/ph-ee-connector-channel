package org.mifos.connector.channel.gsma_api;

import javax.servlet.http.HttpServletResponse;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelGSMAAPIController implements GSMA_API {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public String gsma(HttpServletResponse response) throws Exception {
        Headers headers = new Headers.HeaderBuilder().build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers, null);
        producerTemplate.send("direct:get-channel-gsma", exchange);
        response.setStatus(exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE, Integer.class));

        return exchange.getIn().getBody(String.class);
    }
}
