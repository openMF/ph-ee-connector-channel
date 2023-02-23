package org.mifos.connector.channel.api;

import lombok.*;

import java.util.*;

@Getter
@Setter
public class CollectionRequestDTO {
    private ArrayList<Payer> payer;
    private Amount amount;
    private TransactionType transactionType;
}
