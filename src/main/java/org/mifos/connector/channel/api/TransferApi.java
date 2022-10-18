package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.gsmaapi.*;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

public interface TransferApi {

    @PostMapping("/channel/transfer")
    GsmaP2PResponseDto transfer(@RequestHeader(value="Platform-TenantId") String tenant,
                                @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;

    @GetMapping("/channel/transfer/{transactionId}")
    String transferId(@PathVariable String transactionId,
                      @RequestHeader(value="Platform-TenantId") String tenant);
}
