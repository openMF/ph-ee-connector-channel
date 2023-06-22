package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * ResponseBatchTransaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseBatchTransaction {

    @JsonProperty("batchId")
    private String batchId = null;

    @JsonProperty("batchStatus")
    private BatchStatus batchStatus = null;

    @JsonProperty("approvalDate")
    private OffsetDateTime approvalDate = null;

    @JsonProperty("completionDate")
    private OffsetDateTime completionDate = null;

    @JsonProperty("batchTitle")
    private String batchTitle = null;

    @JsonProperty("batchdescription")
    private String batchdescription = null;

    @JsonProperty("processingFlag")
    private Boolean processingFlag = null;

    @JsonProperty("completedCount")
    private BigDecimal completedCount = null;

    @JsonProperty("rejectionCount")
    private BigDecimal rejectionCount = null;

    @JsonProperty("parsingSuccessCount")
    private BigDecimal parsingSuccessCount = null;

    @JsonProperty("requestingOrganisation")
    private RequestingOrganisation requestingOrganisation = null;

    @JsonProperty("scheduledStartDate")
    private OffsetDateTime scheduledStartDate = null;

    @JsonProperty("creationDate")
    private OffsetDateTime creationDate = null;

    @JsonProperty("modificationDate")
    private OffsetDateTime modificationDate = null;

    @JsonProperty("requestDate")
    private OffsetDateTime requestDate = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("completedDate")
    private OffsetDateTime completedDate = null;

    public ResponseBatchTransaction batchId(String batchId) {
        this.batchId = batchId;
        return this;
    }

    /**
     * Identifier for the Batch that is assigned by the API provider. This ID is used by the client on subsequent GET or
     * PATCH methods.
     *
     * @return batchId
     **/
    @Schema(required = true, description = "Identifier for the Batch that is assigned by the API provider. This ID is used by the client on subsequent GET or PATCH methods.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public ResponseBatchTransaction batchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
        return this;
    }

    /**
     * Get batchStatus
     *
     * @return batchStatus
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public BatchStatus getBatchStatus() {
        return batchStatus;
    }

    public void setBatchStatus(BatchStatus batchStatus) {
        this.batchStatus = batchStatus;
    }

    public ResponseBatchTransaction approvalDate(OffsetDateTime approvalDate) {
        this.approvalDate = approvalDate;
        return this;
    }

    /**
     * Indicates when the batch was approved as recorded by the API.
     *
     * @return approvalDate
     **/
    @Schema(required = true, description = "Indicates when the batch was approved as recorded by the API.")
    @NotNull

    @Valid
    public OffsetDateTime getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(OffsetDateTime approvalDate) {
        this.approvalDate = approvalDate;
    }

    public ResponseBatchTransaction completionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    /**
     * Indicates when the batch was completed as recorded by the API.
     *
     * @return completionDate
     **/
    @Schema(required = true, description = "Indicates when the batch was completed as recorded by the API.")
    @NotNull

    @Valid
    public OffsetDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(OffsetDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public ResponseBatchTransaction batchTitle(String batchTitle) {
        this.batchTitle = batchTitle;
        return this;
    }

    /**
     * Client-provided title for the batch.
     *
     * @return batchTitle
     **/
    @Schema(description = "Client-provided title for the batch.")

    @Size(max = 256)
    public String getBatchTitle() {
        return batchTitle;
    }

    public void setBatchTitle(String batchTitle) {
        this.batchTitle = batchTitle;
    }

    public ResponseBatchTransaction batchdescription(String batchdescription) {
        this.batchdescription = batchdescription;
        return this;
    }

    /**
     * Client-provided description of the batch.
     *
     * @return batchdescription
     **/
    @Schema(description = "Client-provided description of the batch.")

    @Size(max = 256)
    public String getBatchdescription() {
        return batchdescription;
    }

    public void setBatchdescription(String batchdescription) {
        this.batchdescription = batchdescription;
    }

    public ResponseBatchTransaction processingFlag(Boolean processingFlag) {
        this.processingFlag = processingFlag;
        return this;
    }

    /**
     * Indicates whether the batch is currently undergoing processing by the API Provider.
     *
     * @return processingFlag
     **/
    @Schema(description = "Indicates whether the batch is currently undergoing processing by the API Provider.")

    public Boolean isProcessingFlag() {
        return processingFlag;
    }

    public void setProcessingFlag(Boolean processingFlag) {
        this.processingFlag = processingFlag;
    }

    public ResponseBatchTransaction completedCount(BigDecimal completedCount) {
        this.completedCount = completedCount;
        return this;
    }

    /**
     * Indicates the number of records that have been successful completed. minimum: 0
     *
     * @return completedCount
     **/
    @Schema(description = "Indicates the number of records that have been successful completed.")

    @Valid
    @DecimalMin("0")
    public BigDecimal getCompletedCount() {
        return completedCount;
    }

    public void setCompletedCount(BigDecimal completedCount) {
        this.completedCount = completedCount;
    }

    public ResponseBatchTransaction rejectionCount(BigDecimal rejectionCount) {
        this.rejectionCount = rejectionCount;
        return this;
    }

    /**
     * Indicates the number of records that have been rejected, either during parsing or during final processing.
     * minimum: 0
     *
     * @return rejectionCount
     **/
    @Schema(description = "Indicates the number of records that have been rejected, either during parsing or during final processing.")

    @Valid
    @DecimalMin("0")
    public BigDecimal getRejectionCount() {
        return rejectionCount;
    }

    public void setRejectionCount(BigDecimal rejectionCount) {
        this.rejectionCount = rejectionCount;
    }

    public ResponseBatchTransaction parsingSuccessCount(BigDecimal parsingSuccessCount) {
        this.parsingSuccessCount = parsingSuccessCount;
        return this;
    }

    /**
     * Indicates the number of records that have been parsed successfully. minimum: 0
     *
     * @return parsingSuccessCount
     **/
    @Schema(description = "Indicates the number of records that have been parsed successfully.")

    @Valid
    @DecimalMin("0")
    public BigDecimal getParsingSuccessCount() {
        return parsingSuccessCount;
    }

    public void setParsingSuccessCount(BigDecimal parsingSuccessCount) {
        this.parsingSuccessCount = parsingSuccessCount;
    }

    public ResponseBatchTransaction requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

    public ResponseBatchTransaction scheduledStartDate(OffsetDateTime scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
        return this;
    }

    /**
     * If the batch has been scheduled, the expected start time is provided here.
     *
     * @return scheduledStartDate
     **/
    @Schema(description = "If the batch has been scheduled, the expected start time is provided here.")

    @Valid
    public OffsetDateTime getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(OffsetDateTime scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public ResponseBatchTransaction creationDate(OffsetDateTime creationDate) {
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

    public ResponseBatchTransaction modificationDate(OffsetDateTime modificationDate) {
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

    public ResponseBatchTransaction requestDate(OffsetDateTime requestDate) {
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

    public ResponseBatchTransaction customData(CustomDataArray customData) {
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

    public ResponseBatchTransaction completedDate(OffsetDateTime completedDate) {
        this.completedDate = completedDate;
        return this;
    }

    /**
     * Indicates when the batch was completed as recorded by the API.
     *
     * @return completedDate
     **/
    @Schema(description = "Indicates when the batch was completed as recorded by the API.")

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
        ResponseBatchTransaction responseBatchTransaction = (ResponseBatchTransaction) o;
        return Objects.equals(this.batchId, responseBatchTransaction.batchId)
                && Objects.equals(this.batchStatus, responseBatchTransaction.batchStatus)
                && Objects.equals(this.approvalDate, responseBatchTransaction.approvalDate)
                && Objects.equals(this.completionDate, responseBatchTransaction.completionDate)
                && Objects.equals(this.batchTitle, responseBatchTransaction.batchTitle)
                && Objects.equals(this.batchdescription, responseBatchTransaction.batchdescription)
                && Objects.equals(this.processingFlag, responseBatchTransaction.processingFlag)
                && Objects.equals(this.completedCount, responseBatchTransaction.completedCount)
                && Objects.equals(this.rejectionCount, responseBatchTransaction.rejectionCount)
                && Objects.equals(this.parsingSuccessCount, responseBatchTransaction.parsingSuccessCount)
                && Objects.equals(this.requestingOrganisation, responseBatchTransaction.requestingOrganisation)
                && Objects.equals(this.scheduledStartDate, responseBatchTransaction.scheduledStartDate)
                && Objects.equals(this.creationDate, responseBatchTransaction.creationDate)
                && Objects.equals(this.modificationDate, responseBatchTransaction.modificationDate)
                && Objects.equals(this.requestDate, responseBatchTransaction.requestDate)
                && Objects.equals(this.customData, responseBatchTransaction.customData)
                && Objects.equals(this.completedDate, responseBatchTransaction.completedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchId, batchStatus, approvalDate, completionDate, batchTitle, batchdescription, processingFlag,
                completedCount, rejectionCount, parsingSuccessCount, requestingOrganisation, scheduledStartDate, creationDate,
                modificationDate, requestDate, customData, completedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseBatchTransaction {\n");

        sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
        sb.append("    batchStatus: ").append(toIndentedString(batchStatus)).append("\n");
        sb.append("    approvalDate: ").append(toIndentedString(approvalDate)).append("\n");
        sb.append("    completionDate: ").append(toIndentedString(completionDate)).append("\n");
        sb.append("    batchTitle: ").append(toIndentedString(batchTitle)).append("\n");
        sb.append("    batchdescription: ").append(toIndentedString(batchdescription)).append("\n");
        sb.append("    processingFlag: ").append(toIndentedString(processingFlag)).append("\n");
        sb.append("    completedCount: ").append(toIndentedString(completedCount)).append("\n");
        sb.append("    rejectionCount: ").append(toIndentedString(rejectionCount)).append("\n");
        sb.append("    parsingSuccessCount: ").append(toIndentedString(parsingSuccessCount)).append("\n");
        sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
        sb.append("    scheduledStartDate: ").append(toIndentedString(scheduledStartDate)).append("\n");
        sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
        sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
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
