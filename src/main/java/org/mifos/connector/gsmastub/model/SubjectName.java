package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * SubjectName
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")


public class SubjectName   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("nativeName")
  private String nativeName = null;

  public SubjectName title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The given title of the KYC subject, e.g. Mr, Mrs, Dr.
   * @return title
   **/
  @Schema(description = "The given title of the KYC subject, e.g. Mr, Mrs, Dr.")
  
  @Size(max=256)   public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public SubjectName firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name (also referred to as given name) of the KYC subject.
   * @return firstName
   **/
  @Schema(description = "First name (also referred to as given name) of the KYC subject.")
  
  @Size(max=256)   public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public SubjectName middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle Name of the KYC subject.
   * @return middleName
   **/
  @Schema(description = "Middle Name of the KYC subject.")
  
  @Size(max=256)   public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public SubjectName lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Surname (also referred to as last or family name) of the KYC subject.
   * @return lastName
   **/
  @Schema(description = "Surname (also referred to as last or family name) of the KYC subject.")
  
  @Size(max=256)   public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public SubjectName fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  /**
   * The full name of the KYC subject.
   * @return fullName
   **/
  @Schema(description = "The full name of the KYC subject.")
  
  @Size(max=256)   public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public SubjectName nativeName(String nativeName) {
    this.nativeName = nativeName;
    return this;
  }

  /**
   * The full name expressed as in the native language.
   * @return nativeName
   **/
  @Schema(description = "The full name expressed as in the native language.")
  
  @Size(max=256)   public String getNativeName() {
    return nativeName;
  }

  public void setNativeName(String nativeName) {
    this.nativeName = nativeName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubjectName subjectName = (SubjectName) o;
    return Objects.equals(this.title, subjectName.title) &&
        Objects.equals(this.firstName, subjectName.firstName) &&
        Objects.equals(this.middleName, subjectName.middleName) &&
        Objects.equals(this.lastName, subjectName.lastName) &&
        Objects.equals(this.fullName, subjectName.fullName) &&
        Objects.equals(this.nativeName, subjectName.nativeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, firstName, middleName, lastName, fullName, nativeName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubjectName {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    nativeName: ").append(toIndentedString(nativeName)).append("\n");
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
