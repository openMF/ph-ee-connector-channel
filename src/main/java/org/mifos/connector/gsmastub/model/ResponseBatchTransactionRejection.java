package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseBatchTransactionRejection
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseBatchTransactionRejection {

    @JsonProperty("transactionReference")
    private String transactionReference = null;

    @JsonProperty("requestingOrganisationTransactionReference")
    private String requestingOrganisationTransactionReference = null;

    @JsonProperty("creditParty")
    private CreditPartyArray creditParty = null;

    @JsonProperty("debitParty")
    private DebitPartyArray debitParty = null;

    @JsonProperty("rejectionReason")
    private String rejectionReason = null;

    @JsonProperty("rejectionDate")
    private OffsetDateTime rejectionDate = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("dateRejected")
    private OffsetDateTime dateRejected = null;

    public ResponseBatchTransactionRejection transactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
        return this;
    }

    /**
     * Unique reference for the transaction. This is returned in the response by API provider.
     *
     * @return transactionReference
     **/
    @Schema(description = "Unique reference for the transaction. This is returned in the response by API provider.")

    @Size(min = 1, max = 256)
    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public ResponseBatchTransactionRejection requestingOrganisationTransactionReference(String requestingOrganisationTransactionReference) {
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

    public ResponseBatchTransactionRejection creditParty(CreditPartyArray creditParty) {
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

    public ResponseBatchTransactionRejection debitParty(DebitPartyArray debitParty) {
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

    public ResponseBatchTransactionRejection rejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
        return this;
    }

    /**
     * The reason for the transaction request as indicated by the API provider.
     *
     * @return rejectionReason
     **/
    @Schema(required = true, description = "The reason for the transaction request as indicated by the API provider.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public ResponseBatchTransactionRejection rejectionDate(OffsetDateTime rejectionDate) {
        this.rejectionDate = rejectionDate;
        return this;
    }

    /**
     * Date and time of the rejection.
     *
     * @return rejectionDate
     **/
    @Schema(required = true, description = "Date and time of the rejection.")
    @NotNull

    @Valid
    public OffsetDateTime getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(OffsetDateTime rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public ResponseBatchTransactionRejection customData(CustomDataArray customData) {
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

    public ResponseBatchTransactionRejection dateRejected(OffsetDateTime dateRejected) {
        this.dateRejected = dateRejected;
        return this;
    }

    /**
     * Date and time of the rejection.
     *
     * @return dateRejected
     **/
    @Schema(description = "Date and time of the rejection.")

    @Valid
    public OffsetDateTime getDateRejected() {
        return dateRejected;
    }

    public void setDateRejected(OffsetDateTime dateRejected) {
        this.dateRejected = dateRejected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBatchTransactionRejection responseBatchTransactionRejection = (ResponseBatchTransactionRejection) o;
        return Objects.equals(this.transactionReference, responseBatchTransactionRejection.transactionReference)
                && Objects.equals(this.requestingOrganisationTransactionReference,
                        responseBatchTransactionRejection.requestingOrganisationTransactionReference)
                && Objects.equals(this.creditParty, responseBatchTransactionRejection.creditParty)
                && Objects.equals(this.debitParty, responseBatchTransactionRejection.debitParty)
                && Objects.equals(this.rejectionReason, responseBatchTransactionRejection.rejectionReason)
                && Objects.equals(this.rejectionDate, responseBatchTransactionRejection.rejectionDate)
                && Objects.equals(this.customData, responseBatchTransactionRejection.customData)
                && Objects.equals(this.dateRejected, responseBatchTransactionRejection.dateRejected);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionReference, requestingOrganisationTransactionReference, creditParty, debitParty, rejectionReason,
                rejectionDate, customData, dateRejected);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBatchTransactionRejection {\n");

        sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
        sb.append("    requestingOrganisationTransactionReference: ").append(toIndentedString(requestingOrganisationTransactionReference))
                .append("\n");
        sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
        sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
        sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
        sb.append("    rejectionDate: ").append(toIndentedString(rejectionDate)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
        sb.append("    dateRejected: ").append(toIndentedString(dateRejected)).append("\n");
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
