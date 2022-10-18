package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.gsmaapi.*;
import org.mifos.connector.common.gsma.dto.*;
import org.springframework.web.bind.annotation.*;

public interface GSMATransactionApi {
    @PostMapping("/channel/gsma/transaction")
    GsmaP2PResponseDto gsmatransaction(@RequestBody GsmaTransfer requestBody)
            throws JsonProcessingException;
}
