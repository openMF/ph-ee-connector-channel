package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets deliveryMethod
 */
public enum DeliveryMethod {

    DIRECTTOACCOUNT("directtoaccount"), AGENT("agent"), PERSONALDELIVERY("personaldelivery");

    private String value;

    DeliveryMethod(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static DeliveryMethod fromValue(String text) {
        for (DeliveryMethod b : DeliveryMethod.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
