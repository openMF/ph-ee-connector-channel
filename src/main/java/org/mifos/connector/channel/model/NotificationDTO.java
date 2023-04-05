package org.mifos.connector.channel.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO {
    private String transactionId;
    private String account;
    private Long originDate;
    private String amount;
    private String phoneNumber;
    private String messageType;
    private String parentWorkflowId;
    private String deliveryMessage;
    private String tenant;
}
