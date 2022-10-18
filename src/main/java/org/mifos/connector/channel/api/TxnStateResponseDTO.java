package org.mifos.connector.channel.api;

import lombok.*;

@Getter
@Setter
public class TxnStateResponseDTO {
    private String transactionId;
    private String transferState;
}
