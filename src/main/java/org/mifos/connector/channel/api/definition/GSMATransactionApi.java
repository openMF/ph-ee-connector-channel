package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.GSMA_API.*;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.web.bind.annotation.*;

public interface GSMATransactionApi {
    @PostMapping("/channel/gsma/transaction")
    GsmaP2PResponseDto gsmatransaction(@RequestBody GsmaTransfer requestBody)
            throws JsonProcessingException;
}
