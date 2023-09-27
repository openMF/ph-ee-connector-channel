package org.mifos.connector.channel.api.definition;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.gsma_api.GsmaP2PResponseDto;
import org.mifos.connector.common.gsma.dto.GsmaTransfer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GSMATransactionApi {

    @PostMapping("/channel/gsma/transaction")
    GsmaP2PResponseDto gsmatransaction(@RequestBody GsmaTransfer requestBody,
            @RequestHeader(value = CLIENTCORRELATIONID, required = false) String correlationId,
            @RequestHeader(value = "amsName") String amsName, @RequestHeader(value = "accountHoldingInstitutionId") String accountHoldId,
                                       @RequestHeader(value = "X-CallbackURL") String callbackURL)
            throws JsonProcessingException;
}
