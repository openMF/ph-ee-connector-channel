package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * RequestAuthorisationCode
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RequestAuthorisationCode {

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

    @JsonProperty("requestDate")
    private OffsetDateTime requestDate = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("metadata")
    private MetadataArray metadata = null;

    public RequestAuthorisationCode amount(String amount) {
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

    public RequestAuthorisationCode currency(Currency currency) {
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

    public RequestAuthorisationCode amountType(AmountType amountType) {
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

    public RequestAuthorisationCode codeLifetime(BigDecimal codeLifetime) {
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

    public RequestAuthorisationCode holdFundsIndicator(Boolean holdFundsIndicator) {
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

    public RequestAuthorisationCode redemptionAccountIdentifiers(RedemptionAccountIdentifiers redemptionAccountIdentifiers) {
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

    public RequestAuthorisationCode redemptionChannels(RedemptionChannels redemptionChannels) {
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

    public RequestAuthorisationCode redemptionTransactionTypes(RedemptionTransactionTypes redemptionTransactionTypes) {
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

    public RequestAuthorisationCode requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

    public RequestAuthorisationCode requestDate(OffsetDateTime requestDate) {
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

    public RequestAuthorisationCode customData(CustomDataArray customData) {
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

    public RequestAuthorisationCode metadata(MetadataArray metadata) {
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
        RequestAuthorisationCode requestAuthorisationCode = (RequestAuthorisationCode) o;
        return Objects.equals(this.amount, requestAuthorisationCode.amount)
                && Objects.equals(this.currency, requestAuthorisationCode.currency)
                && Objects.equals(this.amountType, requestAuthorisationCode.amountType)
                && Objects.equals(this.codeLifetime, requestAuthorisationCode.codeLifetime)
                && Objects.equals(this.holdFundsIndicator, requestAuthorisationCode.holdFundsIndicator)
                && Objects.equals(this.redemptionAccountIdentifiers, requestAuthorisationCode.redemptionAccountIdentifiers)
                && Objects.equals(this.redemptionChannels, requestAuthorisationCode.redemptionChannels)
                && Objects.equals(this.redemptionTransactionTypes, requestAuthorisationCode.redemptionTransactionTypes)
                && Objects.equals(this.requestingOrganisation, requestAuthorisationCode.requestingOrganisation)
                && Objects.equals(this.requestDate, requestAuthorisationCode.requestDate)
                && Objects.equals(this.customData, requestAuthorisationCode.customData)
                && Objects.equals(this.metadata, requestAuthorisationCode.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency, amountType, codeLifetime, holdFundsIndicator, redemptionAccountIdentifiers,
                redemptionChannels, redemptionTransactionTypes, requestingOrganisation, requestDate, customData, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestAuthorisationCode {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    amountType: ").append(toIndentedString(amountType)).append("\n");
        sb.append("    codeLifetime: ").append(toIndentedString(codeLifetime)).append("\n");
        sb.append("    holdFundsIndicator: ").append(toIndentedString(holdFundsIndicator)).append("\n");
        sb.append("    redemptionAccountIdentifiers: ").append(toIndentedString(redemptionAccountIdentifiers)).append("\n");
        sb.append("    redemptionChannels: ").append(toIndentedString(redemptionChannels)).append("\n");
        sb.append("    redemptionTransactionTypes: ").append(toIndentedString(redemptionTransactionTypes)).append("\n");
        sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
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
