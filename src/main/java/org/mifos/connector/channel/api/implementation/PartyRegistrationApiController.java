package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.mifos.connector.channel.api.definition.PartyRegistrationApi;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartyRegistrationApiController implements PartyRegistrationApi {
    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void partyRegistration(String tenant, RegisterAliasRequestDTO requestBody) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .addHeader("Platform-TenantId", tenant)
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-party-registration", exchange);
    }
}
