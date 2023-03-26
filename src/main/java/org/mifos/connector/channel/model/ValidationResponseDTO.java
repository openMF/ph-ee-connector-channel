package org.mifos.connector.channel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponseDTO {
    @JsonProperty("transactionId")
    public String transactionId;
    @JsonProperty("accountHoldingInstitutionId")
    public String accountHoldingInstitutionId;
    @JsonProperty("amount")
    public String amount;
    @JsonProperty("currency")
    public String currency;
    @JsonProperty("msisdn")
    public String msisdn;
    @JsonProperty("reconciled")
    public boolean reconciled;
    @JsonProperty("amsName")
    public String amsName;
}