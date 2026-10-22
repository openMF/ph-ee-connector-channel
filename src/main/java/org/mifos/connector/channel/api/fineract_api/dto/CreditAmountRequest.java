package org.mifos.connector.channel.api.fineract_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Setter
@Getter
@Builder
public class CreditAmountRequest {

    @JsonProperty("Reference")
    private String reference;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("MSISDN")
    private String msisdn;
    @JsonProperty("TenantID")
    private String tenantId;
    @JsonProperty("AccountNO")
    private String accountNo;
}
