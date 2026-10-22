package org.mifos.connector.channel.api.fineract_api.service;

import org.mifos.connector.channel.api.fineract_api.dto.WithdrawHookRequest;

/**
 * @author manoj
 **/

public interface MpesaConnectorService {

    void sendCreditRequest(String tenantId, WithdrawHookRequest request);
}
