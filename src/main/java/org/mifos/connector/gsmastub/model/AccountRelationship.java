package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Describes the relationship that the identity holds with the account.
 */
public enum AccountRelationship {

    ACCOUNTHOLDER("accountholder");

    private String value;

    AccountRelationship(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static AccountRelationship fromValue(String text) {
        for (AccountRelationship b : AccountRelationship.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
