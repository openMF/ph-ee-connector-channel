package org.mifos.connector.channel.GSMA_API;

import com.fasterxml.jackson.core.*;
import io.netty.handler.codec.http.HttpResponse;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static org.apache.camel.Exchange.HTTP_RESPONSE_CODE;

public interface GSMATransferAPI {

    @PostMapping("/channel/gsma/transfer")
    ResponseEntity<Object> gsmatransfer(@RequestHeader(value="Platform-TenantId") String tenant,
                                @RequestHeader(value="X-CorrelationID") String correlationId,
                                @RequestBody GSMATransaction requestBody)
            throws JsonProcessingException;

}
