package org.mifos.connector.channel.api;

import org.mifos.connector.common.channel.dto.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

public interface TransferApi {

    @PostMapping("/channel/transfer")
    String transfer(@RequestHeader(value="Platform-TenantId") String tenant, @RequestBody TransactionChannelRequestDTO requestBody);

    @GetMapping("/channel/transfer/{transactionId}")
    String transferId(@PathVariable String transactionId, @RequestHeader(value="Platform-TenantId") String tenant);
}
