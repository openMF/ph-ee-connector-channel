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
 * Quotes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class Quotes {

    @JsonProperty("quoteId")
    private String quoteId = null;

    @JsonProperty("receivingAmount")
    private String receivingAmount = null;

    @JsonProperty("receivingCurrency")
    private Currency receivingCurrency = null;

    @JsonProperty("sendingAmount")
    private String sendingAmount = null;

    @JsonProperty("sendingCurrency")
    private Currency sendingCurrency = null;

    @JsonProperty("deliveryMethod")
    private DeliveryMethod deliveryMethod = null;

    @JsonProperty("fees")
    private FeesArray fees = null;

    @JsonProperty("fxRate")
    private String fxRate = null;

    @JsonProperty("quoteExpiryTime")
    private OffsetDateTime quoteExpiryTime = null;

    @JsonProperty("receivingServiceProvider")
    private String receivingServiceProvider = null;

    public Quotes quoteId(String quoteId) {
        this.quoteId = quoteId;
        return this;
    }

    /**
     * The specific quote associated with the quotation.
     *
     * @return quoteId
     **/
    @Schema(required = true, description = "The specific quote associated with the quotation.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Quotes receivingAmount(String receivingAmount) {
        this.receivingAmount = receivingAmount;
        return this;
    }

    /**
     * Get receivingAmount
     *
     * @return receivingAmount
     **/
    @Schema(example = "15.21", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getReceivingAmount() {
        return receivingAmount;
    }

    public void setReceivingAmount(String receivingAmount) {
        this.receivingAmount = receivingAmount;
    }

    public Quotes receivingCurrency(Currency receivingCurrency) {
        this.receivingCurrency = receivingCurrency;
        return this;
    }

    /**
     * Get receivingCurrency
     *
     * @return receivingCurrency
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Currency getReceivingCurrency() {
        return receivingCurrency;
    }

    public void setReceivingCurrency(Currency receivingCurrency) {
        this.receivingCurrency = receivingCurrency;
    }

    public Quotes sendingAmount(String sendingAmount) {
        this.sendingAmount = sendingAmount;
        return this;
    }

    /**
     * Get sendingAmount
     *
     * @return sendingAmount
     **/
    @Schema(example = "15.21", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getSendingAmount() {
        return sendingAmount;
    }

    public void setSendingAmount(String sendingAmount) {
        this.sendingAmount = sendingAmount;
    }

    public Quotes sendingCurrency(Currency sendingCurrency) {
        this.sendingCurrency = sendingCurrency;
        return this;
    }

    /**
     * Get sendingCurrency
     *
     * @return sendingCurrency
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Currency getSendingCurrency() {
        return sendingCurrency;
    }

    public void setSendingCurrency(Currency sendingCurrency) {
        this.sendingCurrency = sendingCurrency;
    }

    public Quotes deliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
        return this;
    }

    /**
     * Get deliveryMethod
     *
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

    public Quotes fees(FeesArray fees) {
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

    public Quotes fxRate(String fxRate) {
        this.fxRate = fxRate;
        return this;
    }

    /**
     * The conversion rate applicable between the sending and the receiving currency for the requested transaction.
     *
     * @return fxRate
     **/
    @Schema(example = "1.3436", description = "The conversion rate applicable between the sending and the receiving currency for the requested transaction.")

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,10}[1-9])?$")
    @Size(min = 4, max = 256)
    public String getFxRate() {
        return fxRate;
    }

    public void setFxRate(String fxRate) {
        this.fxRate = fxRate;
    }

    public Quotes quoteExpiryTime(OffsetDateTime quoteExpiryTime) {
        this.quoteExpiryTime = quoteExpiryTime;
        return this;
    }

    /**
     * The timestamp when the quote will expire.
     *
     * @return quoteExpiryTime
     **/
    @Schema(description = "The timestamp when the quote will expire.")

    @Valid
    public OffsetDateTime getQuoteExpiryTime() {
        return quoteExpiryTime;
    }

    public void setQuoteExpiryTime(OffsetDateTime quoteExpiryTime) {
        this.quoteExpiryTime = quoteExpiryTime;
    }

    public Quotes receivingServiceProvider(String receivingServiceProvider) {
        this.receivingServiceProvider = receivingServiceProvider;
        return this;
    }

    /**
     * The name of the receiving service provider, i.e. the provider that the quote is associated with.
     *
     * @return receivingServiceProvider
     **/
    @Schema(description = "The name of the receiving service provider, i.e. the provider that the quote is associated with.")

    @Size(max = 256)
    public String getReceivingServiceProvider() {
        return receivingServiceProvider;
    }

    public void setReceivingServiceProvider(String receivingServiceProvider) {
        this.receivingServiceProvider = receivingServiceProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Quotes quotes = (Quotes) o;
        return Objects.equals(this.quoteId, quotes.quoteId) && Objects.equals(this.receivingAmount, quotes.receivingAmount)
                && Objects.equals(this.receivingCurrency, quotes.receivingCurrency)
                && Objects.equals(this.sendingAmount, quotes.sendingAmount) && Objects.equals(this.sendingCurrency, quotes.sendingCurrency)
                && Objects.equals(this.deliveryMethod, quotes.deliveryMethod) && Objects.equals(this.fees, quotes.fees)
                && Objects.equals(this.fxRate, quotes.fxRate) && Objects.equals(this.quoteExpiryTime, quotes.quoteExpiryTime)
                && Objects.equals(this.receivingServiceProvider, quotes.receivingServiceProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quoteId, receivingAmount, receivingCurrency, sendingAmount, sendingCurrency, deliveryMethod, fees, fxRate,
                quoteExpiryTime, receivingServiceProvider);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Quotes {\n");

        sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
        sb.append("    receivingAmount: ").append(toIndentedString(receivingAmount)).append("\n");
        sb.append("    receivingCurrency: ").append(toIndentedString(receivingCurrency)).append("\n");
        sb.append("    sendingAmount: ").append(toIndentedString(sendingAmount)).append("\n");
        sb.append("    sendingCurrency: ").append(toIndentedString(sendingCurrency)).append("\n");
        sb.append("    deliveryMethod: ").append(toIndentedString(deliveryMethod)).append("\n");
        sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
        sb.append("    fxRate: ").append(toIndentedString(fxRate)).append("\n");
        sb.append("    quoteExpiryTime: ").append(toIndentedString(quoteExpiryTime)).append("\n");
        sb.append("    receivingServiceProvider: ").append(toIndentedString(receivingServiceProvider)).append("\n");
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
