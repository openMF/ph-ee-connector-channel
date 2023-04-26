package org.mifos.connector.channel.model;

import lombok.*;
import org.mifos.connector.common.gsma.dto.CustomData;

import java.util.*;

@Getter
@Setter
public class CollectionRequestDTO {
    private ArrayList<Payer> payer;
    private Amount amount;
    private TransactionType transactionType;
    private List<CustomData> customData;
}
