package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The amount for the authorisation can be an exact amount or can be a maximum amount.
 */
public enum AmountType {

    EXACT("exact"), MAXIMUM("maximum");

    private String value;

    AmountType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AmountType fromValue(String text) {
        for (AmountType b : AmountType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
