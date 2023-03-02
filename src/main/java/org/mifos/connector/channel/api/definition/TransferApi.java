package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.GSMA_API.*;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.web.bind.annotation.*;

public interface TransferApi {

    @PostMapping("/channel/transfer")
    GsmaP2PResponseDto transfer(@RequestHeader(value = "Platform-TenantId") String tenant,
                                @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;

    @GetMapping("/channel/transfer/{transactionId}")
    TransactionStatusResponseDTO transferId(@PathVariable String transactionId,
                                            @RequestHeader(value = "Platform-TenantId") String tenant) throws JsonProcessingException;
}
