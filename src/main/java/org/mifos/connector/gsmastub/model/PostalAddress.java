package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * PostalAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class PostalAddress {

    @JsonProperty("addressLine1")
    private String addressLine1 = null;

    @JsonProperty("addressLine2")
    private String addressLine2 = null;

    @JsonProperty("addressLine3")
    private String addressLine3 = null;

    @JsonProperty("city")
    private String city = null;

    @JsonProperty("stateProvince")
    private String stateProvince = null;

    @JsonProperty("postalCode")
    private String postalCode = null;

    @JsonProperty("country")
    private Nationality country = null;

    public PostalAddress addressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    /**
     * First line of the address.
     *
     * @return addressLine1
     **/
    @Schema(description = "First line of the address.")

    @Size(max = 256)
    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public PostalAddress addressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    /**
     * Second line of the address.
     *
     * @return addressLine2
     **/
    @Schema(description = "Second line of the address.")

    @Size(max = 256)
    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public PostalAddress addressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
        return this;
    }

    /**
     * Third line of the address.
     *
     * @return addressLine3
     **/
    @Schema(description = "Third line of the address.")

    @Size(max = 256)
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public PostalAddress city(String city) {
        this.city = city;
        return this;
    }

    /**
     * City/Town
     *
     * @return city
     **/
    @Schema(description = "City/Town")

    @Size(max = 256)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PostalAddress stateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
        return this;
    }

    /**
     * State or Province
     *
     * @return stateProvince
     **/
    @Schema(description = "State or Province")

    @Size(max = 256)
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public PostalAddress postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    /**
     * Postal Code
     *
     * @return postalCode
     **/
    @Schema(description = "Postal Code")

    @Size(max = 256)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PostalAddress country(Nationality country) {
        this.country = country;
        return this;
    }

    /**
     * Get country
     *
     * @return country
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Nationality getCountry() {
        return country;
    }

    public void setCountry(Nationality country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostalAddress postalAddress = (PostalAddress) o;
        return Objects.equals(this.addressLine1, postalAddress.addressLine1)
                && Objects.equals(this.addressLine2, postalAddress.addressLine2)
                && Objects.equals(this.addressLine3, postalAddress.addressLine3) && Objects.equals(this.city, postalAddress.city)
                && Objects.equals(this.stateProvince, postalAddress.stateProvince)
                && Objects.equals(this.postalCode, postalAddress.postalCode) && Objects.equals(this.country, postalAddress.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressLine1, addressLine2, addressLine3, city, stateProvince, postalCode, country);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostalAddress {\n");

        sb.append("    addressLine1: ").append(toIndentedString(addressLine1)).append("\n");
        sb.append("    addressLine2: ").append(toIndentedString(addressLine2)).append("\n");
        sb.append("    addressLine3: ").append(toIndentedString(addressLine3)).append("\n");
        sb.append("    city: ").append(toIndentedString(city)).append("\n");
        sb.append("    stateProvince: ").append(toIndentedString(stateProvince)).append("\n");
        sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
