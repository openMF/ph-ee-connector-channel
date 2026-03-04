package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ResponseBillCompanies
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class ResponseBillCompanies   {
  @JsonProperty("serviceProvider")
  private String serviceProvider = null;

  @JsonProperty("serviceProviderType")
  private String serviceProviderType = null;

  @JsonProperty("serviceProviderSubType")
  private String serviceProviderSubType = null;

  @JsonProperty("companyName")
  private String companyName = null;

  @JsonProperty("supplementaryServiceProviderDetails")
  @Valid
  private List<Metadata> supplementaryServiceProviderDetails = null;

  public ResponseBillCompanies serviceProvider(String serviceProvider) {
    this.serviceProvider = serviceProvider;
    return this;
  }

  /**
   * Service Provider Reference Code.
   * @return serviceProvider
   **/
  @Schema(required = true, description = "Service Provider Reference Code.")
      @NotNull

  @Size(max=256)   public String getServiceProvider() {
    return serviceProvider;
  }

  public void setServiceProvider(String serviceProvider) {
    this.serviceProvider = serviceProvider;
  }

  public ResponseBillCompanies serviceProviderType(String serviceProviderType) {
    this.serviceProviderType = serviceProviderType;
    return this;
  }

  /**
   * Type of Service Provider that accepts payments.
   * @return serviceProviderType
   **/
  @Schema(description = "Type of Service Provider that accepts payments.")
  
  @Size(max=256)   public String getServiceProviderType() {
    return serviceProviderType;
  }

  public void setServiceProviderType(String serviceProviderType) {
    this.serviceProviderType = serviceProviderType;
  }

  public ResponseBillCompanies serviceProviderSubType(String serviceProviderSubType) {
    this.serviceProviderSubType = serviceProviderSubType;
    return this;
  }

  /**
   * Sub-Type of Service Provider.
   * @return serviceProviderSubType
   **/
  @Schema(description = "Sub-Type of Service Provider.")
  
  @Size(max=256)   public String getServiceProviderSubType() {
    return serviceProviderSubType;
  }

  public void setServiceProviderSubType(String serviceProviderSubType) {
    this.serviceProviderSubType = serviceProviderSubType;
  }

  public ResponseBillCompanies companyName(String companyName) {
    this.companyName = companyName;
    return this;
  }

  /**
   * Display Name for the Service Provider.
   * @return companyName
   **/
  @Schema(required = true, description = "Display Name for the Service Provider.")
      @NotNull

  @Size(max=256)   public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public ResponseBillCompanies supplementaryServiceProviderDetails(List<Metadata> supplementaryServiceProviderDetails) {
    this.supplementaryServiceProviderDetails = supplementaryServiceProviderDetails;
    return this;
  }

  public ResponseBillCompanies addSupplementaryServiceProviderDetailsItem(Metadata supplementaryServiceProviderDetailsItem) {
    if (this.supplementaryServiceProviderDetails == null) {
      this.supplementaryServiceProviderDetails = new ArrayList<Metadata>();
    }
    this.supplementaryServiceProviderDetails.add(supplementaryServiceProviderDetailsItem);
    return this;
  }

  /**
   * Get supplementaryServiceProviderDetails
   * @return supplementaryServiceProviderDetails
   **/
  @Schema(description = "")
      @Valid
  @Size(max=20)   public List<Metadata> getSupplementaryServiceProviderDetails() {
    return supplementaryServiceProviderDetails;
  }

  public void setSupplementaryServiceProviderDetails(List<Metadata> supplementaryServiceProviderDetails) {
    this.supplementaryServiceProviderDetails = supplementaryServiceProviderDetails;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseBillCompanies responseBillCompanies = (ResponseBillCompanies) o;
    return Objects.equals(this.serviceProvider, responseBillCompanies.serviceProvider) &&
        Objects.equals(this.serviceProviderType, responseBillCompanies.serviceProviderType) &&
        Objects.equals(this.serviceProviderSubType, responseBillCompanies.serviceProviderSubType) &&
        Objects.equals(this.companyName, responseBillCompanies.companyName) &&
        Objects.equals(this.supplementaryServiceProviderDetails, responseBillCompanies.supplementaryServiceProviderDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceProvider, serviceProviderType, serviceProviderSubType, companyName, supplementaryServiceProviderDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseBillCompanies {\n");
    
    sb.append("    serviceProvider: ").append(toIndentedString(serviceProvider)).append("\n");
    sb.append("    serviceProviderType: ").append(toIndentedString(serviceProviderType)).append("\n");
    sb.append("    serviceProviderSubType: ").append(toIndentedString(serviceProviderSubType)).append("\n");
    sb.append("    companyName: ").append(toIndentedString(companyName)).append("\n");
    sb.append("    supplementaryServiceProviderDetails: ").append(toIndentedString(supplementaryServiceProviderDetails)).append("\n");
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
