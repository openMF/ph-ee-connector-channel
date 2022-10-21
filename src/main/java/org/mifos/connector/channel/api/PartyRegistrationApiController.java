package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PartyRegistrationApiController implements PartyRegistrationApi {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Object partyRegistration(String tenant, String requestBody){
//        System.out.println("Body- .." + requestBody);
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(requestBody);
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-party-registration", exchange);

        return exchange.getIn().getBody(null);
    }
}
