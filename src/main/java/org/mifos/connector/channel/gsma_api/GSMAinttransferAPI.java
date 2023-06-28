package org.mifos.connector.channel.gsma_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GSMAinttransferAPI {

    @PostMapping("/channel/gsma/inttransfer")
    GsmaP2PResponseDto gsmaintransfer(@RequestHeader(value = "Platform-TenantId") String tenant, @RequestBody GSMATransaction requestBody)
            throws JsonProcessingException;
}
