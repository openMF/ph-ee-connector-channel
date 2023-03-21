package org.mifos.connector.channel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationResponseDTO {
    public String transaction_id;
    public boolean reconciled;
    @JsonProperty("AMS")
    public String AMS;
}
