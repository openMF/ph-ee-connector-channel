package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the status of the identity’s KYC verification.
 */
public enum KycVerificationStatus {

    VERIFIED("verified"), UNVERIFIED("unverified"), REJECTED("rejected");

    private String value;

    KycVerificationStatus(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static KycVerificationStatus fromValue(String text) {
        for (KycVerificationStatus b : KycVerificationStatus.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
