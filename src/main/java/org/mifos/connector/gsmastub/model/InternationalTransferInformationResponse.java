package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * InternationalTransferInformationResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class InternationalTransferInformationResponse   {
  @JsonProperty("originCountry")
  private Nationality originCountry = null;

  @JsonProperty("quotationReference")
  private String quotationReference = null;

  @JsonProperty("quoteId")
  private String quoteId = null;

  @JsonProperty("deliveryMethod")
  private DeliveryMethod deliveryMethod = null;

  @JsonProperty("receivingCountry")
  private Nationality receivingCountry = null;

  @JsonProperty("relationshipSender")
  private String relationshipSender = null;

  @JsonProperty("remittancePurpose")
  private String remittancePurpose = null;

  @JsonProperty("recipientBlockingReason")
  private String recipientBlockingReason = null;

  @JsonProperty("senderBlockingReason")
  private String senderBlockingReason = null;

  @JsonProperty("sendingServiceProviderCountry")
  private Nationality sendingServiceProviderCountry = null;

  public InternationalTransferInformationResponse originCountry(Nationality originCountry) {
    this.originCountry = originCountry;
    return this;
  }

  /**
   * Get originCountry
   * @return originCountry
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Nationality getOriginCountry() {
    return originCountry;
  }

  public void setOriginCountry(Nationality originCountry) {
    this.originCountry = originCountry;
  }

  public InternationalTransferInformationResponse quotationReference(String quotationReference) {
    this.quotationReference = quotationReference;
    return this;
  }

  /**
   * Reference for the quotation that was provided to the sender.
   * @return quotationReference
   **/
  @Schema(description = "Reference for the quotation that was provided to the sender.")
  
  @Size(min=1,max=256)   public String getQuotationReference() {
    return quotationReference;
  }

  public void setQuotationReference(String quotationReference) {
    this.quotationReference = quotationReference;
  }

  public InternationalTransferInformationResponse quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }

  /**
   * The specific quote associated with the quotation.
   * @return quoteId
   **/
  @Schema(description = "The specific quote associated with the quotation.")
  
  @Size(min=1,max=256)   public String getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public InternationalTransferInformationResponse deliveryMethod(DeliveryMethod deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
    return this;
  }

  /**
   * Get deliveryMethod
   * @return deliveryMethod
   **/
  @Schema(description = "")
  
    @Valid
    public DeliveryMethod getDeliveryMethod() {
    return deliveryMethod;
  }

  public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
    this.deliveryMethod = deliveryMethod;
  }

  public InternationalTransferInformationResponse receivingCountry(Nationality receivingCountry) {
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

  public InternationalTransferInformationResponse relationshipSender(String relationshipSender) {
    this.relationshipSender = relationshipSender;
    return this;
  }

  /**
   * Indicates the relationship (if any) between the sender and the receiver.
   * @return relationshipSender
   **/
  @Schema(description = "Indicates the relationship (if any) between the sender and the receiver.")
  
  @Size(max=256)   public String getRelationshipSender() {
    return relationshipSender;
  }

  public void setRelationshipSender(String relationshipSender) {
    this.relationshipSender = relationshipSender;
  }

  public InternationalTransferInformationResponse remittancePurpose(String remittancePurpose) {
    this.remittancePurpose = remittancePurpose;
    return this;
  }

  /**
   * Field providing a description of the reason for the international remittance.
   * @return remittancePurpose
   **/
  @Schema(description = "Field providing a description of the reason for the international remittance.")
  
  @Size(max=256)   public String getRemittancePurpose() {
    return remittancePurpose;
  }

  public void setRemittancePurpose(String remittancePurpose) {
    this.remittancePurpose = remittancePurpose;
  }

  public InternationalTransferInformationResponse recipientBlockingReason(String recipientBlockingReason) {
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

  public InternationalTransferInformationResponse senderBlockingReason(String senderBlockingReason) {
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

  public InternationalTransferInformationResponse sendingServiceProviderCountry(Nationality sendingServiceProviderCountry) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InternationalTransferInformationResponse internationalTransferInformationResponse = (InternationalTransferInformationResponse) o;
    return Objects.equals(this.originCountry, internationalTransferInformationResponse.originCountry) &&
        Objects.equals(this.quotationReference, internationalTransferInformationResponse.quotationReference) &&
        Objects.equals(this.quoteId, internationalTransferInformationResponse.quoteId) &&
        Objects.equals(this.deliveryMethod, internationalTransferInformationResponse.deliveryMethod) &&
        Objects.equals(this.receivingCountry, internationalTransferInformationResponse.receivingCountry) &&
        Objects.equals(this.relationshipSender, internationalTransferInformationResponse.relationshipSender) &&
        Objects.equals(this.remittancePurpose, internationalTransferInformationResponse.remittancePurpose) &&
        Objects.equals(this.recipientBlockingReason, internationalTransferInformationResponse.recipientBlockingReason) &&
        Objects.equals(this.senderBlockingReason, internationalTransferInformationResponse.senderBlockingReason) &&
        Objects.equals(this.sendingServiceProviderCountry, internationalTransferInformationResponse.sendingServiceProviderCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originCountry, quotationReference, quoteId, deliveryMethod, receivingCountry, relationshipSender, remittancePurpose, recipientBlockingReason, senderBlockingReason, sendingServiceProviderCountry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InternationalTransferInformationResponse {\n");
    
    sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
    sb.append("    quotationReference: ").append(toIndentedString(quotationReference)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
    sb.append("    deliveryMethod: ").append(toIndentedString(deliveryMethod)).append("\n");
    sb.append("    receivingCountry: ").append(toIndentedString(receivingCountry)).append("\n");
    sb.append("    relationshipSender: ").append(toIndentedString(relationshipSender)).append("\n");
    sb.append("    remittancePurpose: ").append(toIndentedString(remittancePurpose)).append("\n");
    sb.append("    recipientBlockingReason: ").append(toIndentedString(recipientBlockingReason)).append("\n");
    sb.append("    senderBlockingReason: ").append(toIndentedString(senderBlockingReason)).append("\n");
    sb.append("    sendingServiceProviderCountry: ").append(toIndentedString(sendingServiceProviderCountry)).append("\n");
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
