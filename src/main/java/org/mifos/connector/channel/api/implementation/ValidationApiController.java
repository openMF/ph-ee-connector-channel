package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.ValidationApi;
import org.mifos.connector.channel.model.ValidationRequestDTO;
import org.mifos.connector.channel.model.ValidationResponseDTO;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationApiController implements ValidationApi {


    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public ValidationResponseDTO validation(ValidationRequestDTO validationRequestDTO, String primaryIdentifierName, String primaryIdentifierVal) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder()
                .build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(),
                headers, objectMapper.writeValueAsString(validationRequestDTO));
        producerTemplate.send("direct:post-validation-ams", exchange);
        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, ValidationResponseDTO.class);
    }
}
