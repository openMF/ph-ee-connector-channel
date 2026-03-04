package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * CustomData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class CustomData   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("value")
  private String value = null;

  public CustomData key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Identifies the type of additional field.
   * @return key
   **/
  @Schema(required = true, description = "Identifies the type of additional field.")
      @NotNull

  @Size(min=1,max=256)   public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public CustomData value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Identifies the value of the additional field.
   * @return value
   **/
  @Schema(required = true, description = "Identifies the value of the additional field.")
      @NotNull

  @Size(min=1,max=256)   public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomData customData = (CustomData) o;
    return Objects.equals(this.key, customData.key) &&
        Objects.equals(this.value, customData.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomData {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
