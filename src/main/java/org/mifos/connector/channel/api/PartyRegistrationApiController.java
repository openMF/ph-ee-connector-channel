package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PartyRegistrationApiController implements PartyRegistrationApi {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Object partyRegistration(String tenant, RegisterAliasRequestDTO requestBody) throws JsonProcessingException {
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        exchange.getIn().setBody(objectMapper.writeValueAsString(requestBody));
        exchange.getIn().setHeader("Platform-TenantId", tenant);
        producerTemplate.send("direct:post-party-registration", exchange);

        return exchange.getIn().getBody();
    }
}
