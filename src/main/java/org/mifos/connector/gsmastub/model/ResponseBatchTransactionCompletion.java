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
 * ResponseBatchTransactionCompletion
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseBatchTransactionCompletion {

    @JsonProperty("transactionReference")
    private String transactionReference = null;

    @JsonProperty("requestingOrganisationTransactionReference")
    private String requestingOrganisationTransactionReference = null;

    @JsonProperty("creditParty")
    private CreditPartyArray creditParty = null;

    @JsonProperty("debitParty")
    private DebitPartyArray debitParty = null;

    @JsonProperty("completionDate")
    private OffsetDateTime completionDate = null;

    @JsonProperty("link")
    private String link = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("completedDate")
    private OffsetDateTime completedDate = null;

    public ResponseBatchTransactionCompletion transactionReference(String transactionReference) {
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

    public ResponseBatchTransactionCompletion requestingOrganisationTransactionReference(
            String requestingOrganisationTransactionReference) {
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

    public ResponseBatchTransactionCompletion creditParty(CreditPartyArray creditParty) {
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

    public ResponseBatchTransactionCompletion debitParty(DebitPartyArray debitParty) {
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

    public ResponseBatchTransactionCompletion completionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    /**
     * Date and time indicating when the transaction was completed.
     *
     * @return completionDate
     **/
    @Schema(required = true, description = "Date and time indicating when the transaction was completed.")
    @NotNull

    @Valid
    public OffsetDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public ResponseBatchTransactionCompletion link(String link) {
        this.link = link;
        return this;
    }

    /**
     * Provides a URL to the resource.
     *
     * @return link
     **/
    @Schema(required = true, description = "Provides a URL to the resource.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ResponseBatchTransactionCompletion customData(CustomDataArray customData) {
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

    public ResponseBatchTransactionCompletion completedDate(OffsetDateTime completedDate) {
        this.completedDate = completedDate;
        return this;
    }

    /**
     * Date and time indicating when the transaction was completed.
     *
     * @return completedDate
     **/
    @Schema(description = "Date and time indicating when the transaction was completed.")

    @Valid
    public OffsetDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(OffsetDateTime completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseBatchTransactionCompletion responseBatchTransactionCompletion = (ResponseBatchTransactionCompletion) o;
        return Objects.equals(this.transactionReference, responseBatchTransactionCompletion.transactionReference)
                && Objects.equals(this.requestingOrganisationTransactionReference,
                        responseBatchTransactionCompletion.requestingOrganisationTransactionReference)
                && Objects.equals(this.creditParty, responseBatchTransactionCompletion.creditParty)
                && Objects.equals(this.debitParty, responseBatchTransactionCompletion.debitParty)
                && Objects.equals(this.completionDate, responseBatchTransactionCompletion.completionDate)
                && Objects.equals(this.link, responseBatchTransactionCompletion.link)
                && Objects.equals(this.customData, responseBatchTransactionCompletion.customData)
                && Objects.equals(this.completedDate, responseBatchTransactionCompletion.completedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionReference, requestingOrganisationTransactionReference, creditParty, debitParty, completionDate, link,
                customData, completedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBatchTransactionCompletion {\n");

        sb.append("    transactionReference: ").append(toIndentedString(transactionReference)).append("\n");
        sb.append("    requestingOrganisationTransactionReference: ").append(toIndentedString(requestingOrganisationTransactionReference))
                .append("\n");
        sb.append("    creditParty: ").append(toIndentedString(creditParty)).append("\n");
        sb.append("    debitParty: ").append(toIndentedString(debitParty)).append("\n");
        sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
        sb.append("    link: ").append(toIndentedString(link)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
        sb.append("    completedDate: ").append(toIndentedString(completedDate)).append("\n");
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
