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
 * RequestQuotation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestQuotation   {
  @JsonProperty("creditParty")
  private CreditPartyArray creditParty = null;

  @JsonProperty("debitParty")
  private DebitPartyArray debitParty = null;

  @JsonProperty("type")
  private Type type = null;

  @JsonProperty("subType")
  private String subType = null;

  @JsonProperty("requestAmount")
  private String requestAmount = null;

  @JsonProperty("requestCurrency")
  private Currency requestCurrency = null;

  @JsonProperty("chosenDeliveryMethod")
  private DeliveryMethod chosenDeliveryMethod = null;

  @JsonProperty("originCountry")
  private Nationality originCountry = null;

  @JsonProperty("receivingCountry")
  private Nationality receivingCountry = null;

  @JsonProperty("recipientKyc")
  private Kyc recipientKyc = null;

  @JsonProperty("senderKyc")
  private Kyc senderKyc = null;

  @JsonProperty("requestingOrganisation")
  private RequestingOrganisation requestingOrganisation = null;

  @JsonProperty("sendingServiceProviderCountry")
  private Nationality sendingServiceProviderCountry = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  @JsonProperty("metadata")
  private MetadataArray metadata = null;

  public RequestQuotation creditParty(CreditPartyArray creditParty) {
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

  public RequestQuotation debitParty(DebitPartyArray debitParty) {
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

  public RequestQuotation type(Type type) {
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

  public RequestQuotation subType(String subType) {
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

  public RequestQuotation requestAmount(String requestAmount) {
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

  public RequestQuotation requestCurrency(Currency requestCurrency) {
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

  public RequestQuotation chosenDeliveryMethod(DeliveryMethod chosenDeliveryMethod) {
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

  public RequestQuotation originCountry(Nationality originCountry) {
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

  public RequestQuotation receivingCountry(Nationality receivingCountry) {
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

  public RequestQuotation recipientKyc(Kyc recipientKyc) {
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

  public RequestQuotation senderKyc(Kyc senderKyc) {
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

  public RequestQuotation requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

  public RequestQuotation sendingServiceProviderCountry(Nationality sendingServiceProviderCountry) {
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

  public RequestQuotation requestDate(OffsetDateTime requestDate) {
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

  public RequestQuotation customData(CustomDataArray customData) {
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

  public RequestQuotation metadata(MetadataArray metadata) {
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
    RequestQuotation requestQuotation = (RequestQuotation) o;
    return Objects.equals(this.creditParty, requestQuotation.creditParty) &&
        Objects.equals(this.debitParty, requestQuotation.debitParty) &&
        Objects.equals(this.type, requestQuotation.type) &&
        Objects.equals(this.subType, requestQuotation.subType) &&
        Objects.equals(this.requestAmount, requestQuotation.requestAmount) &&
        Objects.equals(this.requestCurrency, requestQuotation.requestCurrency) &&
        Objects.equals(this.chosenDeliveryMethod, requestQuotation.chosenDeliveryMethod) &&
        Objects.equals(this.originCountry, requestQuotation.originCountry) &&
        Objects.equals(this.receivingCountry, requestQuotation.receivingCountry) &&
        Objects.equals(this.recipientKyc, requestQuotation.recipientKyc) &&
        Objects.equals(this.senderKyc, requestQuotation.senderKyc) &&
        Objects.equals(this.requestingOrganisation, requestQuotation.requestingOrganisation) &&
        Objects.equals(this.sendingServiceProviderCountry, requestQuotation.sendingServiceProviderCountry) &&
        Objects.equals(this.requestDate, requestQuotation.requestDate) &&
        Objects.equals(this.customData, requestQuotation.customData) &&
        Objects.equals(this.metadata, requestQuotation.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditParty, debitParty, type, subType, requestAmount, requestCurrency, chosenDeliveryMethod, originCountry, receivingCountry, recipientKyc, senderKyc, requestingOrganisation, sendingServiceProviderCountry, requestDate, customData, metadata);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestQuotation {\n");
    
    sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
    sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
    sb.append("    requestAmount: ").append(toIndentedString(requestAmount)).append("\n");
    sb.append("    requestCurrency: ").append(toIndentedString(requestCurrency)).append("\n");
    sb.append("    chosenDeliveryMethod: ").append(toIndentedString(chosenDeliveryMethod)).append("\n");
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    receivingCountry: ").append(toIndentedString(receivingCountry)).append("\n");
    sb.append("    recipientKyc: ").append(toIndentedString(recipientKyc)).append("\n");
    sb.append("    senderKyc: ").append(toIndentedString(senderKyc)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
    sb.append("    sendingServiceProviderCountry: ").append(toIndentedString(sendingServiceProviderCountry)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
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
