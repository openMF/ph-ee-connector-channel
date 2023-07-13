package org.mifos.connector.channel.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.mifos.connector.common.gsma.dto.CustomData;

@Getter
@Setter
public class CollectionRequestDTO {

    private ArrayList<Payer> payer;
    private Amount amount;
    private TransactionType transactionType;
    private List<CustomData> customData;
}
