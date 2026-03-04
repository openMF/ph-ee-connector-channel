package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Fees
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class Fees   {
  @JsonProperty("feeType")
  private String feeType = null;

  @JsonProperty("feeAmount")
  private String feeAmount = null;

  @JsonProperty("feeCurrency")
  private Currency feeCurrency = null;

  public Fees feeType(String feeType) {
    this.feeType = feeType;
    return this;
  }

  /**
   * Defines the type of fee.
   * @return feeType
   **/
  @Schema(required = true, description = "Defines the type of fee.")
      @NotNull

  @Size(min=1,max=256)   public String getFeeType() {
    return feeType;
  }

  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }

  public Fees feeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
    return this;
  }

  /**
   * Get feeAmount
   * @return feeAmount
   **/
  @Schema(example = "15.21", required = true, description = "")
      @NotNull

  @Pattern(regexp="^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$") @Size(min=1,max=23)   public String getFeeAmount() {
    return feeAmount;
  }

  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }

  public Fees feeCurrency(Currency feeCurrency) {
    this.feeCurrency = feeCurrency;
    return this;
  }

  /**
   * Get feeCurrency
   * @return feeCurrency
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Currency getFeeCurrency() {
    return feeCurrency;
  }

  public void setFeeCurrency(Currency feeCurrency) {
    this.feeCurrency = feeCurrency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fees fees = (Fees) o;
    return Objects.equals(this.feeType, fees.feeType) &&
        Objects.equals(this.feeAmount, fees.feeAmount) &&
        Objects.equals(this.feeCurrency, fees.feeCurrency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(feeType, feeAmount, feeCurrency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fees {\n");
    
    sb.append("    feeType: ").append(toIndentedString(feeType)).append("\n");
    sb.append("    feeAmount: ").append(toIndentedString(feeAmount)).append("\n");
    sb.append("    feeCurrency: ").append(toIndentedString(feeCurrency)).append("\n");
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
