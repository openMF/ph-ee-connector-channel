package org.mifos.connector.channel.api.fineract_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Getter
@Setter
public class CreditAmountResponse {

    @JsonProperty("Reference")
    private String reference;
    @JsonProperty("RRN")
    private String rrn;
    @JsonProperty("ResultCode")
    private String resultCode;
    @JsonProperty("ResultDesc")
    private String resultDesc;
    @JsonProperty("TenantID")
    private String tenantId;
}
