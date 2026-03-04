package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * RequestGenericPatch
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestGenericPatch   {
  /**
   * Indicates the Patch operation to be performed. 'replace' is used to update a field and 'add' is used to add a new field.
   */
  public enum OpEnum {
    REPLACE("replace"),
    
    ADD("add");

    private String value;

    OpEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OpEnum fromValue(String text) {
      for (OpEnum b : OpEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("op")
  private OpEnum op = null;

  @JsonProperty("path")
  private String path = null;

  @JsonProperty("value")
  private String value = null;

  public RequestGenericPatch op(OpEnum op) {
    this.op = op;
    return this;
  }

  /**
   * Indicates the Patch operation to be performed. 'replace' is used to update a field and 'add' is used to add a new field.
   * @return op
   **/
  @Schema(required = true, description = "Indicates the Patch operation to be performed. 'replace' is used to update a field and 'add' is used to add a new field.")
      @NotNull

    public OpEnum getOp() {
    return op;
  }

  public void setOp(OpEnum op) {
    this.op = op;
  }

  public RequestGenericPatch path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Specify the field to be updated or added preceded by '/'.
   * @return path
   **/
  @Schema(required = true, description = "Specify the field to be updated or added preceded by '/'.")
      @NotNull

  @Size(max=256)   public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RequestGenericPatch value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Specify the value of the field to be updated or added.
   * @return value
   **/
  @Schema(required = true, description = "Specify the value of the field to be updated or added.")
      @NotNull

  @Size(max=256)   public String getValue() {
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
    RequestGenericPatch requestGenericPatch = (RequestGenericPatch) o;
    return Objects.equals(this.op, requestGenericPatch.op) &&
        Objects.equals(this.path, requestGenericPatch.path) &&
        Objects.equals(this.value, requestGenericPatch.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, path, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestGenericPatch {\n");
    
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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
