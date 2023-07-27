package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.PAYMENT_SCHEME_HEADER;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.concurrent.ExecutionException;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.channel.model.CollectionRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface CollectionApi {

    @PostMapping("/channel/collection")
    GsmaP2PResponseDto collection(@RequestHeader(value = "Platform-TenantId") String tenant,
            @RequestHeader(value = "X-CorrelationID") String correlationId,
            @RequestHeader(value = PAYMENT_SCHEME_HEADER) String paymentScheme, @RequestBody CollectionRequestDTO requestBody)
            throws ExecutionException, InterruptedException, JsonProcessingException;

}
