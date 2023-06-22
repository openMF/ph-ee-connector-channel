package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/**
 * RequestAccount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class RequestAccount {

    @JsonProperty("accountIdentifiers")
    private AccountIdentifiersArray accountIdentifiers = null;

    @JsonProperty("identity")
    private IdentityRequestArray identity = null;

    @JsonProperty("accountType")
    private String accountType = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    @JsonProperty("fees")
    private FeesArray fees = null;

    @JsonProperty("registeringEntity")
    private String registeringEntity = null;

    @JsonProperty("requestDate")
    private OffsetDateTime requestDate = null;

    public RequestAccount accountIdentifiers(AccountIdentifiersArray accountIdentifiers) {
        this.accountIdentifiers = accountIdentifiers;
        return this;
    }

    /**
     * Get accountIdentifiers
     *
     * @return accountIdentifiers
     **/
    @Schema(description = "")

    @Valid
    public AccountIdentifiersArray getAccountIdentifiers() {
        return accountIdentifiers;
    }

    public void setAccountIdentifiers(AccountIdentifiersArray accountIdentifiers) {
        this.accountIdentifiers = accountIdentifiers;
    }

    public RequestAccount identity(IdentityRequestArray identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get identity
     *
     * @return identity
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public IdentityRequestArray getIdentity() {
        return identity;
    }

    public void setIdentity(IdentityRequestArray identity) {
        this.identity = identity;
    }

    public RequestAccount accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    /**
     * A non-harmonised field that indicates the type of the account.
     *
     * @return accountType
     **/
    @Schema(description = "A non-harmonised field that indicates the type of the account.")

    @Size(max = 256)
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public RequestAccount customData(CustomDataArray customData) {
        this.customData = customData;
        return this;
    }

    /**
     * Get customData
     *
     * @return customData
     **/
    @Schema(description = "")

    @Valid
    public CustomDataArray getCustomData() {
        return customData;
    }

    public void setCustomData(CustomDataArray customData) {
        this.customData = customData;
    }

    public RequestAccount fees(FeesArray fees) {
        this.fees = fees;
        return this;
    }

    /**
     * Get fees
     *
     * @return fees
     **/
    @Schema(description = "")

    @Valid
    public FeesArray getFees() {
        return fees;
    }

    public void setFees(FeesArray fees) {
        this.fees = fees;
    }

    public RequestAccount registeringEntity(String registeringEntity) {
        this.registeringEntity = registeringEntity;
        return this;
    }

    /**
     * The entity that registered the account, for example, a mobile money agent.
     *
     * @return registeringEntity
     **/
    @Schema(description = "The entity that registered the account, for example, a mobile money agent.")

    @Size(max = 256)
    public String getRegisteringEntity() {
        return registeringEntity;
    }

    public void setRegisteringEntity(String registeringEntity) {
        this.registeringEntity = registeringEntity;
    }

    public RequestAccount requestDate(OffsetDateTime requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    /**
     * The date and time of the request as supplied by the client.
     *
     * @return requestDate
     **/
    @Schema(description = "The date and time of the request as supplied by the client.")

    @Valid
    public OffsetDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(OffsetDateTime requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RequestAccount requestAccount = (RequestAccount) o;
        return Objects.equals(this.accountIdentifiers, requestAccount.accountIdentifiers)
                && Objects.equals(this.identity, requestAccount.identity) && Objects.equals(this.accountType, requestAccount.accountType)
                && Objects.equals(this.customData, requestAccount.customData) && Objects.equals(this.fees, requestAccount.fees)
                && Objects.equals(this.registeringEntity, requestAccount.registeringEntity)
                && Objects.equals(this.requestDate, requestAccount.requestDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountIdentifiers, identity, accountType, customData, fees, registeringEntity, requestDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RequestAccount {\n");

        sb.append("    accountIdentifiers: ").append(toIndentedString(accountIdentifiers)).append("\n");
        sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
        sb.append("    fees: ").append(toIndentedString(fees)).append("\n");
        sb.append("    registeringEntity: ").append(toIndentedString(registeringEntity)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
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
