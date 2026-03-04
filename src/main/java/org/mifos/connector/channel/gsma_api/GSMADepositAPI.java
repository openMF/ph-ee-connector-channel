package org.mifos.connector.channel.gsma_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.mifos.connector.common.gsma.dto.RequestStateDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GSMADepositAPI {

    @PostMapping("/channel/gsma/deposit")
    RequestStateDTO gsmadeposit(@RequestHeader(value = "Platform-TenantId") String tenant,
            @RequestHeader(value = "X-CorrelationID", required = false) String correlationId, @RequestBody GSMATransaction requestBody)
            throws JsonProcessingException;
}
