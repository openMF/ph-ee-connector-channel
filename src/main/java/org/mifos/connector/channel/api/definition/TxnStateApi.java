package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.springframework.web.bind.annotation.*;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

public interface TxnStateApi {

    @GetMapping("/channel/txnState/{X-CorrelationID}")
    TxnStateResponseDTO txnState(@RequestHeader (value="Platform-TenantId") String tenant,
                                 @PathVariable(value=CLIENTCORRELATIONID) String correlationId,
                                 @RequestHeader(value = "requestType") String requestType) throws JsonProcessingException;
}
