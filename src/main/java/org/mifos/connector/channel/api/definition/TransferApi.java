package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.BATCH_ID_HEADER;
import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;
import static org.mifos.connector.channel.camel.config.CamelProperties.PAYEE_DFSP_ID;
import static org.mifos.connector.channel.camel.config.CamelProperties.REGISTERING_INSTITUTION_ID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.mifos.connector.common.channel.dto.TransactionStatusResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface TransferApi {

    @PostMapping("/channel/transfer")
    GsmaP2PResponseDto transfer(@RequestHeader(value = "Platform-TenantId") String tenant,
            @RequestHeader(value = BATCH_ID_HEADER, required = false) String batchId,
            @RequestHeader(value = CLIENTCORRELATIONID, required = false) String correlationId,
            @RequestHeader(value = REGISTERING_INSTITUTION_ID, required = false) String registeringInstitutionId,
            @RequestHeader(value = PAYEE_DFSP_ID, required = false) String payeeDfspId,
            @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;

    @GetMapping("/channel/transfer/{transactionId}")
    TransactionStatusResponseDTO transferId(@PathVariable String transactionId, @RequestHeader(value = "Platform-TenantId") String tenant)
            throws JsonProcessingException;
}
