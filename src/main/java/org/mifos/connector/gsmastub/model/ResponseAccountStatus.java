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
 * ResponseAccountStatus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class ResponseAccountStatus {

    @JsonProperty("accountStatus")
    private AccountStatus accountStatus = null;

    @JsonProperty("subStatus")
    private String subStatus = null;

    @JsonProperty("lei")
    private String lei = null;

    public ResponseAccountStatus accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    /**
     * Get accountStatus
     *
     * @return accountStatus
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    @Size(min = 1, max = 256)
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public ResponseAccountStatus subStatus(String subStatus) {
        this.subStatus = subStatus;
        return this;
    }

    /**
     * Can be used to return a provider-specific status for the account.
     *
     * @return subStatus
     **/
    @Schema(description = "Can be used to return a provider-specific status for the account.")

    @Size(max = 256)
    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public ResponseAccountStatus lei(String lei) {
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
        ResponseAccountStatus responseAccountStatus = (ResponseAccountStatus) o;
        return Objects.equals(this.accountStatus, responseAccountStatus.accountStatus)
                && Objects.equals(this.subStatus, responseAccountStatus.subStatus) && Objects.equals(this.lei, responseAccountStatus.lei);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus, subStatus, lei);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseAccountStatus {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    subStatus: ").append(toIndentedString(subStatus)).append("\n");
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
