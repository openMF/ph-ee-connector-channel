package org.mifos.connector.channel.api.fineract_api.dto;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Getter
@Setter
public class HookResponseData {

    private Long clientId;
    private Long savingsId;
    private Long resourceId;
    private Map<String, Object> changes;
    private String resourceExternalId;
}
