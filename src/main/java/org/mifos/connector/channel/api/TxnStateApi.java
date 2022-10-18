package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import org.springframework.web.bind.annotation.*;

public interface TxnStateApi {

    @GetMapping("/channel/txnState/{correlationId}")
    TxnStateResponseDTO txnState(@RequestHeader (value="Platform-TenantId") String tenant,
                    @RequestHeader(value = "requestType") String requestType) throws JsonProcessingException;
}
