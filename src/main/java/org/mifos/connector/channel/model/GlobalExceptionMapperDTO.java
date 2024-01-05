package org.mifos.connector.channel.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalExceptionMapperDTO {
    private String responseCode;
    private String responseDescription;
}
