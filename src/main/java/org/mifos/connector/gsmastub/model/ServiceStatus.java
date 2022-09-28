package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Provides the status of the requested service.
 */
public enum ServiceStatus {
  AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    DEGRADED("degraded");

  private String value;

  ServiceStatus(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static ServiceStatus fromValue(String text) {
    for (ServiceStatus b : ServiceStatus.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
