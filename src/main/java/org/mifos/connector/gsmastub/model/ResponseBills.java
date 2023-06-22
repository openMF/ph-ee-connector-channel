package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseBills
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseBills {

    @JsonProperty("billReference")
    private String billReference = null;

    @JsonProperty("billStatus")
    private BillStatus billStatus = null;

    @JsonProperty("amountDue")
    private String amountDue = null;

    @JsonProperty("currency")
    private Currency currency = null;

    @JsonProperty("billdescription")
    private String billdescription = null;

    @JsonProperty("dueDate")
    private LocalDate dueDate = null;

    @JsonProperty("minimumAmountDue")
    private String minimumAmountDue = null;

    @JsonProperty("creationDate")
    private OffsetDateTime creationDate = null;

    @JsonProperty("modificationDate")
    private OffsetDateTime modificationDate = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("metadata")
    private MetadataArray metadata = null;

    public ResponseBills billReference(String billReference) {
        this.billReference = billReference;
        return this;
    }

    /**
     * Reference number for the Bill that the payer can use when making a payment.
     *
     * @return billReference
     **/
    @Schema(description = "Reference number for the Bill that the payer can use when making a payment.")

    @Size(max = 256)
    public String getBillReference() {
        return billReference;
    }

    public void setBillReference(String billReference) {
        this.billReference = billReference;
    }

    public ResponseBills billStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
        return this;
    }

    /**
     * Get billStatus
     *
     * @return billStatus
     **/
    @Schema(description = "")

    @Valid
    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public ResponseBills amountDue(String amountDue) {
        this.amountDue = amountDue;
        return this;
    }

    /**
     * Get amountDue
     *
     * @return amountDue
     **/
    @Schema(example = "15.21", description = "")

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }

    public ResponseBills currency(Currency currency) {
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

    public ResponseBills billdescription(String billdescription) {
        this.billdescription = billdescription;
        return this;
    }

    /**
     * Description of the bill that is to be paid
     *
     * @return billdescription
     **/
    @Schema(description = "Description of the bill that is to be paid")

    @Size(max = 256)
    public String getBilldescription() {
        return billdescription;
    }

    public void setBilldescription(String billdescription) {
        this.billdescription = billdescription;
    }

    public ResponseBills dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    /**
     * Date on which the Bill is due to be paid.
     *
     * @return dueDate
     **/
    @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", description = "Date on which the Bill is due to be paid.")

    @Valid
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ResponseBills minimumAmountDue(String minimumAmountDue) {
        this.minimumAmountDue = minimumAmountDue;
        return this;
    }

    /**
     * Get minimumAmountDue
     *
     * @return minimumAmountDue
     **/
    @Schema(example = "15.21", description = "")

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getMinimumAmountDue() {
        return minimumAmountDue;
    }

    public void setMinimumAmountDue(String minimumAmountDue) {
        this.minimumAmountDue = minimumAmountDue;
    }

    public ResponseBills creationDate(OffsetDateTime creationDate) {
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

    public ResponseBills modificationDate(OffsetDateTime modificationDate) {
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

    public ResponseBills customData(CustomDataArray customData) {
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

    public ResponseBills metadata(MetadataArray metadata) {
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
        ResponseBills responseBills = (ResponseBills) o;
        return Objects.equals(this.billReference, responseBills.billReference) && Objects.equals(this.billStatus, responseBills.billStatus)
                && Objects.equals(this.amountDue, responseBills.amountDue) && Objects.equals(this.currency, responseBills.currency)
                && Objects.equals(this.billdescription, responseBills.billdescription)
                && Objects.equals(this.dueDate, responseBills.dueDate)
                && Objects.equals(this.minimumAmountDue, responseBills.minimumAmountDue)
                && Objects.equals(this.creationDate, responseBills.creationDate)
                && Objects.equals(this.modificationDate, responseBills.modificationDate)
                && Objects.equals(this.customData, responseBills.customData) && Objects.equals(this.metadata, responseBills.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billReference, billStatus, amountDue, currency, billdescription, dueDate, minimumAmountDue, creationDate,
                modificationDate, customData, metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBills {\n");

        sb.append("    billReference: ").append(toIndentedString(billReference)).append("\n");
        sb.append("    billStatus: ").append(toIndentedString(billStatus)).append("\n");
        sb.append("    amountDue: ").append(toIndentedString(amountDue)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    billdescription: ").append(toIndentedString(billdescription)).append("\n");
        sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
        sb.append("    minimumAmountDue: ").append(toIndentedString(minimumAmountDue)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
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
