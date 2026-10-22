package org.mifos.connector.channel.api.fineract_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Getter
@Setter
public class WithdrawHookRequest {

    private String createdByName;
    private HookRequestData request;
    private Long clientId;
    private Long createdBy;
    private Long officeId;
    private String entityName;
    private HookResponseData response;
    private String createdByFullName;
    private Long savingsId;
    private String actionName;
    private String timestamp;

}
