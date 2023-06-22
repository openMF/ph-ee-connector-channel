package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The harmonised Transaction Type.
 */
public enum TypeReversal {

    ADJUSTMENT("adjustment"), REVERSAL("reversal");

    private String value;

    TypeReversal(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static TypeReversal fromValue(String text) {
        for (TypeReversal b : TypeReversal.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
