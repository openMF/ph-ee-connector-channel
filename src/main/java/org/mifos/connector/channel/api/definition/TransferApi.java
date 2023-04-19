package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.GSMA_API.*;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.web.bind.annotation.*;

import static org.mifos.connector.channel.camel.config.CamelProperties.BATCH_ID_HEADER;
import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

public interface TransferApi {

    @PostMapping("/channel/transfer")
    GsmaP2PResponseDto transfer(@RequestHeader(value = "Platform-TenantId") String tenant,
                                @RequestHeader(value = BATCH_ID_HEADER, required = false) String batchId,
                                @RequestHeader(value=CLIENTCORRELATIONID,required = false) String correlationId,
                                @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;

    @GetMapping("/channel/transfer/{transactionId}")
    TransactionStatusResponseDTO transferId(@PathVariable String transactionId,
                                            @RequestHeader(value = "Platform-TenantId") String tenant) throws JsonProcessingException;
}
