package org.mifos.connector.channel.api;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.gsmaapi.*;
import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface TransactionApi {

    @PostMapping("/channel/transactionRequest")
    GsmaP2PResponseDto transaction(@RequestHeader(value="Platform-TenantId") String tenant,
                                   @RequestBody TransactionChannelRequestDTO requestBody) throws JsonProcessingException;
}
