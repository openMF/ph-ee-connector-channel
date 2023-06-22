package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * An object that details the originating organisation of the request.
 */
@Schema(description = "An object that details the originating organisation of the request.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RequestingOrganisation {

    /**
     * Identifies the identifier type of the requesting organisation.
     */
    public enum RequestingOrganisationIdentifierTypeEnum {

        LEI("lei"),

        SWIFTBIC("swiftbic"),

        ORGANISATIONID("organisationid");

        private String value;

        RequestingOrganisationIdentifierTypeEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static RequestingOrganisationIdentifierTypeEnum fromValue(String text) {
            for (RequestingOrganisationIdentifierTypeEnum b : RequestingOrganisationIdentifierTypeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("requestingOrganisationIdentifierType")
    private RequestingOrganisationIdentifierTypeEnum requestingOrganisationIdentifierType = null;

    @JsonProperty("requestingOrganisationIdentifier")
    private String requestingOrganisationIdentifier = null;

    public RequestingOrganisation requestingOrganisationIdentifierType(
            RequestingOrganisationIdentifierTypeEnum requestingOrganisationIdentifierType) {
        this.requestingOrganisationIdentifierType = requestingOrganisationIdentifierType;
        return this;
    }

    /**
     * Identifies the identifier type of the requesting organisation.
     *
     * @return requestingOrganisationIdentifierType
     **/
    @Schema(required = true, description = "Identifies the identifier type of the requesting organisation.")
    @NotNull

    public RequestingOrganisationIdentifierTypeEnum getRequestingOrganisationIdentifierType() {
        return requestingOrganisationIdentifierType;
    }

    public void setRequestingOrganisationIdentifierType(RequestingOrganisationIdentifierTypeEnum requestingOrganisationIdentifierType) {
        this.requestingOrganisationIdentifierType = requestingOrganisationIdentifierType;
    }

    public RequestingOrganisation requestingOrganisationIdentifier(String requestingOrganisationIdentifier) {
        this.requestingOrganisationIdentifier = requestingOrganisationIdentifier;
        return this;
    }

    /**
     * Contains the requesting organisation identifier.
     *
     * @return requestingOrganisationIdentifier
     **/
    @Schema(required = true, description = "Contains the requesting organisation identifier.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getRequestingOrganisationIdentifier() {
        return requestingOrganisationIdentifier;
    }

    public void setRequestingOrganisationIdentifier(String requestingOrganisationIdentifier) {
        this.requestingOrganisationIdentifier = requestingOrganisationIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestingOrganisation requestingOrganisation = (RequestingOrganisation) o;
        return Objects.equals(this.requestingOrganisationIdentifierType, requestingOrganisation.requestingOrganisationIdentifierType)
                && Objects.equals(this.requestingOrganisationIdentifier, requestingOrganisation.requestingOrganisationIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestingOrganisationIdentifierType, requestingOrganisationIdentifier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestingOrganisation {\n");

        sb.append("    requestingOrganisationIdentifierType: ").append(toIndentedString(requestingOrganisationIdentifierType)).append("\n");
        sb.append("    requestingOrganisationIdentifier: ").append(toIndentedString(requestingOrganisationIdentifier)).append("\n");
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
