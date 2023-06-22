package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The harmonised Transaction Type.
 */
public enum Type {

    BILLPAY("billpay"), DEPOSIT("deposit"), DISBURSEMENT("disbursement"), TRANSFER("transfer"), MERCHANTPAY("merchantpay"), INTTRANSFER(
            "inttransfer"), ADJUSTMENT("adjustment"), REVERSAL("reversal"), WITHDRAWAL("withdrawal");

    private String value;

    Type(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Type fromValue(String text) {
        for (Type b : Type.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
