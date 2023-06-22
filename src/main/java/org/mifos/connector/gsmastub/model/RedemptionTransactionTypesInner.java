package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * RedemptionTransactionTypesInner
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RedemptionTransactionTypesInner {

    @JsonProperty("transactionType")
    private Type transactionType = null;

    @JsonProperty("transactionSubtype")
    private String transactionSubtype = null;

    public RedemptionTransactionTypesInner transactionType(Type transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * Get transactionType
     *
     * @return transactionType
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Type getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Type transactionType) {
        this.transactionType = transactionType;
    }

    public RedemptionTransactionTypesInner transactionSubtype(String transactionSubtype) {
        this.transactionSubtype = transactionSubtype;
        return this;
    }

    /**
     * A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary
     * according to Provider.
     *
     * @return transactionSubtype
     **/
    @Schema(description = "A non-harmonised sub-classification of the type of transaction. Values are not fixed, and usage will vary according to Provider.")

    @Size(max = 256)
    public String getTransactionSubtype() {
        return transactionSubtype;
    }

    public void setTransactionSubtype(String transactionSubtype) {
        this.transactionSubtype = transactionSubtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedemptionTransactionTypesInner redemptionTransactionTypesInner = (RedemptionTransactionTypesInner) o;
        return Objects.equals(this.transactionType, redemptionTransactionTypesInner.transactionType)
                && Objects.equals(this.transactionSubtype, redemptionTransactionTypesInner.transactionSubtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionType, transactionSubtype);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RedemptionTransactionTypesInner {\n");

        sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
        sb.append("    transactionSubtype: ").append(toIndentedString(transactionSubtype)).append("\n");
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
