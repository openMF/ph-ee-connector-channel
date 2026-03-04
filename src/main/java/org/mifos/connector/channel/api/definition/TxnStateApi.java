package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

public interface TxnStateApi {

    @GetMapping("/channel/txnState/{X-CorrelationID}")
    TxnStateResponseDTO txnState(@RequestHeader(value = "Platform-TenantId") String tenant,
            @PathVariable(value = CLIENTCORRELATIONID) String correlationId, @RequestHeader(value = "requestType") String requestType)
            throws JsonProcessingException;
}
