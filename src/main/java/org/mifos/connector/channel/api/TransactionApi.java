package org.mifos.connector.channel.api;

import org.mifos.connector.common.channel.dto.TransactionChannelRequestDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface TransactionApi {

    @PostMapping("/channel/transactionRequest")
    String transaction(@RequestHeader(value="Platform-TenantId") String tenant, @RequestBody TransactionChannelRequestDTO requestBody);

    @PostMapping("/channel/transaction/TRANSACTION_ID/resolve")
    Object transactionId(@RequestBody String requestBody, @PathVariable String transactionId);

}
