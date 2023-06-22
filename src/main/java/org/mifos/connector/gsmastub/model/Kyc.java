package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDate;

/**
 * Kyc
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class Kyc {

    @JsonProperty("birthCountry")
    private Nationality birthCountry = null;

    @JsonProperty("contactPhone")
    private String contactPhone = null;

    @JsonProperty("dateOfBirth")
    private LocalDate dateOfBirth = null;

    @JsonProperty("emailAddress")
    private String emailAddress = null;

    @JsonProperty("employerName")
    private String employerName = null;

    @JsonProperty("gender")
    private Gender gender = null;

    @JsonProperty("idDocument")
    private IdDocumentArray idDocument = null;

    @JsonProperty("nationality")
    private Nationality nationality = null;

    @JsonProperty("occupation")
    private String occupation = null;

    @JsonProperty("postalAddress")
    private PostalAddress postalAddress = null;

    @JsonProperty("subjectName")
    private SubjectName subjectName = null;

    public Kyc birthCountry(Nationality birthCountry) {
        this.birthCountry = birthCountry;
        return this;
    }

    /**
     * Get birthCountry
     *
     * @return birthCountry
     **/
    @Schema(description = "")

    @Valid
    public Nationality getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(Nationality birthCountry) {
        this.birthCountry = birthCountry;
    }

    public Kyc contactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
        return this;
    }

    /**
     * Contact phone number (mobile or landline) of the KYC subject.
     *
     * @return contactPhone
     **/
    @Schema(description = "Contact phone number (mobile or landline) of the KYC subject.")

    @Size(max = 256)
    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Kyc dateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Birth date of the KYC subject.
     *
     * @return dateOfBirth
     **/
    @Schema(example = "Mon Nov 20 00:00:00 GMT 2000", description = "Birth date of the KYC subject.")

    @Valid
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Kyc emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Email address of the KYC subject.
     *
     * @return emailAddress
     **/
    @Schema(description = "Email address of the KYC subject.")

    @Size(max = 256)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Kyc employerName(String employerName) {
        this.employerName = employerName;
        return this;
    }

    /**
     * Employer name of the KYC subject.
     *
     * @return employerName
     **/
    @Schema(description = "Employer name of the KYC subject.")

    @Size(max = 256)
    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Kyc gender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Get gender
     *
     * @return gender
     **/
    @Schema(description = "")

    @Valid
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Kyc idDocument(IdDocumentArray idDocument) {
        this.idDocument = idDocument;
        return this;
    }

    /**
     * Get idDocument
     *
     * @return idDocument
     **/
    @Schema(description = "")

    @Valid
    public IdDocumentArray getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(IdDocumentArray idDocument) {
        this.idDocument = idDocument;
    }

    public Kyc nationality(Nationality nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * Get nationality
     *
     * @return nationality
     **/
    @Schema(description = "")

    @Valid
    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Kyc occupation(String occupation) {
        this.occupation = occupation;
        return this;
    }

    /**
     * Occupation of the KYC subject.
     *
     * @return occupation
     **/
    @Schema(description = "Occupation of the KYC subject.")

    @Size(max = 256)
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Kyc postalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
        return this;
    }

    /**
     * Get postalAddress
     *
     * @return postalAddress
     **/
    @Schema(description = "")

    @Valid
    public PostalAddress getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(PostalAddress postalAddress) {
        this.postalAddress = postalAddress;
    }

    public Kyc subjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    /**
     * Get subjectName
     *
     * @return subjectName
     **/
    @Schema(description = "")

    @Valid
    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Kyc kyc = (Kyc) o;
        return Objects.equals(this.birthCountry, kyc.birthCountry) && Objects.equals(this.contactPhone, kyc.contactPhone)
                && Objects.equals(this.dateOfBirth, kyc.dateOfBirth) && Objects.equals(this.emailAddress, kyc.emailAddress)
                && Objects.equals(this.employerName, kyc.employerName) && Objects.equals(this.gender, kyc.gender)
                && Objects.equals(this.idDocument, kyc.idDocument) && Objects.equals(this.nationality, kyc.nationality)
                && Objects.equals(this.occupation, kyc.occupation) && Objects.equals(this.postalAddress, kyc.postalAddress)
                && Objects.equals(this.subjectName, kyc.subjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthCountry, contactPhone, dateOfBirth, emailAddress, employerName, gender, idDocument, nationality,
                occupation, postalAddress, subjectName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Kyc {\n");

        sb.append("    birthCountry: ").append(toIndentedString(birthCountry)).append("\n");
        sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
        sb.append("    employerName: ").append(toIndentedString(employerName)).append("\n");
        sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
        sb.append("    idDocument: ").append(toIndentedString(idDocument)).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
        sb.append("    occupation: ").append(toIndentedString(occupation)).append("\n");
        sb.append("    postalAddress: ").append(toIndentedString(postalAddress)).append("\n");
        sb.append("    subjectName: ").append(toIndentedString(subjectName)).append("\n");
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
