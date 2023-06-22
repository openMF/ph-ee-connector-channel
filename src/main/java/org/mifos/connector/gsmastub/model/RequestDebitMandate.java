package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

/**
 * RequestDebitMandate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RequestDebitMandate {

    @JsonProperty("payee")
    private Payee payee = null;

    @JsonProperty("mandateStatus")
    private MandateStatus mandateStatus = null;

    @JsonProperty("amountLimit")
    private Object amountLimit = null;

    @JsonProperty("currency")
    private Currency currency = null;

    @JsonProperty("startDate")
    private LocalDate startDate = null;

    @JsonProperty("endDate")
    private LocalDate endDate = null;

    @JsonProperty("frequencyType")
    private FrequencyType frequencyType = null;

    @JsonProperty("numberOfPayments")
    private BigDecimal numberOfPayments = null;

    @JsonProperty("requestingOrganisation")
    private RequestingOrganisation requestingOrganisation = null;

    @JsonProperty("requestDate")
    private OffsetDateTime requestDate = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    public RequestDebitMandate payee(Payee payee) {
        this.payee = payee;
        return this;
    }

    /**
     * Get payee
     *
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

    public RequestDebitMandate mandateStatus(MandateStatus mandateStatus) {
        this.mandateStatus = mandateStatus;
        return this;
    }

    /**
     * Get mandateStatus
     *
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

    public RequestDebitMandate amountLimit(Object amountLimit) {
        this.amountLimit = amountLimit;
        return this;
    }

    /**
     * The maximum amount that can be taken by the Payee on a payment request.
     *
     * @return amountLimit
     **/
    @Schema(description = "The maximum amount that can be taken by the Payee on a payment request.")

    public Object getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(Object amountLimit) {
        this.amountLimit = amountLimit;
    }

    public RequestDebitMandate currency(Currency currency) {
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

    public RequestDebitMandate startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Date on which the mandate starts. If a frequencyType is specified, this will also be the date on which the first
     * payment is to be taken.
     *
     * @return startDate
     **/
    @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", required = true, description = "Date on which the mandate starts. If a frequencyType is specified, this will also be the date on which the first payment is to be taken.")
    @NotNull

    @Valid
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public RequestDebitMandate endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Date on which the mandate ends.
     *
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

    public RequestDebitMandate frequencyType(FrequencyType frequencyType) {
        this.frequencyType = frequencyType;
        return this;
    }

    /**
     * Get frequencyType
     *
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

    public RequestDebitMandate numberOfPayments(BigDecimal numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
        return this;
    }

    /**
     * Indicates the number of consecutive payments that are to be taken. minimum: 0
     *
     * @return numberOfPayments
     **/
    @Schema(description = "Indicates the number of consecutive payments that are to be taken.")

    @Valid
    @DecimalMin("0")
    public BigDecimal getNumberOfPayments() {
        return numberOfPayments;
    }

    public void setNumberOfPayments(BigDecimal numberOfPayments) {
        this.numberOfPayments = numberOfPayments;
    }

    public RequestDebitMandate requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

    public RequestDebitMandate requestDate(OffsetDateTime requestDate) {
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

    public RequestDebitMandate customData(CustomDataArray customData) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestDebitMandate requestDebitMandate = (RequestDebitMandate) o;
        return Objects.equals(this.payee, requestDebitMandate.payee)
                && Objects.equals(this.mandateStatus, requestDebitMandate.mandateStatus)
                && Objects.equals(this.amountLimit, requestDebitMandate.amountLimit)
                && Objects.equals(this.currency, requestDebitMandate.currency)
                && Objects.equals(this.startDate, requestDebitMandate.startDate)
                && Objects.equals(this.endDate, requestDebitMandate.endDate)
                && Objects.equals(this.frequencyType, requestDebitMandate.frequencyType)
                && Objects.equals(this.numberOfPayments, requestDebitMandate.numberOfPayments)
                && Objects.equals(this.requestingOrganisation, requestDebitMandate.requestingOrganisation)
                && Objects.equals(this.requestDate, requestDebitMandate.requestDate)
                && Objects.equals(this.customData, requestDebitMandate.customData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payee, mandateStatus, amountLimit, currency, startDate, endDate, frequencyType, numberOfPayments,
                requestingOrganisation, requestDate, customData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestDebitMandate {\n");

        sb.append("    payee: ").append(toIndentedString(payee)).append("\n");
        sb.append("    mandateStatus: ").append(toIndentedString(mandateStatus)).append("\n");
        sb.append("    amountLimit: ").append(toIndentedString(amountLimit)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    frequencyType: ").append(toIndentedString(frequencyType)).append("\n");
        sb.append("    numberOfPayments: ").append(toIndentedString(numberOfPayments)).append("\n");
        sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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
