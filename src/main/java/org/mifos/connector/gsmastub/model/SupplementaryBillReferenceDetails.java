package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * SupplementaryBillReferenceDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class SupplementaryBillReferenceDetails {

    @JsonProperty("paymentReferenceType")
    private String paymentReferenceType = null;

    @JsonProperty("paymentReferenceValue")
    private String paymentReferenceValue = null;

    public SupplementaryBillReferenceDetails paymentReferenceType(String paymentReferenceType) {
        this.paymentReferenceType = paymentReferenceType;
        return this;
    }

    /**
     * Identifies the type of the additional payment reference.
     *
     * @return paymentReferenceType
     **/
    @Schema(required = true, description = "Identifies the type of the additional payment reference.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getPaymentReferenceType() {
        return paymentReferenceType;
    }

    public void setPaymentReferenceType(String paymentReferenceType) {
        this.paymentReferenceType = paymentReferenceType;
    }

    public SupplementaryBillReferenceDetails paymentReferenceValue(String paymentReferenceValue) {
        this.paymentReferenceValue = paymentReferenceValue;
        return this;
    }

    /**
     * Identifies the value of the additional payment reference.
     *
     * @return paymentReferenceValue
     **/
    @Schema(required = true, description = "Identifies the value of the additional payment reference.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getPaymentReferenceValue() {
        return paymentReferenceValue;
    }

    public void setPaymentReferenceValue(String paymentReferenceValue) {
        this.paymentReferenceValue = paymentReferenceValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SupplementaryBillReferenceDetails supplementaryBillReferenceDetails = (SupplementaryBillReferenceDetails) o;
        return Objects.equals(this.paymentReferenceType, supplementaryBillReferenceDetails.paymentReferenceType)
                && Objects.equals(this.paymentReferenceValue, supplementaryBillReferenceDetails.paymentReferenceValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentReferenceType, paymentReferenceValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SupplementaryBillReferenceDetails {\n");

        sb.append("    paymentReferenceType: ").append(toIndentedString(paymentReferenceType)).append("\n");
        sb.append("    paymentReferenceValue: ").append(toIndentedString(paymentReferenceValue)).append("\n");
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
