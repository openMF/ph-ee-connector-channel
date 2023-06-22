package org.mifos.connector.gsmastub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

/**
 * IdentityRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")

public class IdentityRequest {

    @JsonProperty("identityKyc")
    private Kyc identityKyc = null;

    @JsonProperty("accountRelationship")
    private AccountRelationship accountRelationship = null;

    @JsonProperty("kycVerificationStatus")
    private KycVerificationStatus kycVerificationStatus = null;

    @JsonProperty("kycVerificationEntity")
    private String kycVerificationEntity = null;

    @JsonProperty("kycLevel")
    private Integer kycLevel = null;

    @JsonProperty("customData")
    private CustomDataArray customData = null;

    public IdentityRequest identityKyc(Kyc identityKyc) {
        this.identityKyc = identityKyc;
        return this;
    }

    /**
     * Get identityKyc
     *
     * @return identityKyc
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public Kyc getIdentityKyc() {
        return identityKyc;
    }

    public void setIdentityKyc(Kyc identityKyc) {
        this.identityKyc = identityKyc;
    }

    public IdentityRequest accountRelationship(AccountRelationship accountRelationship) {
        this.accountRelationship = accountRelationship;
        return this;
    }

    /**
     * Get accountRelationship
     *
     * @return accountRelationship
     **/
    @Schema(required = true, description = "")
    @NotNull

    @Valid
    public AccountRelationship getAccountRelationship() {
        return accountRelationship;
    }

    public void setAccountRelationship(AccountRelationship accountRelationship) {
        this.accountRelationship = accountRelationship;
    }

    public IdentityRequest kycVerificationStatus(KycVerificationStatus kycVerificationStatus) {
        this.kycVerificationStatus = kycVerificationStatus;
        return this;
    }

    /**
     * Get kycVerificationStatus
     *
     * @return kycVerificationStatus
     **/
    @Schema(description = "")

    @Valid
    public KycVerificationStatus getKycVerificationStatus() {
        return kycVerificationStatus;
    }

    public void setKycVerificationStatus(KycVerificationStatus kycVerificationStatus) {
        this.kycVerificationStatus = kycVerificationStatus;
    }

    public IdentityRequest kycVerificationEntity(String kycVerificationEntity) {
        this.kycVerificationEntity = kycVerificationEntity;
        return this;
    }

    /**
     * Indicates the entity (e.g. mobile money agent) that has verified the KYC of the identity.
     *
     * @return kycVerificationEntity
     **/
    @Schema(description = "Indicates the entity (e.g. mobile money agent) that has verified the KYC of the identity.")

    @Size(max = 256)
    public String getKycVerificationEntity() {
        return kycVerificationEntity;
    }

    public void setKycVerificationEntity(String kycVerificationEntity) {
        this.kycVerificationEntity = kycVerificationEntity;
    }

    public IdentityRequest kycLevel(Integer kycLevel) {
        this.kycLevel = kycLevel;
        return this;
    }

    /**
     * Indicates the KYC level that the identity is associated with.
     *
     * @return kycLevel
     **/
    @Schema(example = "1", description = "Indicates the KYC level that the identity is associated with.")

    public Integer getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(Integer kycLevel) {
        this.kycLevel = kycLevel;
    }

    public IdentityRequest customData(CustomDataArray customData) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentityRequest identityRequest = (IdentityRequest) o;
        return Objects.equals(this.identityKyc, identityRequest.identityKyc)
                && Objects.equals(this.accountRelationship, identityRequest.accountRelationship)
                && Objects.equals(this.kycVerificationStatus, identityRequest.kycVerificationStatus)
                && Objects.equals(this.kycVerificationEntity, identityRequest.kycVerificationEntity)
                && Objects.equals(this.kycLevel, identityRequest.kycLevel) && Objects.equals(this.customData, identityRequest.customData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identityKyc, accountRelationship, kycVerificationStatus, kycVerificationEntity, kycLevel, customData);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IdentityRequest {\n");

        sb.append("    identityKyc: ").append(toIndentedString(identityKyc)).append("\n");
        sb.append("    accountRelationship: ").append(toIndentedString(accountRelationship)).append("\n");
        sb.append("    kycVerificationStatus: ").append(toIndentedString(kycVerificationStatus)).append("\n");
        sb.append("    kycVerificationEntity: ").append(toIndentedString(kycVerificationEntity)).append("\n");
        sb.append("    kycLevel: ").append(toIndentedString(kycLevel)).append("\n");
        sb.append("    customData: ").append(toIndentedString(customData)).append("\n");
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
