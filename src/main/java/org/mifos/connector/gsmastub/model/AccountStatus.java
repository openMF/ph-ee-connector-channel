package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates a harmonised representation of the account status. This will be shown as available, unavailable or unregistered.
 */
public enum AccountStatus {
  AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    UNREGISTERED("unregistered");

  private String value;

  AccountStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountStatus fromValue(String text) {
    for (AccountStatus b : AccountStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
