package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the creation state of the Quotation.
 */
public enum QuotationStatus {

    PENDING("pending"), REJECTED("rejected"), COMPLETED("completed");

    private String value;

    QuotationStatus(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static QuotationStatus fromValue(String text) {
        for (QuotationStatus b : QuotationStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
