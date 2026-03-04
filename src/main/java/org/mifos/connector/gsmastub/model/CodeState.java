package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Indicates the state of the Authorisation Code.
 */
public enum CodeState {
  ACTIVE("active"),
    EXPIRED("expired"),
    CANCELLED("cancelled");

  private String value;

  CodeState(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static CodeState fromValue(String text) {
    for (CodeState b : CodeState.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
