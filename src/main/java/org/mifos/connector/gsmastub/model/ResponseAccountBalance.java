package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * ResponseAccountBalance
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseAccountBalance   {
  @JsonProperty("accountStatus")
  private AccountStatus accountStatus = null;

  @JsonProperty("currentBalance")
  private String currentBalance = null;

  @JsonProperty("availableBalance")
  private String availableBalance = null;

  @JsonProperty("reservedBalance")
  private String reservedBalance = null;

  @JsonProperty("unclearedBalance")
  private String unclearedBalance = null;

  @JsonProperty("currency")
  private Currency currency = null;

  public ResponseAccountBalance accountStatus(AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * Get accountStatus
   * @return accountStatus
   **/
  @Schema(description = "")
  
    @Valid
  @Size(min=1,max=256)   public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
  }

  public ResponseAccountBalance currentBalance(String currentBalance) {
    this.currentBalance = currentBalance;
    return this;
  }

  /**
   * Get currentBalance
   * @return currentBalance
   **/
  @Schema(description = "")
  
    @Valid
    public String getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(String currentBalance) {
    this.currentBalance = currentBalance;
  }

  public ResponseAccountBalance availableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  /**
   * Get availableBalance
   * @return availableBalance
   **/
  @Schema(description = "")
  
    @Valid
    public String getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(String availableBalance) {
    this.availableBalance = availableBalance;
  }

  public ResponseAccountBalance reservedBalance(String reservedBalance) {
    this.reservedBalance = reservedBalance;
    return this;
  }

  /**
   * Get reservedBalance
   * @return reservedBalance
   **/
  @Schema(description = "")
  
    @Valid
    public String getReservedBalance() {
    return reservedBalance;
  }

  public void setReservedBalance(String reservedBalance) {
    this.reservedBalance = reservedBalance;
  }

  public ResponseAccountBalance unclearedBalance(String unclearedBalance) {
    this.unclearedBalance = unclearedBalance;
    return this;
  }

  /**
   * Get unclearedBalance
   * @return unclearedBalance
   **/
  @Schema(description = "")
  
    @Valid
    public String getUnclearedBalance() {
    return unclearedBalance;
  }

  public void setUnclearedBalance(String unclearedBalance) {
    this.unclearedBalance = unclearedBalance;
  }

  public ResponseAccountBalance currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(description = "")
  
    @Valid
    public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseAccountBalance responseAccountBalance = (ResponseAccountBalance) o;
    return Objects.equals(this.accountStatus, responseAccountBalance.accountStatus) &&
        Objects.equals(this.currentBalance, responseAccountBalance.currentBalance) &&
        Objects.equals(this.availableBalance, responseAccountBalance.availableBalance) &&
        Objects.equals(this.reservedBalance, responseAccountBalance.reservedBalance) &&
        Objects.equals(this.unclearedBalance, responseAccountBalance.unclearedBalance) &&
        Objects.equals(this.currency, responseAccountBalance.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountStatus, currentBalance, availableBalance, reservedBalance, unclearedBalance, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseAccountBalance {\n");
    
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    reservedBalance: ").append(toIndentedString(reservedBalance)).append("\n");
    sb.append("    unclearedBalance: ").append(toIndentedString(unclearedBalance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
