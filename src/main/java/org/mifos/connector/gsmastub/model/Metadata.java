package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * Metadata
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class Metadata {

    @JsonProperty("key")
    private String key = null;

    @JsonProperty("value")
    private String value = null;

    public Metadata key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Identifies the type of additional field.
     *
     * @return key
     **/
    @Schema(required = true, description = "Identifies the type of additional field.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Metadata value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Identifies the value of the additional field.
     *
     * @return value
     **/
    @Schema(required = true, description = "Identifies the value of the additional field.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Metadata metadata = (Metadata) o;
        return Objects.equals(this.key, metadata.key) && Objects.equals(this.value, metadata.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Metadata {\n");

        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
