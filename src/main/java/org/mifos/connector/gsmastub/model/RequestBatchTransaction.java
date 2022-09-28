package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RequestBatchTransaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestBatchTransaction   {
  @JsonProperty("batchStatus")
  private BatchStatus batchStatus = null;

  @JsonProperty("transactions")
  @Valid
  private List<RequestTransaction> transactions = new ArrayList<RequestTransaction>();

  @JsonProperty("batchTitle")
  private String batchTitle = null;

  @JsonProperty("batchdescription")
  private String batchdescription = null;

  @JsonProperty("requestingOrganisation")
  private RequestingOrganisation requestingOrganisation = null;

  @JsonProperty("scheduledStartDate")
  private OffsetDateTime scheduledStartDate = null;

  @JsonProperty("modificationDate")
  private OffsetDateTime modificationDate = null;

  @JsonProperty("requestDate")
  private OffsetDateTime requestDate = null;

  @JsonProperty("customData")
  private CustomDataArray customData = null;

  public RequestBatchTransaction batchStatus(BatchStatus batchStatus) {
    this.batchStatus = batchStatus;
    return this;
  }

  /**
   * Get batchStatus
   * @return batchStatus
   **/
  @Schema(description = "")
  
    @Valid
    public BatchStatus getBatchStatus() {
    return batchStatus;
  }

  public void setBatchStatus(BatchStatus batchStatus) {
    this.batchStatus = batchStatus;
  }

  public RequestBatchTransaction transactions(List<RequestTransaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public RequestBatchTransaction addTransactionsItem(RequestTransaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

  /**
   * Collection of Transactions that are to be processed.
   * @return transactions
   **/
  @Schema(required = true, description = "Collection of Transactions that are to be processed.")
      @NotNull
    @Valid
  @Size(min=1,max=999999)   public List<RequestTransaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<RequestTransaction> transactions) {
    this.transactions = transactions;
  }

  public RequestBatchTransaction batchTitle(String batchTitle) {
    this.batchTitle = batchTitle;
    return this;
  }

  /**
   * Client-provided title for the batch.
   * @return batchTitle
   **/
  @Schema(description = "Client-provided title for the batch.")
  
  @Size(max=256)   public String getBatchTitle() {
    return batchTitle;
  }

  public void setBatchTitle(String batchTitle) {
    this.batchTitle = batchTitle;
  }

  public RequestBatchTransaction batchdescription(String batchdescription) {
    this.batchdescription = batchdescription;
    return this;
  }

  /**
   * Client-provided description of the batch.
   * @return batchdescription
   **/
  @Schema(description = "Client-provided description of the batch.")
  
  @Size(max=256)   public String getBatchdescription() {
    return batchdescription;
  }

  public void setBatchdescription(String batchdescription) {
    this.batchdescription = batchdescription;
  }

  public RequestBatchTransaction requestingOrganisation(RequestingOrganisation requestingOrganisation) {
    this.requestingOrganisation = requestingOrganisation;
    return this;
  }

  /**
   * Get requestingOrganisation
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

  public RequestBatchTransaction scheduledStartDate(OffsetDateTime scheduledStartDate) {
    this.scheduledStartDate = scheduledStartDate;
    return this;
  }

  /**
   * If the batch has been scheduled, the expected start time is provided here.
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

  public RequestBatchTransaction modificationDate(OffsetDateTime modificationDate) {
    this.modificationDate = modificationDate;
    return this;
  }

  /**
   * Date and time when the object was modified by the API Provider.
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

  public RequestBatchTransaction requestDate(OffsetDateTime requestDate) {
    this.requestDate = requestDate;
    return this;
  }

  /**
   * The date and time of the request as supplied by the client.
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

  public RequestBatchTransaction customData(CustomDataArray customData) {
    this.customData = customData;
    return this;
  }

  /**
   * Get customData
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
    RequestBatchTransaction requestBatchTransaction = (RequestBatchTransaction) o;
    return Objects.equals(this.batchStatus, requestBatchTransaction.batchStatus) &&
        Objects.equals(this.transactions, requestBatchTransaction.transactions) &&
        Objects.equals(this.batchTitle, requestBatchTransaction.batchTitle) &&
        Objects.equals(this.batchdescription, requestBatchTransaction.batchdescription) &&
        Objects.equals(this.requestingOrganisation, requestBatchTransaction.requestingOrganisation) &&
        Objects.equals(this.scheduledStartDate, requestBatchTransaction.scheduledStartDate) &&
        Objects.equals(this.modificationDate, requestBatchTransaction.modificationDate) &&
        Objects.equals(this.requestDate, requestBatchTransaction.requestDate) &&
        Objects.equals(this.customData, requestBatchTransaction.customData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(batchStatus, transactions, batchTitle, batchdescription, requestingOrganisation, scheduledStartDate, modificationDate, requestDate, customData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestBatchTransaction {\n");
    
    sb.append("    batchStatus: ").append(toIndentedString(batchStatus)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    batchTitle: ").append(toIndentedString(batchTitle)).append("\n");
    sb.append("    batchdescription: ").append(toIndentedString(batchdescription)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
    sb.append("    scheduledStartDate: ").append(toIndentedString(scheduledStartDate)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
    sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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
