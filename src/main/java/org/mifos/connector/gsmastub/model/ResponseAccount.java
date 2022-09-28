package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * ResponseAccount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseAccount   {
  @JsonProperty("accountIdentifiers")
  private AccountIdentifiersArray accountIdentifiers = null;

  @JsonProperty("identity")
  private IdentityResponseArray identity = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("accountStatus")
  private AccountStatus accountStatus = null;

  @JsonProperty("accountSubStatus")
  private String accountSubStatus = null;

  @JsonProperty("currentBalance")
  private CurrentBalance currentBalance = null;

  @JsonProperty("availableBalance")
  private AvailableBalance availableBalance = null;

  @JsonProperty("reservedBalance")
  private ReservedBalance reservedBalance = null;

  @JsonProperty("unclearedBalance")
  private UnclearedBalance unclearedBalance = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("fees")
  private FeesArray fees = null;

  @JsonProperty("commissionEarned")
  private CommissionEarnedArray commissionEarned = null;

  @JsonProperty("registeringEntity")
  private String registeringEntity = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("modificationDate")
  private OffsetDateTime modificationDate = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  public ResponseAccount accountIdentifiers(AccountIdentifiersArray accountIdentifiers) {
    this.accountIdentifiers = accountIdentifiers;
    return this;
  }

  /**
   * Get accountIdentifiers
   * @return accountIdentifiers
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public AccountIdentifiersArray getAccountIdentifiers() {
    return accountIdentifiers;
  }

  public void setAccountIdentifiers(AccountIdentifiersArray accountIdentifiers) {
    this.accountIdentifiers = accountIdentifiers;
  }

  public ResponseAccount identity(IdentityResponseArray identity) {
    this.identity = identity;
    return this;
  }

  /**
   * Get identity
   * @return identity
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public IdentityResponseArray getIdentity() {
    return identity;
  }

  public void setIdentity(IdentityResponseArray identity) {
    this.identity = identity;
  }

  public ResponseAccount accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * A non-harmonised field that indicates the type of the account.
   * @return accountType
   **/
  @Schema(description = "A non-harmonised field that indicates the type of the account.")
  
  @Size(max=256)   public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public ResponseAccount accountStatus(AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  /**
   * Get accountStatus
   * @return accountStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
  @Size(min=1,max=256)   public AccountStatus getAccountStatus() {
    return accountStatus;
  }

  public void setAccountStatus(AccountStatus accountStatus) {
    this.accountStatus = accountStatus;
  }

  public ResponseAccount accountSubStatus(String accountSubStatus) {
    this.accountSubStatus = accountSubStatus;
    return this;
  }

  /**
   * Field can be used to return a provider-specific status for the account.
   * @return accountSubStatus
   **/
  @Schema(description = "Field can be used to return a provider-specific status for the account.")
  
  @Size(max=256)   public String getAccountSubStatus() {
    return accountSubStatus;
  }

  public void setAccountSubStatus(String accountSubStatus) {
    this.accountSubStatus = accountSubStatus;
  }

  public ResponseAccount currentBalance(CurrentBalance currentBalance) {
    this.currentBalance = currentBalance;
    return this;
  }

  /**
   * Get currentBalance
   * @return currentBalance
   **/
  @Schema(description = "")
  
    @Valid
    public CurrentBalance getCurrentBalance() {
    return currentBalance;
  }

  public void setCurrentBalance(CurrentBalance currentBalance) {
    this.currentBalance = currentBalance;
  }

  public ResponseAccount availableBalance(AvailableBalance availableBalance) {
    this.availableBalance = availableBalance;
    return this;
  }

  /**
   * Get availableBalance
   * @return availableBalance
   **/
  @Schema(description = "")
  
    @Valid
    public AvailableBalance getAvailableBalance() {
    return availableBalance;
  }

  public void setAvailableBalance(AvailableBalance availableBalance) {
    this.availableBalance = availableBalance;
  }

  public ResponseAccount reservedBalance(ReservedBalance reservedBalance) {
    this.reservedBalance = reservedBalance;
    return this;
  }

  /**
   * Get reservedBalance
   * @return reservedBalance
   **/
  @Schema(description = "")
  
    @Valid
    public ReservedBalance getReservedBalance() {
    return reservedBalance;
  }

  public void setReservedBalance(ReservedBalance reservedBalance) {
    this.reservedBalance = reservedBalance;
  }

  public ResponseAccount unclearedBalance(UnclearedBalance unclearedBalance) {
    this.unclearedBalance = unclearedBalance;
    return this;
  }

  /**
   * Get unclearedBalance
   * @return unclearedBalance
   **/
  @Schema(description = "")
  
    @Valid
    public UnclearedBalance getUnclearedBalance() {
    return unclearedBalance;
  }

  public void setUnclearedBalance(UnclearedBalance unclearedBalance) {
    this.unclearedBalance = unclearedBalance;
  }

  public ResponseAccount currency(Currency currency) {
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

  public ResponseAccount fees(FeesArray fees) {
    this.fees = fees;
    return this;
  }

  /**
   * Get fees
   * @return fees
   **/
  @Schema(description = "")
  
    @Valid
    public FeesArray getFees() {
    return fees;
  }

  public void setFees(FeesArray fees) {
    this.fees = fees;
  }

  public ResponseAccount commissionEarned(CommissionEarnedArray commissionEarned) {
    this.commissionEarned = commissionEarned;
    return this;
  }

  /**
   * Get commissionEarned
   * @return commissionEarned
   **/
  @Schema(description = "")
  
    @Valid
    public CommissionEarnedArray getCommissionEarned() {
    return commissionEarned;
  }

  public void setCommissionEarned(CommissionEarnedArray commissionEarned) {
    this.commissionEarned = commissionEarned;
  }

  public ResponseAccount registeringEntity(String registeringEntity) {
    this.registeringEntity = registeringEntity;
    return this;
  }

  /**
   * The entity that registered the account, for example, a mobile money agent.
   * @return registeringEntity
   **/
  @Schema(description = "The entity that registered the account, for example, a mobile money agent.")
  
  @Size(max=256)   public String getRegisteringEntity() {
    return registeringEntity;
  }

  public void setRegisteringEntity(String registeringEntity) {
    this.registeringEntity = registeringEntity;
  }

  public ResponseAccount creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date and time when the object was created by the API Provider.
   * @return creationDate
   **/
  @Schema(description = "Date and time when the object was created by the API Provider.")
  
    @Valid
    public OffsetDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public ResponseAccount modificationDate(OffsetDateTime modificationDate) {
    this.modificationDate = modificationDate;
    return this;
  }

  /**
   * Date and time when the object was modified by the API Provider.
   * @return modificationDate
   **/
  @Schema(description = "Date and time when the object was modified by the API Provider.")
  
    @Valid
    public OffsetDateTime getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(OffsetDateTime modificationDate) {
    this.modificationDate = modificationDate;
  }

  public ResponseAccount requestDate(OffsetDateTime requestDate) {
    this.requestDate = requestDate;
    return this;
  }

  /**
   * The date and time of the request as supplied by the client.
   * @return requestDate
   **/
  @Schema(description = "The date and time of the request as supplied by the client.")
  
    @Valid
    public OffsetDateTime getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(OffsetDateTime requestDate) {
    this.requestDate = requestDate;
  }

  public ResponseAccount customData(CustomDataArray customData) {
    this.customData = customData;
    return this;
  }

  /**
   * Get customData
   * @return customData
   **/
  @Schema(description = "")
  
    @Valid
    public CustomDataArray getCustomData() {
    return customData;
  }

  public void setCustomData(CustomDataArray customData) {
    this.customData = customData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseAccount responseAccount = (ResponseAccount) o;
    return Objects.equals(this.accountIdentifiers, responseAccount.accountIdentifiers) &&
        Objects.equals(this.identity, responseAccount.identity) &&
        Objects.equals(this.accountType, responseAccount.accountType) &&
        Objects.equals(this.accountStatus, responseAccount.accountStatus) &&
        Objects.equals(this.accountSubStatus, responseAccount.accountSubStatus) &&
        Objects.equals(this.currentBalance, responseAccount.currentBalance) &&
        Objects.equals(this.availableBalance, responseAccount.availableBalance) &&
        Objects.equals(this.reservedBalance, responseAccount.reservedBalance) &&
        Objects.equals(this.unclearedBalance, responseAccount.unclearedBalance) &&
        Objects.equals(this.currency, responseAccount.currency) &&
        Objects.equals(this.fees, responseAccount.fees) &&
        Objects.equals(this.commissionEarned, responseAccount.commissionEarned) &&
        Objects.equals(this.registeringEntity, responseAccount.registeringEntity) &&
        Objects.equals(this.creationDate, responseAccount.creationDate) &&
        Objects.equals(this.modificationDate, responseAccount.modificationDate) &&
        Objects.equals(this.requestDate, responseAccount.requestDate) &&
        Objects.equals(this.customData, responseAccount.customData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountIdentifiers, identity, accountType, accountStatus, accountSubStatus, currentBalance, availableBalance, reservedBalance, unclearedBalance, currency, fees, commissionEarned, registeringEntity, creationDate, modificationDate, requestDate, customData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseAccount {\n");
    
    sb.append("    accountIdentifiers: ").append(toIndentedString(accountIdentifiers)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
    sb.append("    accountSubStatus: ").append(toIndentedString(accountSubStatus)).append("\n");
    sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
    sb.append("    availableBalance: ").append(toIndentedString(availableBalance)).append("\n");
    sb.append("    reservedBalance: ").append(toIndentedString(reservedBalance)).append("\n");
    sb.append("    unclearedBalance: ").append(toIndentedString(unclearedBalance)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    commissionEarned: ").append(toIndentedString(commissionEarned)).append("\n");
    sb.append("    registeringEntity: ").append(toIndentedString(registeringEntity)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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
