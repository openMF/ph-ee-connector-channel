/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mifos.connector.common.ams.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class InteropAccountDTO {

    private String accountId;
    private String savingProductId;
    private String productName;
    private String shortProductName;
    private String currency;
    private BigDecimal accountBalance;
    private BigDecimal availableBalance;
    private SavingsAccountStatusType status;
    private SavingsAccountSubStatusEnum subStatus;
    private AccountType accountType;
    private DepositAccountType depositType;
    private LocalDate activatedOn;
    private LocalDate statusUpdateOn;
    private LocalDate withdrawnOn;
    private LocalDate balanceOn;
    private List<InteropIdentifierData> identifiers;
    private String clientId;

    public InteropAccountDTO() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSavingProductId() {
        return savingProductId;
    }

    public void setSavingProductId(String savingProductId) {
        this.savingProductId = savingProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortProductName() {
        return shortProductName;
    }

    public void setShortProductName(String shortProductName) {
        this.shortProductName = shortProductName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public SavingsAccountStatusType getStatus() {
        return status;
    }

    public void setStatus(SavingsAccountStatusType status) {
        this.status = status;
    }

    public SavingsAccountSubStatusEnum getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(SavingsAccountSubStatusEnum subStatus) {
        this.subStatus = subStatus;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public DepositAccountType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositAccountType depositType) {
        this.depositType = depositType;
    }

    public LocalDate getActivatedOn() {
        return activatedOn;
    }

    public void setActivatedOn(LocalDate activatedOn) {
        this.activatedOn = activatedOn;
    }

    public LocalDate getStatusUpdateOn() {
        return statusUpdateOn;
    }

    public void setStatusUpdateOn(LocalDate statusUpdateOn) {
        this.statusUpdateOn = statusUpdateOn;
    }

    public LocalDate getWithdrawnOn() {
        return withdrawnOn;
    }

    public void setWithdrawnOn(LocalDate withdrawnOn) {
        this.withdrawnOn = withdrawnOn;
    }

    public LocalDate getBalanceOn() {
        return balanceOn;
    }

    public void setBalanceOn(LocalDate balanceOn) {
        this.balanceOn = balanceOn;
    }

    public List<InteropIdentifierData> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<InteropIdentifierData> identifiers) {
        this.identifiers = identifiers;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
