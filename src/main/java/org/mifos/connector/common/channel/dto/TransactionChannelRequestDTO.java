/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.channel.dto;

import org.mifos.connector.common.mojaloop.dto.Party;
import org.mifos.connector.common.mojaloop.type.AmountType;
import org.mifos.connector.common.mojaloop.dto.Extension;
import org.mifos.connector.common.mojaloop.dto.GeoCode;
import org.mifos.connector.common.mojaloop.dto.MoneyData;
import org.mifos.connector.common.mojaloop.dto.TransactionType;
import org.mifos.connector.common.util.ContextUtil;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionChannelRequestDTO {
    private String clientRefId;
    private Party payer, payee;
    private AmountType amountType;
    private MoneyData amount;
    private TransactionType transactionType;
    private GeoCode geoCode;
    private String note;
    private String expiration;
    private List<Extension> extensionList;

    public String getClientRefId() {
        return clientRefId;
    }

    public void setClientRefId(String clientRefId) {
        this.clientRefId = clientRefId;
    }

    public Party getPayer() {
        return payer;
    }

    public void setPayer(Party payer) {
        this.payer = payer;
    }

    public Party getPayee() {
        return payee;
    }

    public void setPayee(Party payee) {
        this.payee = payee;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public MoneyData getAmount() {
        return amount;
    }

    public void setAmount(MoneyData amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public GeoCode getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(GeoCode geoCode) {
        this.geoCode = geoCode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Transient
    public LocalDateTime getExpirationDate() {
        return ContextUtil.parseDate(expiration);
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = ContextUtil.formatDate(expiration);
    }

    public List<Extension> getExtensionList() {
        return extensionList;
    }

    public void setExtensionList(List<Extension> extensionList) {
        this.extensionList = extensionList;
    }

    @Override
    public String toString() {
        return "TransactionChannelRequestDTO{" +
                "clientRefId='" + clientRefId + '\'' +
                ", payer=" + payer +
                ", payee=" + payee +
                ", amountType=" + amountType +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                ", note='" + note + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}


