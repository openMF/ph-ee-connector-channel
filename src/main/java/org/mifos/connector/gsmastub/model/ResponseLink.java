package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * ResponseLink
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseLink   {
  @JsonProperty("linkReference")
  private String linkReference = null;

  @JsonProperty("sourceAccountIdentifiers")
  private DebitPartyArray sourceAccountIdentifiers = null;

  @JsonProperty("mode")
  private Mode mode = null;

  @JsonProperty("status")
  private Status status = null;

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

  public ResponseLink linkReference(String linkReference) {
    this.linkReference = linkReference;
    return this;
  }

  /**
   * Indicates the Link reference. This enables a linked account to be uniquely identified.
   * @return linkReference
   **/
  @Schema(required = true, description = "Indicates the Link reference. This enables a linked account to be uniquely identified.")
      @NotNull

  @Size(min=1,max=256)   public String getLinkReference() {
    return linkReference;
  }

  public void setLinkReference(String linkReference) {
    this.linkReference = linkReference;
  }

  public ResponseLink sourceAccountIdentifiers(DebitPartyArray sourceAccountIdentifiers) {
    this.sourceAccountIdentifiers = sourceAccountIdentifiers;
    return this;
  }

  /**
   * Get sourceAccountIdentifiers
   * @return sourceAccountIdentifiers
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public DebitPartyArray getSourceAccountIdentifiers() {
    return sourceAccountIdentifiers;
  }

  public void setSourceAccountIdentifiers(DebitPartyArray sourceAccountIdentifiers) {
    this.sourceAccountIdentifiers = sourceAccountIdentifiers;
  }

  public ResponseLink mode(Mode mode) {
    this.mode = mode;
    return this;
  }

  /**
   * Get mode
   * @return mode
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public ResponseLink status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public ResponseLink requestingOrganisation(RequestingOrganisation requestingOrganisation) {
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

  public ResponseLink creationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Date and time when the object was created by the API Provider.
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

  public ResponseLink modificationDate(OffsetDateTime modificationDate) {
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

  public ResponseLink requestDate(OffsetDateTime requestDate) {
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

  public ResponseLink customData(CustomDataArray customData) {
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
    ResponseLink responseLink = (ResponseLink) o;
    return Objects.equals(this.linkReference, responseLink.linkReference) &&
        Objects.equals(this.sourceAccountIdentifiers, responseLink.sourceAccountIdentifiers) &&
        Objects.equals(this.mode, responseLink.mode) &&
        Objects.equals(this.status, responseLink.status) &&
        Objects.equals(this.requestingOrganisation, responseLink.requestingOrganisation) &&
        Objects.equals(this.creationDate, responseLink.creationDate) &&
        Objects.equals(this.modificationDate, responseLink.modificationDate) &&
        Objects.equals(this.requestDate, responseLink.requestDate) &&
        Objects.equals(this.customData, responseLink.customData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(linkReference, sourceAccountIdentifiers, mode, status, requestingOrganisation, creationDate, modificationDate, requestDate, customData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseLink {\n");
    
    sb.append("    linkReference: ").append(toIndentedString(linkReference)).append("\n");
    sb.append("    sourceAccountIdentifiers: ").append(toIndentedString(sourceAccountIdentifiers)).append("\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    requestingOrganisation: ").append(toIndentedString(requestingOrganisation)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
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
