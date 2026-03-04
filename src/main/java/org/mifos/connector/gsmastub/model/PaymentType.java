package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets paymentType
 */
public enum PaymentType {
  PARTIALPAYMENT("partialpayment"),
    FULLPAYMENT("fullpayment");

  private String value;

  PaymentType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static PaymentType fromValue(String text) {
    for (PaymentType b : PaymentType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
