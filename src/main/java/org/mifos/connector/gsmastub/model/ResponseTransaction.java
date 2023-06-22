package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseTransaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseTransaction {

    @JsonProperty("transactionReference")
    private String transactionReference = null;

    @JsonProperty("originalTransactionReference")
    private String originalTransactionReference = null;

    @JsonProperty("requestingOrganisationTransactionReference")
    private String requestingOrganisationTransactionReference = null;

    @JsonProperty("creditParty")
    private CreditPartyArray creditParty = null;

    @JsonProperty("debitParty")
    private DebitPartyArray debitParty = null;

    @JsonProperty("type")
    private Type type = null;

    @JsonProperty("subType")
    private String subType = null;

    @JsonProperty("transactionStatus")
    private String transactionStatus = null;

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
    private InternationalTransferInformationResponse internationalTransferInformation = null;

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

    @JsonProperty("metadata")
    private MetadataArray metadata = null;

    @JsonProperty("dateCreated")
    private OffsetDateTime dateCreated = null;

    @JsonProperty("dateModified")
    private OffsetDateTime dateModified = null;

    @JsonProperty("receivingLei")
    private String receivingLei = null;

    @JsonProperty("requestingLei")
    private String requestingLei = null;

    public ResponseTransaction transactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
        return this;
    }

    /**
     * Unique reference for the transaction. This is returned in the response by API provider.
     *
     * @return transactionReference
     **/
    @Schema(required = true, description = "Unique reference for the transaction. This is returned in the response by API provider.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public ResponseTransaction originalTransactionReference(String originalTransactionReference) {
        this.originalTransactionReference = originalTransactionReference;
        return this;
    }

    /**
     * For reversals and refunds, this field indicates the transaction which is the subject of the reversal.
     *
     * @return originalTransactionReference
     **/
    @Schema(description = "For reversals and refunds, this field indicates the transaction which is the subject of the reversal.")

    @Size(max = 256)
    public String getOriginalTransactionReference() {
        return originalTransactionReference;
    }

    public void setOriginalTransactionReference(String originalTransactionReference) {
        this.originalTransactionReference = originalTransactionReference;
    }

    public ResponseTransaction requestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
        this.requestingOrganisationTransactionReference = requestingOrganisationTransactionReference;
        return this;
    }

    /**
     * A reference provided by the requesting organisation that is to be associated with the transaction.
     *
     * @return requestingOrganisationTransactionReference
     **/
    @Schema(description = "A reference provided by the requesting organisation that is to be associated with the transaction.")

    @Size(max = 256)
    public String getRequestingOrganisationTransactionReference() {
        return requestingOrganisationTransactionReference;
    }

    public void setRequestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
        this.requestingOrganisationTransactionReference = requestingOrganisationTransactionReference;
    }

    public ResponseTransaction creditParty(CreditPartyArray creditParty) {
        this.creditParty = creditParty;
        return this;
    }

    /**
     * Get creditParty
     *
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

    public ResponseTransaction debitParty(DebitPartyArray debitParty) {
        this.debitParty = debitParty;
        return this;
    }

    /**
     * Get debitParty
     *
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

    public ResponseTransaction type(Type type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
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

    public ResponseTransaction subType(String subType) {
        this.subType = subType;
        return this;
    }

    /**
     * A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary
     * according to Provider.
     *
     * @return subType
     **/
    @Schema(description = "A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary according to Provider.")

    @Size(max = 256)
    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public ResponseTransaction transactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
        return this;
    }

    /**
     * Indicates the status of the transaction as stored by the API provider.
     *
     * @return transactionStatus
     **/
    @Schema(required = true, description = "Indicates the status of the transaction as stored by the API provider.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public ResponseTransaction amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @Schema(example = "15.21", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ResponseTransaction currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
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

    public ResponseTransaction descriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
        return this;
    }

    /**
     * Free format text description of the transaction provided by the client. This can be provided as a reference for
     * the receiver on a notification SMS and on an account statement.
     *
     * @return descriptionText
     **/
    @Schema(description = "Free format text description of the transaction provided by the client. This can be provided as a reference for the receiver on a notification SMS and on an account statement.")

    @Size(max = 160)
    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public ResponseTransaction fees(FeesArray fees) {
        this.fees = fees;
        return this;
    }

    /**
     * Get fees
     *
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

    public ResponseTransaction geoCode(String geoCode) {
        this.geoCode = geoCode;
        return this;
    }

    /**
     * Indicates the geographic location from where the transaction was initiated.
     *
     * @return geoCode
     **/
    @Schema(example = "37.423825,-122.082900", description = "Indicates the geographic location from where the transaction was initiated.")

    @Pattern(regexp = "^(-?(90|(\\d|[1-8]\\d)(\\.\\d{1,6}){0,1}))\\,{1}(-?(180|(\\d|\\d\\d|1[0-7]\\d)(\\.\\d{1,6}){0,1}))$")
    @Size(max = 256)
    public String getGeoCode() {
        return geoCode;
    }

    public void setGeoCode(String geoCode) {
        this.geoCode = geoCode;
    }

    public ResponseTransaction internationalTransferInformation(InternationalTransferInformationResponse internationalTransferInformation) {
        this.internationalTransferInformation = internationalTransferInformation;
        return this;
    }

    /**
     * Get internationalTransferInformation
     *
     * @return internationalTransferInformation
     **/
    @Schema(description = "")

    @Valid
    public InternationalTransferInformationResponse getInternationalTransferInformation() {
        return internationalTransferInformation;
    }

    public void setInternationalTransferInformation(InternationalTransferInformationResponse internationalTransferInformation) {
        this.internationalTransferInformation = internationalTransferInformation;
    }

    public ResponseTransaction oneTimeCode(String oneTimeCode) {
        this.oneTimeCode = oneTimeCode;
        return this;
    }

    /**
     * A one-time code that can be supplied in the request or can be generated in the response depending upon the use
     * case. An authorisation code can be supplied in this field for requests that have been pre-authorised.
     *
     * @return oneTimeCode
     **/
    @Schema(description = "A one-time code that can be supplied in the request or can be generated in the response depending upon the use case. An authorisation code can be supplied in this field for requests that have been pre-authorised.")

    @Size(max = 256)
    public String getOneTimeCode() {
        return oneTimeCode;
    }

    public void setOneTimeCode(String oneTimeCode) {
        this.oneTimeCode = oneTimeCode;
    }

    public ResponseTransaction recipientKyc(Kyc recipientKyc) {
        this.recipientKyc = recipientKyc;
        return this;
    }

    /**
     * Get recipientKyc
     *
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

    public ResponseTransaction senderKyc(Kyc senderKyc) {
        this.senderKyc = senderKyc;
        return this;
    }

    /**
     * Get senderKyc
     *
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

    public ResponseTransaction requestingOrganisation(RequestingOrganisation requestingOrganisation) {
        this.requestingOrganisation = requestingOrganisation;
        return this;
    }

    /**
     * Get requestingOrganisation
     *
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

    public ResponseTransaction servicingIdentity(String servicingIdentity) {
        this.servicingIdentity = servicingIdentity;
        return this;
    }

    /**
     * The field is used to identify the servicing identity for transactions, e.g. till, POS ID, assistant ID.
     *
     * @return servicingIdentity
     **/
    @Schema(description = "The field is used to identify the servicing identity for transactions, e.g. till, POS ID, assistant ID.")

    @Size(max = 256)
    public String getServicingIdentity() {
        return servicingIdentity;
    }

    public void setServicingIdentity(String servicingIdentity) {
        this.servicingIdentity = servicingIdentity;
    }

    public ResponseTransaction transactionReceipt(String transactionReceipt) {
        this.transactionReceipt = transactionReceipt;
        return this;
    }

    /**
     * Transaction receipt number as notified to the parties. This may differ from the Transaction Reference.
     *
     * @return transactionReceipt
     **/
    @Schema(description = "Transaction receipt number as notified to the parties. This may differ from the Transaction Reference.")

    @Size(max = 256)
    public String getTransactionReceipt() {
        return transactionReceipt;
    }

    public void setTransactionReceipt(String transactionReceipt) {
        this.transactionReceipt = transactionReceipt;
    }

    public ResponseTransaction creationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    /**
     * Date and time when the object was created by the API Provider.
     *
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

    public ResponseTransaction modificationDate(OffsetDateTime modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    /**
     * Date and time when the object was modified by the API Provider.
     *
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

    public ResponseTransaction requestDate(OffsetDateTime requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    /**
     * The date and time of the request as supplied by the client.
     *
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

    public ResponseTransaction customData(CustomDataArray customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Get customData
     *
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

    public ResponseTransaction metadata(MetadataArray metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     *
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

    public ResponseTransaction dateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * Date and time when the object was created by the API Provider.
     *
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

    public ResponseTransaction dateModified(OffsetDateTime dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    /**
     * Date and time when the object was modified by the API Provider.
     *
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

    public ResponseTransaction receivingLei(String receivingLei) {
        this.receivingLei = receivingLei;
        return this;
    }

    /**
     * Legal Entity Identifier of the organisation that is receiving the transaction.
     *
     * @return receivingLei
     **/
    @Schema(description = "Legal Entity Identifier of the organisation that is receiving the transaction.")

    @Pattern(regexp = "^[A-Z0-9]{4}00[A-Z0-9]{12}\\d{2}$")
    @Size(max = 20)
    public String getReceivingLei() {
        return receivingLei;
    }

    public void setReceivingLei(String receivingLei) {
        this.receivingLei = receivingLei;
    }

    public ResponseTransaction requestingLei(String requestingLei) {
        this.requestingLei = requestingLei;
        return this;
    }

    /**
     * Legal Entity Identifier of the organisation that is requesting the transaction.
     *
     * @return requestingLei
     **/
    @Schema(description = "Legal Entity Identifier of the organisation that is requesting the transaction.")

    @Pattern(regexp = "^[A-Z0-9]{4}00[A-Z0-9]{12}\\d{2}$")
    @Size(max = 20)
    public String getRequestingLei() {
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
        ResponseTransaction responseTransaction = (ResponseTransaction) o;
        return Objects.equals(this.transactionReference, responseTransaction.transactionReference)
                && Objects.equals(this.originalTransactionReference, responseTransaction.originalTransactionReference)
                && Objects.equals(this.requestingOrganisationTransactionReference,
                        responseTransaction.requestingOrganisationTransactionReference)
                && Objects.equals(this.creditParty, responseTransaction.creditParty)
                && Objects.equals(this.debitParty, responseTransaction.debitParty) && Objects.equals(this.type, responseTransaction.type)
                && Objects.equals(this.subType, responseTransaction.subType)
                && Objects.equals(this.transactionStatus, responseTransaction.transactionStatus)
                && Objects.equals(this.amount, responseTransaction.amount) && Objects.equals(this.currency, responseTransaction.currency)
                && Objects.equals(this.descriptionText, responseTransaction.descriptionText)
                && Objects.equals(this.fees, responseTransaction.fees) && Objects.equals(this.geoCode, responseTransaction.geoCode)
                && Objects.equals(this.internationalTransferInformation, responseTransaction.internationalTransferInformation)
                && Objects.equals(this.oneTimeCode, responseTransaction.oneTimeCode)
                && Objects.equals(this.recipientKyc, responseTransaction.recipientKyc)
                && Objects.equals(this.senderKyc, responseTransaction.senderKyc)
                && Objects.equals(this.requestingOrganisation, responseTransaction.requestingOrganisation)
                && Objects.equals(this.servicingIdentity, responseTransaction.servicingIdentity)
                && Objects.equals(this.transactionReceipt, responseTransaction.transactionReceipt)
                && Objects.equals(this.creationDate, responseTransaction.creationDate)
                && Objects.equals(this.modificationDate, responseTransaction.modificationDate)
                && Objects.equals(this.requestDate, responseTransaction.requestDate)
                && Objects.equals(this.customData, responseTransaction.customData)
                && Objects.equals(this.metadata, responseTransaction.metadata)
                && Objects.equals(this.dateCreated, responseTransaction.dateCreated)
                && Objects.equals(this.dateModified, responseTransaction.dateModified)
                && Objects.equals(this.receivingLei, responseTransaction.receivingLei)
                && Objects.equals(this.requestingLei, responseTransaction.requestingLei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionReference, originalTransactionReference, requestingOrganisationTransactionReference, creditParty,
                debitParty, type, subType, transactionStatus, amount, currency, descriptionText, fees, geoCode,
                internationalTransferInformation, oneTimeCode, recipientKyc, senderKyc, requestingOrganisation, servicingIdentity,
                transactionReceipt, creationDate, modificationDate, requestDate, customData, metadata, dateCreated, dateModified,
                receivingLei, requestingLei);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseTransaction {\n");

        sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
        sb.append("    originalTransactionReference: ").append(toIndentedString(originalTransactionReference)).append("\n");
        sb.append("    requestingOrganisationTransactionReference: ").append(toIndentedString(requestingOrganisationTransactionReference))
                .append("\n");
        sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
        sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    subType: ").append(toIndentedString(subType)).append("\n");
        sb.append("    transactionStatus: ").append(toIndentedString(transactionStatus)).append("\n");
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
        sb.append("    transactionReceipt: ").append(toIndentedString(transactionReceipt)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    dateCreated: ").append(toIndentedString(dateCreated)).append("\n");
        sb.append("    dateModified: ").append(toIndentedString(dateModified)).append("\n");
        sb.append("    receivingLei: ").append(toIndentedString(receivingLei)).append("\n");
        sb.append("    requestingLei: ").append(toIndentedString(requestingLei)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
