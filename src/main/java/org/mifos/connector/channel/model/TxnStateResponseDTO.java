package org.mifos.connector.channel.model;

import lombok.*;

@Getter
@Setter
public class TxnStateResponseDTO {
    private String transactionId;
    private String transferState;
}
