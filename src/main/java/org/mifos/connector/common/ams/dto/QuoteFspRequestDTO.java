/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.ams.dto;

import org.mifos.connector.common.mojaloop.dto.FspMoneyData;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
import org.mifos.connector.common.mojaloop.type.AmountType;
import org.mifos.connector.common.mojaloop.type.TransactionRole;


public class QuoteFspRequestDTO {

    private String transactionCode;
    private String requestCode;
    private String quoteCode;
    private String accountId;
    private FspMoneyData amount;
    private AmountType amountType;
    private TransactionRole transactionRole;
    private TransactionType transactionType;

    public QuoteFspRequestDTO() {
    }

    public QuoteFspRequestDTO(String transactionCode, String requestCode, String quoteCode, String accountId, FspMoneyData amount, AmountType amountType,
                              TransactionRole transactionRole, TransactionType transactionType) {
        this.transactionCode = transactionCode;
        this.requestCode = requestCode;
        this.quoteCode = quoteCode;
        this.accountId = accountId;
        this.amount = amount;
        this.amountType = amountType;
        this.transactionRole = transactionRole;
        this.transactionType = transactionType;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getQuoteCode() {
        return quoteCode;
    }

    public void setQuoteCode(String quoteCode) {
        this.quoteCode = quoteCode;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public FspMoneyData getAmount() {
        return amount;
    }

    public void setAmount(FspMoneyData amount) {
        this.amount = amount;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public TransactionRole getTransactionRole() {
        return transactionRole;
    }

    public void setTransactionRole(TransactionRole transactionRole) {
        this.transactionRole = transactionRole;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
