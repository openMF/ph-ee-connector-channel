package org.mifos.connector.channel.gsmaapi;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.web.bind.annotation.*;

public interface GSMADepositApi {

    @PostMapping("/channel/gsma/deposit")
    RequestStateDTO gsmadeposit(@RequestHeader(value="Platform-TenantId") String tenant,
                        @RequestHeader(value="X-CorrelationID") String correlationId,
                        @RequestBody GSMATransaction requestBody)
            throws JsonProcessingException;
}
