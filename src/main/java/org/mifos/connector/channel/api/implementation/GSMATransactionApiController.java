package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.camunda.zeebe.client.api.command.ClientStatusException;
import io.grpc.Status;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.GSMATransactionApi;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.channel.utils.Headers;
import org.mifos.connector.channel.utils.SpringWrapperUtil;
import org.mifos.connector.common.gsma.dto.GsmaTransfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GSMATransactionApiController implements GSMATransactionApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public GsmaP2PResponseDto gsmatransaction(GsmaTransfer requestBody, String correlationId, String amsName, String accountHoldId,
            String callbackURL, String tenantId) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder().addHeader("X-CorrelationID", correlationId).addHeader("amsName", amsName)
                .addHeader("accountHoldingInstitutionId", accountHoldId).addHeader("X-CallbackURL", callbackURL)
                .addHeader("Platform-TenantId", tenantId).build();
        Exchange exchange = SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers,
                objectMapper.writeValueAsString(requestBody));
        producerTemplate.send("direct:post-gsma-transaction", exchange);

        Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        if (cause instanceof ClientStatusException) {
            throw new ClientStatusException(Status.FAILED_PRECONDITION, cause);
        }
        String body = exchange.getIn().getBody(String.class);
        return objectMapper.readValue(body, GsmaP2PResponseDto.class);
    }
}
