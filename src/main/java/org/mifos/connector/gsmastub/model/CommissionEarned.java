package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * CommissionEarned
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class CommissionEarned {

    @JsonProperty("commissionType")
    private String commissionType = null;

    @JsonProperty("commissionAmount")
    private String commissionAmount = null;

    @JsonProperty("commissionCurrency")
    private Currency commissionCurrency = null;

    public CommissionEarned commissionType(String commissionType) {
        this.commissionType = commissionType;
        return this;
    }

    /**
     * Defines the type of commission.
     *
     * @return commissionType
     **/
    @Schema(required = true, description = "Defines the type of commission.")
    @NotNull

    @Size(min = 1, max = 256)
    public String getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }

    public CommissionEarned commissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount;
        return this;
    }

    /**
     * Get commissionAmount
     *
     * @return commissionAmount
     **/
    @Schema(example = "15.21", required = true, description = "")
    @NotNull

    @Pattern(regexp = "^([0]|([1-9][0-9]{0,17}))([.][0-9]{0,3}[0-9])?$")
    @Size(min = 1, max = 23)
    public String getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(String commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public CommissionEarned commissionCurrency(Currency commissionCurrency) {
        this.commissionCurrency = commissionCurrency;
        return this;
    }

    /**
     * Get commissionCurrency
     *
     * @return commissionCurrency
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Currency getCommissionCurrency() {
        return commissionCurrency;
    }

    public void setCommissionCurrency(Currency commissionCurrency) {
        this.commissionCurrency = commissionCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommissionEarned commissionEarned = (CommissionEarned) o;
        return Objects.equals(this.commissionType, commissionEarned.commissionType)
                && Objects.equals(this.commissionAmount, commissionEarned.commissionAmount)
                && Objects.equals(this.commissionCurrency, commissionEarned.commissionCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commissionType, commissionAmount, commissionCurrency);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommissionEarned {\n");

        sb.append("    commissionType: ").append(toIndentedString(commissionType)).append("\n");
        sb.append("    commissionAmount: ").append(toIndentedString(commissionAmount)).append("\n");
        sb.append("    commissionCurrency: ").append(toIndentedString(commissionCurrency)).append("\n");
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
