package org.mifos.connector.channel.api.fineract_api;

import org.mifos.connector.channel.api.fineract_api.dto.WithdrawHookRequest;
import org.mifos.connector.channel.api.fineract_api.service.MpesaConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author manoj
 **/

@RestController
public class TransactionAPIController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAPIController.class);

    @Autowired
    private MpesaConnectorService mpesaConnectorService;

    @PostMapping("/channel/hook/withdraw")
    ResponseEntity<Object> withdrawHook(@RequestBody WithdrawHookRequest request,
            @RequestHeader("fineract-platform-tenantid") String tenantId) {
        LOGGER.info("Received withdrawal hook for clientId: {}", request.getClientId());
        LOGGER.info("Transaction amount: {}", request.getRequest().getTransactionAmount());
        LOGGER.info("Transaction date: {}", request.getRequest().getTransactionDate());

        mpesaConnectorService.sendCreditRequest(tenantId, request);

        return ResponseEntity.ok("Withdrawal hook processed successfully");
    }
}
