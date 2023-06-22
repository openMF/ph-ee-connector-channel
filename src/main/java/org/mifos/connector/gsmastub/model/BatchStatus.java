package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets batchStatus
 */
public enum BatchStatus {

    CREATED("created"), APPROVED("approved"), COMPLETED("completed");

    private String value;

    BatchStatus(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static BatchStatus fromValue(String text) {
        for (BatchStatus b : BatchStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
