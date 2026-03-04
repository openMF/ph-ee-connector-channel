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
 * RequestReversal
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestReversal   {
  @JsonProperty("requestingOrganisationTransactionReference")
  private String requestingOrganisationTransactionReference = null;

  @JsonProperty("creditParty")
  private CreditPartyArray creditParty = null;

  @JsonProperty("debitParty")
  private DebitPartyArray debitParty = null;

  @JsonProperty("type")
  private TypeReversal type = null;

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

  public RequestReversal requestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
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

  public RequestReversal creditParty(CreditPartyArray creditParty) {
    this.creditParty = creditParty;
    return this;
  }

  /**
   * Get creditParty
   * @return creditParty
   **/
  @Schema(description = "")
  
    @Valid
    public CreditPartyArray getCreditParty() {
    return creditParty;
  }

  public void setCreditParty(CreditPartyArray creditParty) {
    this.creditParty = creditParty;
  }

  public RequestReversal debitParty(DebitPartyArray debitParty) {
    this.debitParty = debitParty;
    return this;
  }

  /**
   * Get debitParty
   * @return debitParty
   **/
  @Schema(description = "")
  
    @Valid
    public DebitPartyArray getDebitParty() {
    return debitParty;
  }

  public void setDebitParty(DebitPartyArray debitParty) {
    this.debitParty = debitParty;
  }

  public RequestReversal type(TypeReversal type) {
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
    public TypeReversal getType() {
    return type;
  }

  public void setType(TypeReversal type) {
    this.type = type;
  }

  public RequestReversal subType(String subType) {
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

  public RequestReversal amount(String amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(example = "15.21", description = "")
  
  @Pattern(regexp="^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$") @Size(min=1,max=23)   public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public RequestReversal currency(Currency currency) {
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

  public RequestReversal descriptionText(String descriptionText) {
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

  public RequestReversal fees(FeesArray fees) {
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

  public RequestReversal geoCode(String geoCode) {
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

  public RequestReversal requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

  public RequestReversal servicingIdentity(String servicingIdentity) {
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

  public RequestReversal requestDate(OffsetDateTime requestDate) {
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

  public RequestReversal customData(CustomDataArray customData) {
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

  public RequestReversal metadata(MetadataArray metadata) {
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

  public RequestReversal receivingLei(String receivingLei) {
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

  public RequestReversal requestingLei(String requestingLei) {
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
    RequestReversal requestReversal = (RequestReversal) o;
    return Objects.equals(this.requestingOrganisationTransactionReference, requestReversal.requestingOrganisationTransactionReference) &&
        Objects.equals(this.creditParty, requestReversal.creditParty) &&
        Objects.equals(this.debitParty, requestReversal.debitParty) &&
        Objects.equals(this.type, requestReversal.type) &&
        Objects.equals(this.subType, requestReversal.subType) &&
        Objects.equals(this.amount, requestReversal.amount) &&
        Objects.equals(this.currency, requestReversal.currency) &&
        Objects.equals(this.descriptionText, requestReversal.descriptionText) &&
        Objects.equals(this.fees, requestReversal.fees) &&
        Objects.equals(this.geoCode, requestReversal.geoCode) &&
        Objects.equals(this.requestingOrganisation, requestReversal.requestingOrganisation) &&
        Objects.equals(this.servicingIdentity, requestReversal.servicingIdentity) &&
        Objects.equals(this.requestDate, requestReversal.requestDate) &&
        Objects.equals(this.customData, requestReversal.customData) &&
        Objects.equals(this.metadata, requestReversal.metadata) &&
        Objects.equals(this.receivingLei, requestReversal.receivingLei) &&
        Objects.equals(this.requestingLei, requestReversal.requestingLei);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestingOrganisationTransactionReference, creditParty, debitParty, type, subType, amount, currency, descriptionText, fees, geoCode, requestingOrganisation, servicingIdentity, requestDate, customData, metadata, receivingLei, requestingLei);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestReversal {\n");
    
    sb.append("    requestingOrganisationTransactionReference: ").append(toIndentedString(requestingOrganisationTransactionReference)).append("\n");
    sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
    sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    descriptionText: ").append(toIndentedString(descriptionText)).append("\n");
    sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
    sb.append("    geoCode: ").append(toIndentedString(geoCode)).append("\n");
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
