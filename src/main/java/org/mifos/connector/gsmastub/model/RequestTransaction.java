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
 * RequestTransaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestTransaction   {
  @JsonProperty("requestingOrganisationTransactionReference")
  private String requestingOrganisationTransactionReference = null;

  @JsonProperty("originalTransactionReference")
  private String originalTransactionReference = null;

  @JsonProperty("creditParty")
  private CreditPartyArray creditParty = null;

  @JsonProperty("debitParty")
  private DebitPartyArray debitParty = null;

  @JsonProperty("type")
  private Type type = null;

  @JsonProperty("subType")
  private String subType = null;

  @JsonProperty("amount")
  private String amount = null;

  @JsonProperty("currency")
  private Currency currency = null;

  @JsonProperty("descriptionText")
  private String descriptionText = null;

  @JsonProperty("fees")
  private FeesArray fees = null;

  @JsonProperty("geoCode")
  private String geoCode = null;

  @JsonProperty("internationalTransferInformation")
  private InternationalTransferInformation internationalTransferInformation = null;

  @JsonProperty("oneTimeCode")
  private String oneTimeCode = null;

  @JsonProperty("recipientKyc")
  private Kyc recipientKyc = null;

  @JsonProperty("senderKyc")
  private Kyc senderKyc = null;

  @JsonProperty("requestingOrganisation")
  private RequestingOrganisation requestingOrganisation = null;

  @JsonProperty("servicingIdentity")
  private String servicingIdentity = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  @JsonProperty("metadata")
  private MetadataArray metadata = null;

  @JsonProperty("receivingLei")
  private String receivingLei = null;

  @JsonProperty("requestingLei")
  private String requestingLei = null;

  public RequestTransaction requestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
    this.requestingOrganisationTransactionReference = requestingOrganisationTransactionReference;
    return this;
  }

  /**
   * A reference provided by the requesting organisation that is to be associated with the transaction.
   * @return requestingOrganisationTransactionReference
   **/
  @Schema(description = "A reference provided by the requesting organisation that is to be associated with the transaction.")
  
  @Size(max=256)   public String getRequestingOrganisationTransactionReference() {
    return requestingOrganisationTransactionReference;
  }

  public void setRequestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
    this.requestingOrganisationTransactionReference = requestingOrganisationTransactionReference;
  }

  public RequestTransaction originalTransactionReference(String originalTransactionReference) {
    this.originalTransactionReference = originalTransactionReference;
    return this;
  }

  /**
   * For reversals and refunds, this field indicates the transaction which is the subject of the reversal.
   * @return originalTransactionReference
   **/
  @Schema(description = "For reversals and refunds, this field indicates the transaction which is the subject of the reversal.")
  
  @Size(max=256)   public String getOriginalTransactionReference() {
    return originalTransactionReference;
  }

  public void setOriginalTransactionReference(String originalTransactionReference) {
    this.originalTransactionReference = originalTransactionReference;
  }

  public RequestTransaction creditParty(CreditPartyArray creditParty) {
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

  public RequestTransaction debitParty(DebitPartyArray debitParty) {
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

  public RequestTransaction type(Type type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public RequestTransaction subType(String subType) {
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

  public RequestTransaction amount(String amount) {
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

  public RequestTransaction currency(Currency currency) {
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

  public RequestTransaction descriptionText(String descriptionText) {
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

  public RequestTransaction fees(FeesArray fees) {
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

  public RequestTransaction geoCode(String geoCode) {
    this.geoCode = geoCode;
    return this;
  }

  /**
   * Indicates the geographic location from where the transaction was initiated.
   * @return geoCode
   **/
  @Schema(example = "37.423825,-122.082900", description = "Indicates the geographic location from where the transaction was initiated.")
  
  @Pattern(regexp="^(-?(90|(\\d|[1-8]\\d)(\\.\\d{1,6}){0,1}))\\,{1}(-?(180|(\\d|\\d\\d|1[0-7]\\d)(\\.\\d{1,6}){0,1}))$") @Size(max=256)   public String getGeoCode() {
    return geoCode;
  }

  public void setGeoCode(String geoCode) {
    this.geoCode = geoCode;
  }

  public RequestTransaction internationalTransferInformation(InternationalTransferInformation internationalTransferInformation) {
    this.internationalTransferInformation = internationalTransferInformation;
    return this;
  }

  /**
   * Get internationalTransferInformation
   * @return internationalTransferInformation
   **/
  @Schema(description = "")
  
    @Valid
    public InternationalTransferInformation getInternationalTransferInformation() {
    return internationalTransferInformation;
  }

  public void setInternationalTransferInformation(InternationalTransferInformation internationalTransferInformation) {
    this.internationalTransferInformation = internationalTransferInformation;
  }

  public RequestTransaction oneTimeCode(String oneTimeCode) {
    this.oneTimeCode = oneTimeCode;
    return this;
  }

  /**
   * A one-time code that can be supplied in the request or can be generated in the response depending upon the use case. An authorisation code can be supplied in this field for requests that have been pre-authorised.
   * @return oneTimeCode
   **/
  @Schema(description = "A one-time code that can be supplied in the request or can be generated in the response depending upon the use case. An authorisation code can be supplied in this field for requests that have been pre-authorised.")
  
  @Size(max=256)   public String getOneTimeCode() {
    return oneTimeCode;
  }

  public void setOneTimeCode(String oneTimeCode) {
    this.oneTimeCode = oneTimeCode;
  }

  public RequestTransaction recipientKyc(Kyc recipientKyc) {
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

  public RequestTransaction senderKyc(Kyc senderKyc) {
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

  public RequestTransaction requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

  public RequestTransaction servicingIdentity(String servicingIdentity) {
    this.servicingIdentity = servicingIdentity;
    return this;
  }

  /**
   * The field is used to identify the servicing identity for transactions, e.g. till, POS ID, assistant ID.
   * @return servicingIdentity
   **/
  @Schema(description = "The field is used to identify the servicing identity for transactions, e.g. till, POS ID, assistant ID.")
  
  @Size(max=256)   public String getServicingIdentity() {
    return servicingIdentity;
  }

  public void setServicingIdentity(String servicingIdentity) {
    this.servicingIdentity = servicingIdentity;
  }

  public RequestTransaction requestDate(OffsetDateTime requestDate) {
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

  public RequestTransaction customData(CustomDataArray customData) {
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

  public RequestTransaction metadata(MetadataArray metadata) {
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

  public RequestTransaction receivingLei(String receivingLei) {
    this.receivingLei = receivingLei;
    return this;
  }

  /**
   * Legal Entity Identifier of the organisation that is receiving the transaction.
   * @return receivingLei
   **/
  @Schema(description = "Legal Entity Identifier of the organisation that is receiving the transaction.")
  
  @Pattern(regexp="^[A-Z0-9]{4}00[A-Z0-9]{12}\\d{2}$") @Size(max=20)   public String getReceivingLei() {
    return receivingLei;
  }

  public void setReceivingLei(String receivingLei) {
    this.receivingLei = receivingLei;
  }

  public RequestTransaction requestingLei(String requestingLei) {
    this.requestingLei = requestingLei;
    return this;
  }

  /**
   * Legal Entity Identifier of the organisation that is requesting the transaction.
   * @return requestingLei
   **/
  @Schema(description = "Legal Entity Identifier of the organisation that is requesting the transaction.")
  
  @Pattern(regexp="^[A-Z0-9]{4}00[A-Z0-9]{12}\\d{2}$") @Size(max=20)   public String getRequestingLei() {
    return requestingLei;
  }

  public void setRequestingLei(String requestingLei) {
    this.requestingLei = requestingLei;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestTransaction requestTransaction = (RequestTransaction) o;
    return Objects.equals(this.requestingOrganisationTransactionReference, requestTransaction.requestingOrganisationTransactionReference) &&
        Objects.equals(this.originalTransactionReference, requestTransaction.originalTransactionReference) &&
        Objects.equals(this.creditParty, requestTransaction.creditParty) &&
        Objects.equals(this.debitParty, requestTransaction.debitParty) &&
        Objects.equals(this.type, requestTransaction.type) &&
        Objects.equals(this.subType, requestTransaction.subType) &&
        Objects.equals(this.amount, requestTransaction.amount) &&
        Objects.equals(this.currency, requestTransaction.currency) &&
        Objects.equals(this.descriptionText, requestTransaction.descriptionText) &&
        Objects.equals(this.fees, requestTransaction.fees) &&
        Objects.equals(this.geoCode, requestTransaction.geoCode) &&
        Objects.equals(this.internationalTransferInformation, requestTransaction.internationalTransferInformation) &&
        Objects.equals(this.oneTimeCode, requestTransaction.oneTimeCode) &&
        Objects.equals(this.recipientKyc, requestTransaction.recipientKyc) &&
        Objects.equals(this.senderKyc, requestTransaction.senderKyc) &&
        Objects.equals(this.requestingOrganisation, requestTransaction.requestingOrganisation) &&
        Objects.equals(this.servicingIdentity, requestTransaction.servicingIdentity) &&
        Objects.equals(this.requestDate, requestTransaction.requestDate) &&
        Objects.equals(this.customData, requestTransaction.customData) &&
        Objects.equals(this.metadata, requestTransaction.metadata) &&
        Objects.equals(this.receivingLei, requestTransaction.receivingLei) &&
        Objects.equals(this.requestingLei, requestTransaction.requestingLei);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestingOrganisationTransactionReference, originalTransactionReference, creditParty, debitParty, type, subType, amount, currency, descriptionText, fees, geoCode, internationalTransferInformation, oneTimeCode, recipientKyc, senderKyc, requestingOrganisation, servicingIdentity, requestDate, customData, metadata, receivingLei, requestingLei);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestTransaction {\n");
    
    sb.append("    requestingOrganisationTransactionReference: ").append(toIndentedString(requestingOrganisationTransactionReference)).append("\n");
    sb.append("    originalTransactionReference: ").append(toIndentedString(originalTransactionReference)).append("\n");
    sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
    sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    descriptionText: ").append(toIndentedString(descriptionText)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
    sb.append("    internationalTransferInformation: ").append(toIndentedString(internationalTransferInformation)).append("\n");
    sb.append("    oneTimeCode: ").append(toIndentedString(oneTimeCode)).append("\n");
    sb.append("    recipientKyc: ").append(toIndentedString(recipientKyc)).append("\n");
    sb.append("    senderKyc: ").append(toIndentedString(senderKyc)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
    sb.append("    servicingIdentity: ").append(toIndentedString(servicingIdentity)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    receivingLei: ").append(toIndentedString(receivingLei)).append("\n");
    sb.append("    requestingLei: ").append(toIndentedString(requestingLei)).append("\n");
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
