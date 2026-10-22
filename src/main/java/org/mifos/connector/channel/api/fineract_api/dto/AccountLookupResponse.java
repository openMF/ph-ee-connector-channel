package org.mifos.connector.channel.api.fineract_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Getter
@Setter
public class AccountLookupResponse {

    @JsonProperty("KYCName")
    private String kycName;
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseDesc")
    private String responseDesc;
}
