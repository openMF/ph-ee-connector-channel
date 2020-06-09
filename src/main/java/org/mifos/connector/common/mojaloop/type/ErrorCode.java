package org.mifos.connector.common.mojaloop.type;

import java.util.Arrays;

/**
 * Error code format:
 * (Higher-level category)(Lower-level category)(Sepcific error)
 *        1 digit                1 digit             2 digit
 */
public enum ErrorCode {

    // callback errors from mojaloop to fsp
    COMMUNICATION_ERROR(1000, "Generic communication error."),
    DESTINATION_COMMUNICATION_ERROR(1001, "Destination of the request failed to be reached. This usually indicates that a Peer FSP failed to respond from an intermediate entity."),

    // server side errors from fsp
    GENERIC_SERVER_ERROR(2000, "Generic server error to be used in order not to disclose information that may be considered private."),
    INTERNAL_SERVER_ERROR(2001, "Generic unexpected exception. This usually indicates a bug or unhandled error case."),
    NOT_IMPLEMENTED(2002, "Service requested is not supported by the server."),
    SERVICE_CURRENTLY_UNAVAILABLE(2003, "Service requested is currently unavailable on the server. This could be because maintenance is taking place, or because of a temporary failure."),
    SERVER_TIMED_OUT(2004, "Timeout has occurred, meaning the next Party in the chain did not send a callback in time. This could be because a timeout is set too low or because something took longer than expected."),
    SERVER_BUSY(2005, "Server is rejecting requests due to overloading. Try again later."),

    // (client) mojaloop errors
    GENERIC_CLIENT_ERROR(3000, "Generic client error, used in order not to disclose information that may be considered private."),
    UNACCEPTABLE_VERSION_REQUESTED(3001, "Client requested to use a protocol version which is not supported by the server."),
    UNKNOWN_URI(3002, "Provided URI was unknown to the server."),
    ADD_PARTY_INFORMATION_ERROR(3003, "Error occurred while adding or updating information regarding a Party."),
    GENERIC_VALIDATION_ERROR(3100, "Generic validation error to be used in order not to disclose information that may be considered private."),
    MALFORMED_SYNTAX(3101, "Format of the parameter is not valid. For example, amount set to 5.ABC. The error description field should specify which information element is erroneous."),
    MISSING_MANDATORY_ELEMENT(3102, "Mandatory element in the data model was missing."),
    TOO_MANY_ELEMENTS(3103, "Number of elements of an array exceeds the maximum number allowed."),
    TOO_LARGE_PAYLOAD(3104, "Size of the payload exceeds the maximum size."),
    INVALID_SIGNATURE(3105, "Some parameters have changed in the message, making the signature invalid. This may indicate that the message may have been modified maliciously."),
    MODIFIED_REQUEST(3106, "Request with the same ID has previously been processed in which the parameters are not the same."),
    MISSING_MANDATORY_EXTENSION_PARAMETER(3107, "Scheme-mandatory extension parameter was missing."),
    GENERIC_ID_NOT_FOUND(3200, "Generic ID error provided by the client."),
    DESTINATION_FSP_ERROR(3201, "Destination FSP does not exist or cannot be found."),
    PAYER_FSP_ID_NOT_FOUND(3202, "Provided Payer FSP ID not found."),
    PAYEE_FSP_ID_NOT_FOUND(3203, "Provided Payee FSP ID not found."),
    PARTY_NOT_FOUND(3204, "Party with the provided identifier, identifier type, and optional sub id or type was not found."),
    QUOTE_ID_NOT_FOUND(3205, "Provided Quote ID was not found on the server."),
    TRANSACTION_REQUEST_ID_NOT_FOUND(3206, "Provided Transaction Request ID was not found on the server."),
    TRANSACTION_ID_NOT_FOUND(3207, "Provided Transaction ID was not found on the server."),
    TRANSFER_ID_NOT_FOUND(3208, "Provided Transfer ID was not found on the server."),
    BULK_QUOTE_ID_NOT_FOUND(3209, "Provided Bulk Quote ID was not found on the server."),
    BULK_TRANSFER_ID_NOT_FOUND(3210, "Provided Bulk Transfer ID was not found on the server."),
    GENERIC_EXPIRED_ERROR(3300, "Generic expired object error, to be used in order not to disclose information that may be considered private."),
    TRANSACTION_REQUEST_EXPIRED(3301, "Client requested to use a transaction request that has already expired."),
    QUOTE_EXPIRED(3302, "Client requested to use a quote that has already expired."),
    TRANSFER_EXPIRED(3303, "Client requested to use a transfer that has already expired."),

    // payer side business error
    GENERIC_PAYER_ERROR(4000, "Generic error related to the Payer or Payer FSP. Used for protecting information that may be considered private."),
    PAYER_FSP_INSUFFICIENT_LIQUIDITY(4001, "Payer FSP has insufficient liquidity to perform the transfer."),
    GENERIC_PAYER_REJECTION(4100, "Payer or Payer FSP rejected the request."),
    PAYER_REJECTED_TRANSACTION_REQUEST(4101, "Payer rejected the transaction request from the Payee."),
    PAYER_FSP_UNSUPPORTED_TRANSACTION_TYPE(4102, "Payer FSP does not support or rejected the requested transaction type"),
    PAYER_UNSUPPORTED_CURRENCY(4103, "Payer does not have an account which supports the requested currency."),
    PAYER_LIMIT_ERROR(4200, "Generic limit error, for example, the Payer is making more payments per day or per month than they are allowed to, or is making a payment which is larger than the allowed maximum per transaction."),
    PAYER_PERMISSION_ERROR(4300, "Generic permission error, the Payer or Payer FSP does not have the access rights to perform the service."),
    GENERIC_PAYER_BLOCKED_ERROR(4400, "Generic Payer blocked error; the Payer is blocked or has failed regulatory screenings."),

    // payee side business error
    GENERIC_PAYEE_ERROR(5000, "Generic error due to the Payer or Payer FSP, to be used in order not to disclose information that may be considered private."),
    PAYEE_FSP_INSUFFICIENT_LIQUIDITY(5001, "Payee FSP has insufficient liquidity to perform the transfer."),
    GENERIC_PAYEE_REJECTION(5100, "Payee or Payee FSP rejected the request."),
    PAYEE_REJECTED_QUOTE(5101, "Payee does not want to proceed with the financial transaction after receiving a quote."),
    PAYEE_FSP_UNSUPPORTED_TRANSACTION_TYPE(5102, "Payee FSP does not support or has rejected the requested transaction type."),
    PAYEE_FSP_REJECTED_QUOTE(5103, "Payee FSP does not want to proceed with the financial transaction after receiving a quote."),
    PAYEE_REJECTED_TRANSACTION(5104, "Payee rejected the financial transaction."),
    PAYEE_FSP_REJECTED_TRANSACTION(5105, "Payee FSP rejected the financial transaction."),
    PAYEE_UNSUPPORTED_CURRENCY(5106, "Payee does not have an account that supports the requested currency."),
    PAYEE_LIMIT_ERROR(5200, "Generic limit error, for example, the Payee is receiving more payments per day or per month than they are allowed to, or is receiving a payment that is larger than the allowed maximum per transaction."),
    PAYEE_PERMISSION_ERROR(5300, "Generic permission error, the Payee or Payee FSP does not have the access rights to perform the service."),
    GENERIC_PAYEE_BLOCKED_ERROR(5400, "Generic Payee Blocked error, the Payee is blocked or has failed regulatory screenings.");

    private int code;
    private String errorMessage;

    ErrorCode(int code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static ErrorCode fromCode(int code) {
        return Arrays.stream(values())
                .filter(ec -> ec.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can not get unknown errorCode: " + code));
    }
}