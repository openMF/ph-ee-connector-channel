package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * ResponseStatementEntries
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseStatementEntries   {
  @JsonProperty("transactionReference")
  private String transactionReference = null;

  @JsonProperty("creditParty")
  private CreditPartyArray creditParty = null;

  @JsonProperty("debitParty")
  private DebitPartyArray debitParty = null;

  @JsonProperty("transactionStatus")
  private String transactionStatus = null;

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("descriptionText")
  private String descriptionText = null;

  @JsonProperty("displayType")
  private String displayType = null;

  @JsonProperty("transactionReceipt")
  private String transactionReceipt = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("modificationDate")
  private OffsetDateTime modificationDate = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  @JsonProperty("dateCreated")
  private OffsetDateTime dateCreated = null;

  @JsonProperty("dateModified")
  private OffsetDateTime dateModified = null;

  public ResponseStatementEntries transactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
    return this;
  }

  /**
   * Unique reference for the transaction. This is returned in the response by API provider.
   * @return transactionReference
   **/
  @Schema(required = true, description = "Unique reference for the transaction. This is returned in the response by API provider.")
      @NotNull

  @Size(min=1,max=256)   public String getTransactionReference() {
    return transactionReference;
  }

  public void setTransactionReference(String transactionReference) {
    this.transactionReference = transactionReference;
  }

  public ResponseStatementEntries creditParty(CreditPartyArray creditParty) {
    this.creditParty = creditParty;
    return this;
  }

  /**
   * Get creditParty
   * @return creditParty
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public CreditPartyArray getCreditParty() {
    return creditParty;
  }

  public void setCreditParty(CreditPartyArray creditParty) {
    this.creditParty = creditParty;
  }

  public ResponseStatementEntries debitParty(DebitPartyArray debitParty) {
    this.debitParty = debitParty;
    return this;
  }

  /**
   * Get debitParty
   * @return debitParty
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DebitPartyArray getDebitParty() {
    return debitParty;
  }

  public void setDebitParty(DebitPartyArray debitParty) {
    this.debitParty = debitParty;
  }

  public ResponseStatementEntries transactionStatus(String transactionStatus) {
    this.transactionStatus = transactionStatus;
    return this;
  }

  /**
   * Indicates the status of the transaction as stored by the API provider.
   * @return transactionStatus
   **/
  @Schema(required = true, description = "Indicates the status of the transaction as stored by the API provider.")
      @NotNull

  @Size(min=1,max=256)   public String getTransactionStatus() {
    return transactionStatus;
  }

  public void setTransactionStatus(String transactionStatus) {
    this.transactionStatus = transactionStatus;
  }

  public ResponseStatementEntries amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(example = "15.21", required = true, description = "")
      @NotNull

  @Pattern(regexp="^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$") @Size(min=1,max=23)   public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public ResponseStatementEntries currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Get currency
   * @return currency
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public ResponseStatementEntries descriptionText(String descriptionText) {
    this.descriptionText = descriptionText;
    return this;
  }

  /**
   * Free format text description of the transaction provided by the client. This can be provided as a reference for the receiver on a notification SMS and on an account statement.
   * @return descriptionText
   **/
  @Schema(description = "Free format text description of the transaction provided by the client. This can be provided as a reference for the receiver on a notification SMS and on an account statement.")
  
  @Size(max=160)   public String getDescriptionText() {
    return descriptionText;
  }

  public void setDescriptionText(String descriptionText) {
    this.descriptionText = descriptionText;
  }

  public ResponseStatementEntries displayType(String displayType) {
    this.displayType = displayType;
    return this;
  }

  /**
   * The transaction type that is to be used for presentation to the account holder as determined by the API provider. This is not necessarily the actual transaction type.
   * @return displayType
   **/
  @Schema(description = "The transaction type that is to be used for presentation to the account holder as determined by the API provider. This is not necessarily the actual transaction type.")
  
  @Size(max=256)   public String getDisplayType() {
    return displayType;
  }

  public void setDisplayType(String displayType) {
    this.displayType = displayType;
  }

  public ResponseStatementEntries transactionReceipt(String transactionReceipt) {
    this.transactionReceipt = transactionReceipt;
    return this;
  }

  /**
   * Transaction receipt number as notified to the parties. This may differ from the Transaction Reference.
   * @return transactionReceipt
   **/
  @Schema(description = "Transaction receipt number as notified to the parties. This may differ from the Transaction Reference.")
  
  @Size(max=256)   public String getTransactionReceipt() {
    return transactionReceipt;
  }

  public void setTransactionReceipt(String transactionReceipt) {
    this.transactionReceipt = transactionReceipt;
  }

  public ResponseStatementEntries creationDate(OffsetDateTime creationDate) {
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

  public ResponseStatementEntries modificationDate(OffsetDateTime modificationDate) {
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

  public ResponseStatementEntries requestDate(OffsetDateTime requestDate) {
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

  public ResponseStatementEntries customData(CustomDataArray customData) {
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

  public ResponseStatementEntries dateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  /**
   * Date and time when the object was created by the API Provider.
   * @return dateCreated
   **/
  @Schema(description = "Date and time when the object was created by the API Provider.")
  
    @Valid
    public OffsetDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(OffsetDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  public ResponseStatementEntries dateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
    return this;
  }

  /**
   * Date and time when the object was modified by the API Provider.
   * @return dateModified
   **/
  @Schema(description = "Date and time when the object was modified by the API Provider.")
  
    @Valid
    public OffsetDateTime getDateModified() {
    return dateModified;
  }

  public void setDateModified(OffsetDateTime dateModified) {
    this.dateModified = dateModified;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseStatementEntries responseStatementEntries = (ResponseStatementEntries) o;
    return Objects.equals(this.transactionReference, responseStatementEntries.transactionReference) &&
        Objects.equals(this.creditParty, responseStatementEntries.creditParty) &&
        Objects.equals(this.debitParty, responseStatementEntries.debitParty) &&
        Objects.equals(this.transactionStatus, responseStatementEntries.transactionStatus) &&
        Objects.equals(this.amount, responseStatementEntries.amount) &&
        Objects.equals(this.currency, responseStatementEntries.currency) &&
        Objects.equals(this.descriptionText, responseStatementEntries.descriptionText) &&
        Objects.equals(this.displayType, responseStatementEntries.displayType) &&
        Objects.equals(this.transactionReceipt, responseStatementEntries.transactionReceipt) &&
        Objects.equals(this.creationDate, responseStatementEntries.creationDate) &&
        Objects.equals(this.modificationDate, responseStatementEntries.modificationDate) &&
        Objects.equals(this.requestDate, responseStatementEntries.requestDate) &&
        Objects.equals(this.customData, responseStatementEntries.customData) &&
        Objects.equals(this.dateCreated, responseStatementEntries.dateCreated) &&
        Objects.equals(this.dateModified, responseStatementEntries.dateModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionReference, creditParty, debitParty, transactionStatus, amount, currency, descriptionText, displayType, transactionReceipt, creationDate, modificationDate, requestDate, customData, dateCreated, dateModified);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseStatementEntries {\n");
    
    sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
    sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
    sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
    sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    descriptionText: ").append(toIndentedString(descriptionText)).append("\n");
    sb.append("    displayType: ").append(toIndentedString(displayType)).append("\n");
    sb.append("    transactionReceipt: ").append(toIndentedString(transactionReceipt)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
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
