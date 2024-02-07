package org.mifos.connector.channel.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.mifos.connector.common.operations.type.TransferStatus;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OpsTxnResponseDTO {

    private Long id;
    private Long workflowInstanceKey;
    private String transactionId;
    private Date startedAt;
    private Date completedAt;
    private TransferStatus status;
    private String statusDetail;
    private String payeeDfspId;
    private String payeePartyId;
    private String payeePartyIdType;
    private BigDecimal payeeFee;
    private String payeeFeeCurrency;
    private String payeeQuoteCode;
    private String payerDfspId;
    private String payerPartyId;
    private String payerPartyIdType;
    private BigDecimal payerFee;
    private String payerFeeCurrency;
    private String payerQuoteCode;
    private BigDecimal amount;
    private String currency;
    private String direction;
    private String errorInformation;
    private String batchId;
    private String clientCorrelationId;

    public static OpsTxnResponseDTO createInstance(
            Long id,
            Long workflowInstanceKey,
            String transactionId,
            Date startedAt,
            Date completedAt,
            TransferStatus status,
            String statusDetail,
            String payeeDfspId,
            String payeePartyId,
            String payeePartyIdType,
            BigDecimal payeeFee,
            String payeeFeeCurrency,
            String payeeQuoteCode,
            String payerDfspId,
            String payerPartyId,
            String payerPartyIdType,
            BigDecimal payerFee,
            String payerFeeCurrency,
            String payerQuoteCode,
            BigDecimal amount,
            String currency,
            String direction,
            String errorInformation,
            String batchId,
            String clientCorrelationId) {

        OpsTxnResponseDTO response = new OpsTxnResponseDTO();
        response.id = id;
        response.workflowInstanceKey = workflowInstanceKey;
        response.transactionId = transactionId;
        response.startedAt = startedAt;
        response.completedAt = completedAt;
        response.status = status;
        response.statusDetail = statusDetail;
        response.payeeDfspId = payeeDfspId;
        response.payeePartyId = payeePartyId;
        response.payeePartyIdType = payeePartyIdType;
        response.payeeFee = payeeFee;
        response.payeeFeeCurrency = payeeFeeCurrency;
        response.payeeQuoteCode = payeeQuoteCode;
        response.payerDfspId = payerDfspId;
        response.payerPartyId = payerPartyId;
        response.payerPartyIdType = payerPartyIdType;
        response.payerFee = payerFee;
        response.payerFeeCurrency = payerFeeCurrency;
        response.payerQuoteCode = payerQuoteCode;
        response.amount = amount;
        response.currency = currency;
        response.direction = direction;
        response.errorInformation = errorInformation;
        response.batchId = batchId;
        response.clientCorrelationId = clientCorrelationId;

        return response;
    }
}
