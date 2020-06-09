/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.mojaloop.dto;


import org.mifos.connector.common.mojaloop.type.TransactionRequestState;

import java.util.List;


public class TransactionRequestSwitchResponseDTO {

    private String transactionId;
    private TransactionRequestState transactionRequestState;
    private List<Extension> extensionList;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionRequestState getTransactionRequestState() {
        return transactionRequestState;
    }

    public void setTransactionRequestState(TransactionRequestState transactionRequestState) {
        this.transactionRequestState = transactionRequestState;
    }

    public List<Extension> getExtensionList() {
        return extensionList;
    }

    public void setExtensionList(List<Extension> extensionList) {
        this.extensionList = extensionList;
    }
}
