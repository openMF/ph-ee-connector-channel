package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the type of the identity. Currently, only ‘individual’ is supported.
 */
public enum IdentityType {

    INDIVIDUAL("individual");

    private String value;

    IdentityType(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static IdentityType fromValue(String text) {
        for (IdentityType b : IdentityType.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
