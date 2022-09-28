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
 * ResponseQuotation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseQuotation   {
  @JsonProperty("quotationReference")
  private String quotationReference = null;

  @JsonProperty("creditParty")
  private CreditPartyArray creditParty = null;

  @JsonProperty("debitParty")
  private DebitPartyArray debitParty = null;

  @JsonProperty("type")
  private Type type = null;

  @JsonProperty("subType")
  private String subType = null;

  @JsonProperty("quotationStatus")
  private QuotationStatus quotationStatus = null;

  @JsonProperty("requestAmount")
  private String requestAmount = null;

  @JsonProperty("requestCurrency")
  private Currency requestCurrency = null;

  @JsonProperty("availableDeliveryMethod")
  private DeliveryMethod availableDeliveryMethod = null;

  @JsonProperty("chosenDeliveryMethod")
  private DeliveryMethod chosenDeliveryMethod = null;

  @JsonProperty("originCountry")
  private Nationality originCountry = null;

  @JsonProperty("receivingCountry")
  private Nationality receivingCountry = null;

  @JsonProperty("quotes")
  private QuoteArray quotes = null;

  @JsonProperty("recipientKyc")
  private Kyc recipientKyc = null;

  @JsonProperty("senderKyc")
  private Kyc senderKyc = null;

  @JsonProperty("recipientBlockingReason")
  private String recipientBlockingReason = null;

  @JsonProperty("senderBlockingReason")
  private String senderBlockingReason = null;

  @JsonProperty("requestingOrganisation")
  private RequestingOrganisation requestingOrganisation = null;

  @JsonProperty("sendingServiceProviderCountry")
  private Nationality sendingServiceProviderCountry = null;

  @JsonProperty("creationDate")
  private OffsetDateTime creationDate = null;

  @JsonProperty("modificationDate")
  private OffsetDateTime modificationDate = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("dateCreated")
  private OffsetDateTime dateCreated = null;

  @JsonProperty("dateModified")
  private OffsetDateTime dateModified = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  @JsonProperty("metadata")
  private MetadataArray metadata = null;

  public ResponseQuotation quotationReference(String quotationReference) {
    this.quotationReference = quotationReference;
    return this;
  }

  /**
   * Reference for the quotation that was provided to the sender.
   * @return quotationReference
   **/
  @Schema(required = true, description = "Reference for the quotation that was provided to the sender.")
      @NotNull

  @Size(min=1,max=256)   public String getQuotationReference() {
    return quotationReference;
  }

  public void setQuotationReference(String quotationReference) {
    this.quotationReference = quotationReference;
  }

  public ResponseQuotation creditParty(CreditPartyArray creditParty) {
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

  public ResponseQuotation debitParty(DebitPartyArray debitParty) {
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

  public ResponseQuotation type(Type type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(description = "")
  
    @Valid
    public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public ResponseQuotation subType(String subType) {
    this.subType = subType;
    return this;
  }

  /**
   * A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary according to Provider.
   * @return subType
   **/
  @Schema(description = "A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary according to Provider.")
  
  @Size(max=256)   public String getSubType() {
    return subType;
  }

  public void setSubType(String subType) {
    this.subType = subType;
  }

  public ResponseQuotation quotationStatus(QuotationStatus quotationStatus) {
    this.quotationStatus = quotationStatus;
    return this;
  }

  /**
   * Get quotationStatus
   * @return quotationStatus
   **/
  @Schema(description = "")
  
    @Valid
    public QuotationStatus getQuotationStatus() {
    return quotationStatus;
  }

  public void setQuotationStatus(QuotationStatus quotationStatus) {
    this.quotationStatus = quotationStatus;
  }

  public ResponseQuotation requestAmount(String requestAmount) {
    this.requestAmount = requestAmount;
    return this;
  }

  /**
   * Get requestAmount
   * @return requestAmount
   **/
  @Schema(example = "15.21", required = true, description = "")
      @NotNull

  @Pattern(regexp="^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$") @Size(min=1,max=23)   public String getRequestAmount() {
    return requestAmount;
  }

  public void setRequestAmount(String requestAmount) {
    this.requestAmount = requestAmount;
  }

  public ResponseQuotation requestCurrency(Currency requestCurrency) {
    this.requestCurrency = requestCurrency;
    return this;
  }

  /**
   * Get requestCurrency
   * @return requestCurrency
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Currency getRequestCurrency() {
    return requestCurrency;
  }

  public void setRequestCurrency(Currency requestCurrency) {
    this.requestCurrency = requestCurrency;
  }

  public ResponseQuotation availableDeliveryMethod(DeliveryMethod availableDeliveryMethod) {
    this.availableDeliveryMethod = availableDeliveryMethod;
    return this;
  }

  /**
   * Get availableDeliveryMethod
   * @return availableDeliveryMethod
   **/
  @Schema(description = "")
  
    @Valid
    public DeliveryMethod getAvailableDeliveryMethod() {
    return availableDeliveryMethod;
  }

  public void setAvailableDeliveryMethod(DeliveryMethod availableDeliveryMethod) {
    this.availableDeliveryMethod = availableDeliveryMethod;
  }

  public ResponseQuotation chosenDeliveryMethod(DeliveryMethod chosenDeliveryMethod) {
    this.chosenDeliveryMethod = chosenDeliveryMethod;
    return this;
  }

  /**
   * Get chosenDeliveryMethod
   * @return chosenDeliveryMethod
   **/
  @Schema(description = "")
  
    @Valid
    public DeliveryMethod getChosenDeliveryMethod() {
    return chosenDeliveryMethod;
  }

  public void setChosenDeliveryMethod(DeliveryMethod chosenDeliveryMethod) {
    this.chosenDeliveryMethod = chosenDeliveryMethod;
  }

  public ResponseQuotation originCountry(Nationality originCountry) {
    this.originCountry = originCountry;
    return this;
  }

  /**
   * Get originCountry
   * @return originCountry
   **/
  @Schema(description = "")
  
    @Valid
    public Nationality getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(Nationality originCountry) {
    this.originCountry = originCountry;
  }

  public ResponseQuotation receivingCountry(Nationality receivingCountry) {
    this.receivingCountry = receivingCountry;
    return this;
  }

  /**
   * Get receivingCountry
   * @return receivingCountry
   **/
  @Schema(description = "")
  
    @Valid
    public Nationality getReceivingCountry() {
    return receivingCountry;
  }

  public void setReceivingCountry(Nationality receivingCountry) {
    this.receivingCountry = receivingCountry;
  }

  public ResponseQuotation quotes(QuoteArray quotes) {
    this.quotes = quotes;
    return this;
  }

  /**
   * Get quotes
   * @return quotes
   **/
  @Schema(description = "")
  
    @Valid
    public QuoteArray getQuotes() {
    return quotes;
  }

  public void setQuotes(QuoteArray quotes) {
    this.quotes = quotes;
  }

  public ResponseQuotation recipientKyc(Kyc recipientKyc) {
    this.recipientKyc = recipientKyc;
    return this;
  }

  /**
   * Get recipientKyc
   * @return recipientKyc
   **/
  @Schema(description = "")
  
    @Valid
    public Kyc getRecipientKyc() {
    return recipientKyc;
  }

  public void setRecipientKyc(Kyc recipientKyc) {
    this.recipientKyc = recipientKyc;
  }

  public ResponseQuotation senderKyc(Kyc senderKyc) {
    this.senderKyc = senderKyc;
    return this;
  }

  /**
   * Get senderKyc
   * @return senderKyc
   **/
  @Schema(description = "")
  
    @Valid
    public Kyc getSenderKyc() {
    return senderKyc;
  }

  public void setSenderKyc(Kyc senderKyc) {
    this.senderKyc = senderKyc;
  }

  public ResponseQuotation recipientBlockingReason(String recipientBlockingReason) {
    this.recipientBlockingReason = recipientBlockingReason;
    return this;
  }

  /**
   * The reason for blocking the quotation, based on AML checks on the recipient.
   * @return recipientBlockingReason
   **/
  @Schema(description = "The reason for blocking the quotation, based on AML checks on the recipient.")
  
  @Size(max=256)   public String getRecipientBlockingReason() {
    return recipientBlockingReason;
  }

  public void setRecipientBlockingReason(String recipientBlockingReason) {
    this.recipientBlockingReason = recipientBlockingReason;
  }

  public ResponseQuotation senderBlockingReason(String senderBlockingReason) {
    this.senderBlockingReason = senderBlockingReason;
    return this;
  }

  /**
   * The reason for blocking the quotation, based on AML checks on the sender.
   * @return senderBlockingReason
   **/
  @Schema(description = "The reason for blocking the quotation, based on AML checks on the sender.")
  
  @Size(max=256)   public String getSenderBlockingReason() {
    return senderBlockingReason;
  }

  public void setSenderBlockingReason(String senderBlockingReason) {
    this.senderBlockingReason = senderBlockingReason;
  }

  public ResponseQuotation requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

  public ResponseQuotation sendingServiceProviderCountry(Nationality sendingServiceProviderCountry) {
    this.sendingServiceProviderCountry = sendingServiceProviderCountry;
    return this;
  }

  /**
   * Get sendingServiceProviderCountry
   * @return sendingServiceProviderCountry
   **/
  @Schema(description = "")
  
    @Valid
    public Nationality getSendingServiceProviderCountry() {
    return sendingServiceProviderCountry;
  }

  public void setSendingServiceProviderCountry(Nationality sendingServiceProviderCountry) {
    this.sendingServiceProviderCountry = sendingServiceProviderCountry;
  }

  public ResponseQuotation creationDate(OffsetDateTime creationDate) {
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

  public ResponseQuotation modificationDate(OffsetDateTime modificationDate) {
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

  public ResponseQuotation requestDate(OffsetDateTime requestDate) {
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

  public ResponseQuotation dateCreated(OffsetDateTime dateCreated) {
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

  public ResponseQuotation dateModified(OffsetDateTime dateModified) {
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

  public ResponseQuotation customData(CustomDataArray customData) {
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

  public ResponseQuotation metadata(MetadataArray metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Schema(description = "")
  
    @Valid
    public MetadataArray getMetadata() {
    return metadata;
  }

  public void setMetadata(MetadataArray metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseQuotation responseQuotation = (ResponseQuotation) o;
    return Objects.equals(this.quotationReference, responseQuotation.quotationReference) &&
        Objects.equals(this.creditParty, responseQuotation.creditParty) &&
        Objects.equals(this.debitParty, responseQuotation.debitParty) &&
        Objects.equals(this.type, responseQuotation.type) &&
        Objects.equals(this.subType, responseQuotation.subType) &&
        Objects.equals(this.quotationStatus, responseQuotation.quotationStatus) &&
        Objects.equals(this.requestAmount, responseQuotation.requestAmount) &&
        Objects.equals(this.requestCurrency, responseQuotation.requestCurrency) &&
        Objects.equals(this.availableDeliveryMethod, responseQuotation.availableDeliveryMethod) &&
        Objects.equals(this.chosenDeliveryMethod, responseQuotation.chosenDeliveryMethod) &&
        Objects.equals(this.originCountry, responseQuotation.originCountry) &&
        Objects.equals(this.receivingCountry, responseQuotation.receivingCountry) &&
        Objects.equals(this.quotes, responseQuotation.quotes) &&
        Objects.equals(this.recipientKyc, responseQuotation.recipientKyc) &&
        Objects.equals(this.senderKyc, responseQuotation.senderKyc) &&
        Objects.equals(this.recipientBlockingReason, responseQuotation.recipientBlockingReason) &&
        Objects.equals(this.senderBlockingReason, responseQuotation.senderBlockingReason) &&
        Objects.equals(this.requestingOrganisation, responseQuotation.requestingOrganisation) &&
        Objects.equals(this.sendingServiceProviderCountry, responseQuotation.sendingServiceProviderCountry) &&
        Objects.equals(this.creationDate, responseQuotation.creationDate) &&
        Objects.equals(this.modificationDate, responseQuotation.modificationDate) &&
        Objects.equals(this.requestDate, responseQuotation.requestDate) &&
        Objects.equals(this.dateCreated, responseQuotation.dateCreated) &&
        Objects.equals(this.dateModified, responseQuotation.dateModified) &&
        Objects.equals(this.customData, responseQuotation.customData) &&
        Objects.equals(this.metadata, responseQuotation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quotationReference, creditParty, debitParty, type, subType, quotationStatus, requestAmount, requestCurrency, availableDeliveryMethod, chosenDeliveryMethod, originCountry, receivingCountry, quotes, recipientKyc, senderKyc, recipientBlockingReason, senderBlockingReason, requestingOrganisation, sendingServiceProviderCountry, creationDate, modificationDate, requestDate, dateCreated, dateModified, customData, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseQuotation {\n");
    
    sb.append("    quotationReference: ").append(toIndentedString(quotationReference)).append("\n");
    sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
    sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    quotationStatus: ").append(toIndentedString(quotationStatus)).append("\n");
    sb.append("    requestAmount: ").append(toIndentedString(requestAmount)).append("\n");
    sb.append("    requestCurrency: ").append(toIndentedString(requestCurrency)).append("\n");
    sb.append("    availableDeliveryMethod: ").append(toIndentedString(availableDeliveryMethod)).append("\n");
    sb.append("    chosenDeliveryMethod: ").append(toIndentedString(chosenDeliveryMethod)).append("\n");
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    receivingCountry: ").append(toIndentedString(receivingCountry)).append("\n");
    sb.append("    quotes: ").append(toIndentedString(quotes)).append("\n");
    sb.append("    recipientKyc: ").append(toIndentedString(recipientKyc)).append("\n");
    sb.append("    senderKyc: ").append(toIndentedString(senderKyc)).append("\n");
    sb.append("    recipientBlockingReason: ").append(toIndentedString(recipientBlockingReason)).append("\n");
    sb.append("    senderBlockingReason: ").append(toIndentedString(senderBlockingReason)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
    sb.append("    sendingServiceProviderCountry: ").append(toIndentedString(sendingServiceProviderCountry)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
    sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
    sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
