package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.utils.GsmaP2PResponseDto;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.web.bind.annotation.*;

public interface GSMATransactionApi {
    @PostMapping("/channel/gsma/transaction")
    GsmaP2PResponseDto gsmatransaction(@RequestBody GsmaTransfer requestBody,
                                       @RequestHeader(value = "X-CorrelationID") String correlationId,
                                       @RequestHeader(value = "amsName") String amsName,
                                       @RequestHeader(value = "accountHoldingInstitutionId") String accountHoldId) throws JsonProcessingException;
}
