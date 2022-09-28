package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets frequencyType
 */
public enum FrequencyType {
  WEEKLY("weekly"),
    FORTNIGHT("fortnight"),
    MONTHSPECIFICDATE("monthspecificdate"),
    TWOMONTHS("twomonths"),
    THREEMONTHS("threemonths"),
    FOURMONTHS("fourmonths"),
    SIXMONTHS("sixmonths"),
    YEARLY("yearly"),
    LASTDAYMONTH("lastdaymonth"),
    LASTDAYMONTHWORKING("lastdaymonthworking"),
    LASTMONDAY("lastmonday"),
    LASTTUESDAY("lasttuesday"),
    LASTWEDNESDAY("lastwednesday"),
    LASTTHURSDAY("lastthursday"),
    LASTFRIDAY("lastfriday"),
    LASTSATURDAY("lastsaturday"),
    LASTSUNDAY("lastsunday"),
    SPECIFICDAYMONTHLY("specificdaymonthly");

  private String value;

  FrequencyType(String value) {
    this.value = value;
  }

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static FrequencyType fromValue(String text) {
    for (FrequencyType b : FrequencyType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
