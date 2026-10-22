package org.mifos.connector.channel.api.fineract_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author manoj
 **/

@Getter
@Setter
public class HookRequestData {

    private String transactionDate;
    private String transactionAmount;
    private int paymentTypeId;
    private String locale;
    private String dateFormat;
}
