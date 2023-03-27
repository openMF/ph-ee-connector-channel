package org.mifos.connector.channel.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mifos.connector.common.gsma.dto.CustomData;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ValidationRequestDTO {
    @JsonProperty("primaryIdentifier")
    private CustomData primaryIdentifier;
    @JsonProperty("secondaryIdentifier")
    private CustomData secondaryIdentifier;
    @JsonProperty("customData")
    private List<CustomData> customData;
}
