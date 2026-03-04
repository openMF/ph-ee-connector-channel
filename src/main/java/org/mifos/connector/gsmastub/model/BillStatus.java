package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets billStatus
 */
public enum BillStatus {
  UNPAID("unpaid"),
    PAID("paid"),
    PARTIALPAID("partialpaid");

  private String value;

  BillStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static BillStatus fromValue(String text) {
    for (BillStatus b : BillStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
