package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseAuthorisationCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseAuthorisationCode {

    @JsonProperty("authorisationCode")
    private String authorisationCode = null;

    @JsonProperty("codeState")
    private CodeState codeState = null;

    @JsonProperty("amount")
    private String amount = null;

    @JsonProperty("currency")
    private Currency currency = null;

    @JsonProperty("amountType")
    private AmountType amountType = null;

    @JsonProperty("codeLifetime")
    private BigDecimal codeLifetime = null;

    @JsonProperty("holdFundsIndicator")
    private Boolean holdFundsIndicator = null;

    @JsonProperty("redemptionAccountIdentifiers")
    private RedemptionAccountIdentifiers redemptionAccountIdentifiers = null;

    @JsonProperty("redemptionChannels")
    private RedemptionChannels redemptionChannels = null;

    @JsonProperty("redemptionTransactionTypes")
    private RedemptionTransactionTypes redemptionTransactionTypes = null;

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

    @JsonProperty("metadata")
    private MetadataArray metadata = null;

    public ResponseAuthorisationCode authorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
        return this;
    }

    /**
     * The code that will be presented to the other party for redemption.
     *
     * @return authorisationCode
     **/
    @Schema(required = true, description = "The code that will be presented to the other party for redemption.")
    @NotNull

    @Size(max = 256)
    public String getAuthorisationCode() {
        return authorisationCode;
    }

    public void setAuthorisationCode(String authorisationCode) {
        this.authorisationCode = authorisationCode;
    }

    public ResponseAuthorisationCode codeState(CodeState codeState) {
        this.codeState = codeState;
        return this;
    }

    /**
     * Get codeState
     *
     * @return codeState
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public CodeState getCodeState() {
        return codeState;
    }

    public void setCodeState(CodeState codeState) {
        this.codeState = codeState;
    }

    public ResponseAuthorisationCode amount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    @Schema(example = "15.21", description = "")

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public ResponseAuthorisationCode currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
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

    public ResponseAuthorisationCode amountType(AmountType amountType) {
        this.amountType = amountType;
        return this;
    }

    /**
     * Get amountType
     *
     * @return amountType
     **/
    @Schema(description = "")

    @Valid
    public AmountType getAmountType() {
        return amountType;
    }

    public void setAmountType(AmountType amountType) {
        this.amountType = amountType;
    }

    public ResponseAuthorisationCode codeLifetime(BigDecimal codeLifetime) {
        this.codeLifetime = codeLifetime;
        return this;
    }

    /**
     * Indicates the expiry time in seconds of the code. minimum: 1
     *
     * @return codeLifetime
     **/
    @Schema(example = "600", description = "Indicates the expiry time in seconds of the code.")

    @Valid
    @DecimalMin("1")
    public BigDecimal getCodeLifetime() {
        return codeLifetime;
    }

    public void setCodeLifetime(BigDecimal codeLifetime) {
        this.codeLifetime = codeLifetime;
    }

    public ResponseAuthorisationCode holdFundsIndicator(Boolean holdFundsIndicator) {
        this.holdFundsIndicator = holdFundsIndicator;
        return this;
    }

    /**
     * Indicates whether funds should be reserved against the payers account where the payer is the requestor.
     *
     * @return holdFundsIndicator
     **/
    @Schema(description = "Indicates whether funds should be reserved against the payers account where the payer is the requestor.")

    public Boolean isHoldFundsIndicator() {
        return holdFundsIndicator;
    }

    public void setHoldFundsIndicator(Boolean holdFundsIndicator) {
        this.holdFundsIndicator = holdFundsIndicator;
    }

    public ResponseAuthorisationCode redemptionAccountIdentifiers(RedemptionAccountIdentifiers redemptionAccountIdentifiers) {
        this.redemptionAccountIdentifiers = redemptionAccountIdentifiers;
        return this;
    }

    /**
     * Get redemptionAccountIdentifiers
     *
     * @return redemptionAccountIdentifiers
     **/
    @Schema(description = "")

    @Valid
    public RedemptionAccountIdentifiers getRedemptionAccountIdentifiers() {
        return redemptionAccountIdentifiers;
    }

    public void setRedemptionAccountIdentifiers(RedemptionAccountIdentifiers redemptionAccountIdentifiers) {
        this.redemptionAccountIdentifiers = redemptionAccountIdentifiers;
    }

    public ResponseAuthorisationCode redemptionChannels(RedemptionChannels redemptionChannels) {
        this.redemptionChannels = redemptionChannels;
        return this;
    }

    /**
     * Get redemptionChannels
     *
     * @return redemptionChannels
     **/
    @Schema(description = "")

    @Valid
    public RedemptionChannels getRedemptionChannels() {
        return redemptionChannels;
    }

    public void setRedemptionChannels(RedemptionChannels redemptionChannels) {
        this.redemptionChannels = redemptionChannels;
    }

    public ResponseAuthorisationCode redemptionTransactionTypes(RedemptionTransactionTypes redemptionTransactionTypes) {
        this.redemptionTransactionTypes = redemptionTransactionTypes;
        return this;
    }

    /**
     * Get redemptionTransactionTypes
     *
     * @return redemptionTransactionTypes
     **/
    @Schema(description = "")

    @Valid
    public RedemptionTransactionTypes getRedemptionTransactionTypes() {
        return redemptionTransactionTypes;
    }

    public void setRedemptionTransactionTypes(RedemptionTransactionTypes redemptionTransactionTypes) {
        this.redemptionTransactionTypes = redemptionTransactionTypes;
    }

    public ResponseAuthorisationCode requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

    public ResponseAuthorisationCode creationDate(OffsetDateTime creationDate) {
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

    public ResponseAuthorisationCode modificationDate(OffsetDateTime modificationDate) {
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

    public ResponseAuthorisationCode requestDate(OffsetDateTime requestDate) {
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

    public ResponseAuthorisationCode customData(CustomDataArray customData) {
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

    public ResponseAuthorisationCode metadata(MetadataArray metadata) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseAuthorisationCode responseAuthorisationCode = (ResponseAuthorisationCode) o;
        return Objects.equals(this.authorisationCode, responseAuthorisationCode.authorisationCode)
                && Objects.equals(this.codeState, responseAuthorisationCode.codeState)
                && Objects.equals(this.amount, responseAuthorisationCode.amount)
                && Objects.equals(this.currency, responseAuthorisationCode.currency)
                && Objects.equals(this.amountType, responseAuthorisationCode.amountType)
                && Objects.equals(this.codeLifetime, responseAuthorisationCode.codeLifetime)
                && Objects.equals(this.holdFundsIndicator, responseAuthorisationCode.holdFundsIndicator)
                && Objects.equals(this.redemptionAccountIdentifiers, responseAuthorisationCode.redemptionAccountIdentifiers)
                && Objects.equals(this.redemptionChannels, responseAuthorisationCode.redemptionChannels)
                && Objects.equals(this.redemptionTransactionTypes, responseAuthorisationCode.redemptionTransactionTypes)
                && Objects.equals(this.requestingOrganisation, responseAuthorisationCode.requestingOrganisation)
                && Objects.equals(this.creationDate, responseAuthorisationCode.creationDate)
                && Objects.equals(this.modificationDate, responseAuthorisationCode.modificationDate)
                && Objects.equals(this.requestDate, responseAuthorisationCode.requestDate)
                && Objects.equals(this.customData, responseAuthorisationCode.customData)
                && Objects.equals(this.metadata, responseAuthorisationCode.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorisationCode, codeState, amount, currency, amountType, codeLifetime, holdFundsIndicator,
                redemptionAccountIdentifiers, redemptionChannels, redemptionTransactionTypes, requestingOrganisation, creationDate,
                modificationDate, requestDate, customData, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseAuthorisationCode {\n");

        sb.append("    authorisationCode: ").append(toIndentedString(authorisationCode)).append("\n");
        sb.append("    codeState: ").append(toIndentedString(codeState)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    amountType: ").append(toIndentedString(amountType)).append("\n");
        sb.append("    codeLifetime: ").append(toIndentedString(codeLifetime)).append("\n");
        sb.append("    holdFundsIndicator: ").append(toIndentedString(holdFundsIndicator)).append("\n");
        sb.append("    redemptionAccountIdentifiers: ").append(toIndentedString(redemptionAccountIdentifiers)).append("\n");
        sb.append("    redemptionChannels: ").append(toIndentedString(redemptionChannels)).append("\n");
        sb.append("    redemptionTransactionTypes: ").append(toIndentedString(redemptionTransactionTypes)).append("\n");
        sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
