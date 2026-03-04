package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * ResponseDebitMandate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseDebitMandate   {
  @JsonProperty("mandateReference")
  private String mandateReference = null;

  @JsonProperty("payee")
  private Payee payee = null;

  @JsonProperty("mandateStatus")
  private MandateStatus mandateStatus = null;

  @JsonProperty("startDate")
  private LocalDate startDate = null;

  @JsonProperty("amountLimit")
  private String amountLimit = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("endDate")
  private LocalDate endDate = null;

  @JsonProperty("frequencyType")
  private FrequencyType frequencyType = null;

  @JsonProperty("numberOfPayments")
  private BigDecimal numberOfPayments = null;

  @JsonProperty("requestingOrganisation")
  private RequestingOrganisation requestingOrganisation = null;

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

  public ResponseDebitMandate mandateReference(String mandateReference) {
    this.mandateReference = mandateReference;
    return this;
  }

  /**
   * Unique reference provided by the API Provider for the mandate.
   * @return mandateReference
   **/
  @Schema(required = true, description = "Unique reference provided by the API Provider for the mandate.")
      @NotNull

  @Size(max=256)   public String getMandateReference() {
    return mandateReference;
  }

  public void setMandateReference(String mandateReference) {
    this.mandateReference = mandateReference;
  }

  public ResponseDebitMandate payee(Payee payee) {
    this.payee = payee;
    return this;
  }

  /**
   * Get payee
   * @return payee
   **/
  @Schema(description = "")
  
    @Valid
    public Payee getPayee() {
    return payee;
  }

  public void setPayee(Payee payee) {
    this.payee = payee;
  }

  public ResponseDebitMandate mandateStatus(MandateStatus mandateStatus) {
    this.mandateStatus = mandateStatus;
    return this;
  }

  /**
   * Get mandateStatus
   * @return mandateStatus
   **/
  @Schema(description = "")
  
    @Valid
    public MandateStatus getMandateStatus() {
    return mandateStatus;
  }

  public void setMandateStatus(MandateStatus mandateStatus) {
    this.mandateStatus = mandateStatus;
  }

  public ResponseDebitMandate startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Date on which the mandate starts. If a frequencyType is specified, this will also be the date on which the first payment is to be taken.
   * @return startDate
   **/
  @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", description = "Date on which the mandate starts. If a frequencyType is specified, this will also be the date on which the first payment is to be taken.")
  
    @Valid
    public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public ResponseDebitMandate amountLimit(String amountLimit) {
    this.amountLimit = amountLimit;
    return this;
  }

  /**
   * Get amountLimit
   * @return amountLimit
   **/
  @Schema(example = "15.21", description = "")
  
  @Pattern(regexp="^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$") @Size(min=1,max=23)   public String getAmountLimit() {
    return amountLimit;
  }

  public void setAmountLimit(String amountLimit) {
    this.amountLimit = amountLimit;
  }

  public ResponseDebitMandate currency(Currency currency) {
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

  public ResponseDebitMandate endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Date on which the mandate ends.
   * @return endDate
   **/
  @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", description = "Date on which the mandate ends.")
  
    @Valid
    public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public ResponseDebitMandate frequencyType(FrequencyType frequencyType) {
    this.frequencyType = frequencyType;
    return this;
  }

  /**
   * Get frequencyType
   * @return frequencyType
   **/
  @Schema(description = "")
  
    @Valid
    public FrequencyType getFrequencyType() {
    return frequencyType;
  }

  public void setFrequencyType(FrequencyType frequencyType) {
    this.frequencyType = frequencyType;
  }

  public ResponseDebitMandate numberOfPayments(BigDecimal numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
    return this;
  }

  /**
   * Indicates the number of consecutive payments that are to be taken.
   * minimum: 0
   * @return numberOfPayments
   **/
  @Schema(description = "Indicates the number of consecutive payments that are to be taken.")
  
    @Valid
  @DecimalMin("0")  public BigDecimal getNumberOfPayments() {
    return numberOfPayments;
  }

  public void setNumberOfPayments(BigDecimal numberOfPayments) {
    this.numberOfPayments = numberOfPayments;
  }

  public ResponseDebitMandate requestingOrganisation(RequestingOrganisation requestingOrganisation) {
    this.requestingOrganisation = requestingOrganisation;
    return this;
  }

  /**
   * Get requestingOrganisation
   * @return requestingOrganisation
   **/
  @Schema(description = "")
  
    @Valid
    public RequestingOrganisation getRequestingOrganisation() {
    return requestingOrganisation;
  }

  public void setRequestingOrganisation(RequestingOrganisation requestingOrganisation) {
    this.requestingOrganisation = requestingOrganisation;
  }

  public ResponseDebitMandate creationDate(OffsetDateTime creationDate) {
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

  public ResponseDebitMandate modificationDate(OffsetDateTime modificationDate) {
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

  public ResponseDebitMandate requestDate(OffsetDateTime requestDate) {
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

  public ResponseDebitMandate customData(CustomDataArray customData) {
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

  public ResponseDebitMandate dateCreated(OffsetDateTime dateCreated) {
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

  public ResponseDebitMandate dateModified(OffsetDateTime dateModified) {
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
    ResponseDebitMandate responseDebitMandate = (ResponseDebitMandate) o;
    return Objects.equals(this.mandateReference, responseDebitMandate.mandateReference) &&
        Objects.equals(this.payee, responseDebitMandate.payee) &&
        Objects.equals(this.mandateStatus, responseDebitMandate.mandateStatus) &&
        Objects.equals(this.startDate, responseDebitMandate.startDate) &&
        Objects.equals(this.amountLimit, responseDebitMandate.amountLimit) &&
        Objects.equals(this.currency, responseDebitMandate.currency) &&
        Objects.equals(this.endDate, responseDebitMandate.endDate) &&
        Objects.equals(this.frequencyType, responseDebitMandate.frequencyType) &&
        Objects.equals(this.numberOfPayments, responseDebitMandate.numberOfPayments) &&
        Objects.equals(this.requestingOrganisation, responseDebitMandate.requestingOrganisation) &&
        Objects.equals(this.creationDate, responseDebitMandate.creationDate) &&
        Objects.equals(this.modificationDate, responseDebitMandate.modificationDate) &&
        Objects.equals(this.requestDate, responseDebitMandate.requestDate) &&
        Objects.equals(this.customData, responseDebitMandate.customData) &&
        Objects.equals(this.dateCreated, responseDebitMandate.dateCreated) &&
        Objects.equals(this.dateModified, responseDebitMandate.dateModified);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mandateReference, payee, mandateStatus, startDate, amountLimit, currency, endDate, frequencyType, numberOfPayments, requestingOrganisation, creationDate, modificationDate, requestDate, customData, dateCreated, dateModified);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDebitMandate {\n");
    
    sb.append("    mandateReference: ").append(toIndentedString(mandateReference)).append("\n");
    sb.append("    payee: ").append(toIndentedString(payee)).append("\n");
    sb.append("    mandateStatus: ").append(toIndentedString(mandateStatus)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    amountLimit: ").append(toIndentedString(amountLimit)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    frequencyType: ").append(toIndentedString(frequencyType)).append("\n");
    sb.append("    numberOfPayments: ").append(toIndentedString(numberOfPayments)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
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
