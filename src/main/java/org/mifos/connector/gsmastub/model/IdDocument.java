package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * IdDocument
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class IdDocument   {
  /**
   * Indicates the type of identification for the KYC subject, e.g. passport, driving licence etc.
   */
  public enum IdTypeEnum {
    PASSPORT("passport"),
    
    NATIONALREGISTRATION("nationalregistration"),
    
    OTHERID("otherId"),
    
    DRIVINGLICENCE("drivinglicence"),
    
    SOCIALSECURITY("socialsecurity"),
    
    ALIENREGISTRATION("alienregistration"),
    
    NATIONALIDCARD("nationalidcard"),
    
    EMPLOYER("employer"),
    
    TAXID("taxid"),
    
    SENIORCITIZENSCARD("seniorcitizenscard"),
    
    MARRIAGECERTIFICATE("marriagecertificate"),
    
    BIRTHCERTIFICATE("birthcertificate"),
    
    HEALTHCARD("healthcard"),
    
    VOTERSID("votersid"),
    
    VILLAGEELDERLETTER("villageelderLetter"),
    
    PANCARD("pancard"),
    
    OFFICIALLETTER("officialletter");

    private String value;

    IdTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static IdTypeEnum fromValue(String text) {
      for (IdTypeEnum b : IdTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("idType")
  private IdTypeEnum idType = null;

  @JsonProperty("idNumber")
  private String idNumber = null;

  @JsonProperty("issueDate")
  private LocalDate issueDate = null;

  @JsonProperty("expiryDate")
  private LocalDate expiryDate = null;

  @JsonProperty("issuer")
  private String issuer = null;

  @JsonProperty("issuerPlace")
  private String issuerPlace = null;

  @JsonProperty("issuerCountry")
  private Nationality issuerCountry = null;

  @JsonProperty("otherIddescription")
  private String otherIddescription = null;

  public IdDocument idType(IdTypeEnum idType) {
    this.idType = idType;
    return this;
  }

  /**
   * Indicates the type of identification for the KYC subject, e.g. passport, driving licence etc.
   * @return idType
   **/
  @Schema(required = true, description = "Indicates the type of identification for the KYC subject, e.g. passport, driving licence etc.")
      @NotNull

    public IdTypeEnum getIdType() {
    return idType;
  }

  public void setIdType(IdTypeEnum idType) {
    this.idType = idType;
  }

  public IdDocument idNumber(String idNumber) {
    this.idNumber = idNumber;
    return this;
  }

  /**
   * Reference pertaining to the type of identification for the KYC subject.
   * @return idNumber
   **/
  @Schema(description = "Reference pertaining to the type of identification for the KYC subject.")
  
  @Size(max=256)   public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public IdDocument issueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Date of issue for the identification document.
   * @return issueDate
   **/
  @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", description = "Date of issue for the identification document.")
  
    @Valid
    public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  public IdDocument expiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * Date of expiry for the identification document.
   * @return expiryDate
   **/
  @Schema(example = "Tue Nov 20 00:00:00 GMT 2018", description = "Date of expiry for the identification document.")
  
    @Valid
    public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(LocalDate expiryDate) {
    this.expiryDate = expiryDate;
  }

  public IdDocument issuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  /**
   * Indicates the organisation/government entity that issued the ID document.
   * @return issuer
   **/
  @Schema(description = "Indicates the organisation/government entity that issued the ID document.")
  
  @Size(max=256)   public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public IdDocument issuerPlace(String issuerPlace) {
    this.issuerPlace = issuerPlace;
    return this;
  }

  /**
   * Place of issue for the identification type.
   * @return issuerPlace
   **/
  @Schema(description = "Place of issue for the identification type.")
  
  @Size(max=256)   public String getIssuerPlace() {
    return issuerPlace;
  }

  public void setIssuerPlace(String issuerPlace) {
    this.issuerPlace = issuerPlace;
  }

  public IdDocument issuerCountry(Nationality issuerCountry) {
    this.issuerCountry = issuerCountry;
    return this;
  }

  /**
   * Get issuerCountry
   * @return issuerCountry
   **/
  @Schema(description = "")
  
    @Valid
    public Nationality getIssuerCountry() {
    return issuerCountry;
  }

  public void setIssuerCountry(Nationality issuerCountry) {
    this.issuerCountry = issuerCountry;
  }

  public IdDocument otherIddescription(String otherIddescription) {
    this.otherIddescription = otherIddescription;
    return this;
  }

  /**
   * Where an ID Type of otherid is specified, a description of the type of identification can be provided in this field.
   * @return otherIddescription
   **/
  @Schema(description = "Where an ID Type of otherid is specified, a description of the type of identification can be provided in this field.")
  
  @Size(max=256)   public String getOtherIddescription() {
    return otherIddescription;
  }

  public void setOtherIddescription(String otherIddescription) {
    this.otherIddescription = otherIddescription;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IdDocument idDocument = (IdDocument) o;
    return Objects.equals(this.idType, idDocument.idType) &&
        Objects.equals(this.idNumber, idDocument.idNumber) &&
        Objects.equals(this.issueDate, idDocument.issueDate) &&
        Objects.equals(this.expiryDate, idDocument.expiryDate) &&
        Objects.equals(this.issuer, idDocument.issuer) &&
        Objects.equals(this.issuerPlace, idDocument.issuerPlace) &&
        Objects.equals(this.issuerCountry, idDocument.issuerCountry) &&
        Objects.equals(this.otherIddescription, idDocument.otherIddescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idType, idNumber, issueDate, expiryDate, issuer, issuerPlace, issuerCountry, otherIddescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IdDocument {\n");
    
    sb.append("    idType: ").append(toIndentedString(idType)).append("\n");
    sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
    sb.append("    issuer: ").append(toIndentedString(issuer)).append("\n");
    sb.append("    issuerPlace: ").append(toIndentedString(issuerPlace)).append("\n");
    sb.append("    issuerCountry: ").append(toIndentedString(issuerCountry)).append("\n");
    sb.append("    otherIddescription: ").append(toIndentedString(otherIddescription)).append("\n");
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
