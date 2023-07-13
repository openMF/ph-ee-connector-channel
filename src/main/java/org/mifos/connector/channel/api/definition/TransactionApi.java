package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.TRANSACTION_ID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface TransactionApi {

    @PostMapping("/channel/transactionRequest")
    GsmaP2PResponseDto transaction(@RequestHeader(value = "Platform-TenantId") String tenant,
            @RequestHeader(value = CLIENTCORRELATIONID, required = false) String correlationId,
            @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;

    @PostMapping("/channel/transaction/{" + TRANSACTION_ID + "}/resolve")
    void transactionResolve(@RequestBody String requestBody) throws JsonProcessingException;
}
