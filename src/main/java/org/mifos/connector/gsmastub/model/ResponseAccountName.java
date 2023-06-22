package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * ResponseAccountName
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseAccountName {

    @JsonProperty("name")
    private SubjectName name = null;

    @JsonProperty("lei")
    private String lei = null;

    public ResponseAccountName name(SubjectName name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @Schema(description = "")

    @Valid
    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public ResponseAccountName lei(String lei) {
        this.lei = lei;
        return this;
    }

    /**
     * Legal Entity Identifier.
     *
     * @return lei
     **/
    @Schema(example = "5493000IBP32UQZ0KL24", description = "Legal Entity Identifier.")

    @Pattern(regexp = "^[A-Z0-9]{4}00[A-Z0-9]{12}\\d{2}$")
    @Size(max = 20)
    public String getLei() {
        return lei;
    }

    public void setLei(String lei) {
        this.lei = lei;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResponseAccountName responseAccountName = (ResponseAccountName) o;
        return Objects.equals(this.name, responseAccountName.name) && Objects.equals(this.lei, responseAccountName.lei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lei);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseAccountName {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    lei: ").append(toIndentedString(lei)).append("\n");
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
