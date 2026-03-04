package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * RequestStateObject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class RequestStateObject   {
  @JsonProperty("serverCorrelationId")
  private String serverCorrelationId = null;

  @JsonProperty("objectReference")
  private String objectReference = null;

  /**
   * Indicates the status of the request.
   */
  public enum StatusEnum {
    PENDING("pending"),
    
    COMPLETED("completed"),
    
    FAILED("failed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  /**
   * Indicates whether a callback will be issued or whether the client will need to poll.
   */
  public enum NotificationMethodEnum {
    CALLBACK("callback"),
    
    POLLING("polling");

    private String value;

    NotificationMethodEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NotificationMethodEnum fromValue(String text) {
      for (NotificationMethodEnum b : NotificationMethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("notificationMethod")
  private NotificationMethodEnum notificationMethod = null;

  @JsonProperty("pendingReason")
  private String pendingReason = null;

  @JsonProperty("expiryTime")
  private OffsetDateTime expiryTime = null;

  @JsonProperty("pollLimit")
  private BigDecimal pollLimit = null;

  @JsonProperty("error")
  private ErrorObject error = null;

  public RequestStateObject serverCorrelationId(String serverCorrelationId) {
    this.serverCorrelationId = serverCorrelationId;
    return this;
  }

  /**
   * A unique identifier issued by the provider to enable the client to identify the RequestState resource on subsequent polling requests. Must be supplied as a UUID.
   * @return serverCorrelationId
   **/
  @Schema(required = true, description = "A unique identifier issued by the provider to enable the client to identify the RequestState resource on subsequent polling requests. Must be supplied as a UUID.")
      @NotNull

  @Pattern(regexp="^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$") @Size(min=1,max=256)   public String getServerCorrelationId() {
    return serverCorrelationId;
  }

  public void setServerCorrelationId(String serverCorrelationId) {
    this.serverCorrelationId = serverCorrelationId;
  }

  public RequestStateObject objectReference(String objectReference) {
    this.objectReference = objectReference;
    return this;
  }

  /**
   * Provides a reference to the subject resource, e.g. transaction reference.
   * @return objectReference
   **/
  @Schema(description = "Provides a reference to the subject resource, e.g. transaction reference.")
  
  @Size(max=256)   public String getObjectReference() {
    return objectReference;
  }

  public void setObjectReference(String objectReference) {
    this.objectReference = objectReference;
  }

  public RequestStateObject status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Indicates the status of the request.
   * @return status
   **/
  @Schema(required = true, description = "Indicates the status of the request.")
      @NotNull

    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public RequestStateObject notificationMethod(NotificationMethodEnum notificationMethod) {
    this.notificationMethod = notificationMethod;
    return this;
  }

  /**
   * Indicates whether a callback will be issued or whether the client will need to poll.
   * @return notificationMethod
   **/
  @Schema(required = true, description = "Indicates whether a callback will be issued or whether the client will need to poll.")
      @NotNull

    public NotificationMethodEnum getNotificationMethod() {
    return notificationMethod;
  }

  public void setNotificationMethod(NotificationMethodEnum notificationMethod) {
    this.notificationMethod = notificationMethod;
  }

  public RequestStateObject pendingReason(String pendingReason) {
    this.pendingReason = pendingReason;
    return this;
  }

  /**
   * A textual description that can be provided to describe the reason for a pending status.
   * @return pendingReason
   **/
  @Schema(description = "A textual description that can be provided to describe the reason for a pending status.")
  
  @Size(max=256)   public String getPendingReason() {
    return pendingReason;
  }

  public void setPendingReason(String pendingReason) {
    this.pendingReason = pendingReason;
  }

  public RequestStateObject expiryTime(OffsetDateTime expiryTime) {
    this.expiryTime = expiryTime;
    return this;
  }

  /**
   * Indicate the time by which the provider will fail the request if completion criteria have not been met. For an example, a debit party failing to authorise within the allowed period.
   * @return expiryTime
   **/
  @Schema(description = "Indicate the time by which the provider will fail the request if completion criteria have not been met. For an example, a debit party failing to authorise within the allowed period.")
  
    @Valid
    public OffsetDateTime getExpiryTime() {
    return expiryTime;
  }

  public void setExpiryTime(OffsetDateTime expiryTime) {
    this.expiryTime = expiryTime;
  }

  public RequestStateObject pollLimit(BigDecimal pollLimit) {
    this.pollLimit = pollLimit;
    return this;
  }

  /**
   * Indicates the number of poll attempts for the given requeststate resource that will be allowed by the provider.
   * minimum: 0
   * @return pollLimit
   **/
  @Schema(description = "Indicates the number of poll attempts for the given requeststate resource that will be allowed by the provider.")
  
    @Valid
  @DecimalMin("0")  public BigDecimal getPollLimit() {
    return pollLimit;
  }

  public void setPollLimit(BigDecimal pollLimit) {
    this.pollLimit = pollLimit;
  }

  public RequestStateObject error(ErrorObject error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
   **/
  @Schema(description = "")
  
    @Valid
    public ErrorObject getError() {
    return error;
  }

  public void setError(ErrorObject error) {
    this.error = error;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestStateObject requestStateObject = (RequestStateObject) o;
    return Objects.equals(this.serverCorrelationId, requestStateObject.serverCorrelationId) &&
        Objects.equals(this.objectReference, requestStateObject.objectReference) &&
        Objects.equals(this.status, requestStateObject.status) &&
        Objects.equals(this.notificationMethod, requestStateObject.notificationMethod) &&
        Objects.equals(this.pendingReason, requestStateObject.pendingReason) &&
        Objects.equals(this.expiryTime, requestStateObject.expiryTime) &&
        Objects.equals(this.pollLimit, requestStateObject.pollLimit) &&
        Objects.equals(this.error, requestStateObject.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serverCorrelationId, objectReference, status, notificationMethod, pendingReason, expiryTime, pollLimit, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestStateObject {\n");
    
    sb.append("    serverCorrelationId: ").append(toIndentedString(serverCorrelationId)).append("\n");
    sb.append("    objectReference: ").append(toIndentedString(objectReference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    notificationMethod: ").append(toIndentedString(notificationMethod)).append("\n");
    sb.append("    pendingReason: ").append(toIndentedString(pendingReason)).append("\n");
    sb.append("    expiryTime: ").append(toIndentedString(expiryTime)).append("\n");
    sb.append("    pollLimit: ").append(toIndentedString(pollLimit)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
