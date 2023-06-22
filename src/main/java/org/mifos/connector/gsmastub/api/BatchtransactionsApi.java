/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.mifos.connector.gsmastub.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.mifos.connector.gsmastub.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@Validated
public interface BatchtransactionsApi extends BaseGsmaApi {

    @Operation(summary = "View Batch Completions", description = "This endpoint returns completed transactions for a specific batch", tags = {
            "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Represent a list of Batch Completions", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseBatchTransactionCompletion.class)))),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/batchtransactions/{batchId}/completions", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<ResponseBatchTransactionCompletion>> batchtransactionsBatchIdCompletionsGET(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify the transaction batch.", required = true, schema = @Schema()) @PathVariable("batchId") String batchId,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication.", schema = @Schema()) @RequestHeader(value = "X-User-Bearer", required = false) String xUserBearer,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId,
            @Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed.", schema = @Schema()) @RequestHeader(value = "X-Content-Hash", required = false) String xContentHash,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-1", required = false) String xUserCredential1,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-2", required = false) String xUserCredential2,
            @Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App.", schema = @Schema()) @RequestHeader(value = "X-Channel", required = false) String xChannel,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header.", schema = @Schema(allowableValues = {
                    "lei", "swiftbic",
                    "organisationid" })) @RequestHeader(value = "X-Account-Holding-Institution-Identifier-Type", required = false) String xAccountHoldingInstitutionIdentifierType,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier,
            @Parameter(in = ParameterIn.QUERY, description = "Supports pagination. If this is not supplied, then the server will apply a limit of 50 records returned for each request.", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
            @Parameter(in = ParameterIn.QUERY, description = "Supports pagination. This value will indicate the cursor position from where to retrieve the set of records. For example, a limit of 50 and offset of 10 will return records 11 to 60.", schema = @Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset,
            @Parameter(in = ParameterIn.QUERY, description = "Indicates the minimum creation date for which records should be returned.", schema = @Schema()) @Valid @RequestParam(value = "fromDateTime", required = false) OffsetDateTime fromDateTime,
            @Parameter(in = ParameterIn.QUERY, description = "Indicates the maximum creation date for which records should be returned.", schema = @Schema()) @Valid @RequestParam(value = "toDateTime", required = false) OffsetDateTime toDateTime);

    @Operation(summary = "View A Transaction Batch", description = "This endpoint returns the current status of a batch transaction", tags = {
            "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Represents a Batch Transaction response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseBatchTransaction.class))),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/batchtransactions/{batchId}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<ResponseBatchTransaction> batchtransactionsBatchIdGET(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify the transaction batch.", required = true, schema = @Schema()) @PathVariable("batchId") String batchId,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication.", schema = @Schema()) @RequestHeader(value = "X-User-Bearer", required = false) String xUserBearer,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId,
            @Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed.", schema = @Schema()) @RequestHeader(value = "X-Content-Hash", required = false) String xContentHash,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-1", required = false) String xUserCredential1,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-2", required = false) String xUserCredential2,
            @Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App.", schema = @Schema()) @RequestHeader(value = "X-Channel", required = false) String xChannel,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header.", schema = @Schema(allowableValues = {
                    "lei", "swiftbic",
                    "organisationid" })) @RequestHeader(value = "X-Account-Holding-Institution-Identifier-Type", required = false) String xAccountHoldingInstitutionIdentifierType,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier);

    @Operation(summary = "Update A Transaction Batch", description = "This endpoint updates a specific transaction batch. Only the batchStatus field can be modified.", tags = {
            "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Represents an Asynchronous response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestStateObject.class))),

            @ApiResponse(responseCode = "204", description = "An empty response is returned for a synchronous successful patch."),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/batchtransactions/{batchId}", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.PATCH)
    ResponseEntity<RequestStateObject> batchtransactionsBatchIdPATCH(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify the transaction batch.", required = true, schema = @Schema()) @PathVariable("batchId") String batchId,
            @Parameter(in = ParameterIn.DEFAULT, description = "Represents the request body of a batch of generic Patch operation.", required = true, schema = @Schema()) @Valid @RequestBody List<RequestGenericPatch> body,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication.", schema = @Schema()) @RequestHeader(value = "X-User-Bearer", required = false) String xUserBearer,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId,
            @Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed.", schema = @Schema()) @RequestHeader(value = "X-Content-Hash", required = false) String xContentHash,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-1", required = false) String xUserCredential1,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-2", required = false) String xUserCredential2,
            @Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App.", schema = @Schema()) @RequestHeader(value = "X-Channel", required = false) String xChannel,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header.", schema = @Schema(allowableValues = {
                    "lei", "swiftbic",
                    "organisationid" })) @RequestHeader(value = "X-Account-Holding-Institution-Identifier-Type", required = false) String xAccountHoldingInstitutionIdentifierType,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to uniquely identify the request. Must be supplied as a UUID.", schema = @Schema()) @RequestHeader(value = "X-CorrelationID", required = false) String xCorrelationID,
            @Parameter(in = ParameterIn.HEADER, description = "The URL supplied by the client that will be used to return the callback in the form of a HTTP PUT.", schema = @Schema()) @RequestHeader(value = "X-Callback-URL", required = false) String xCallbackURL);

    @Operation(summary = "View Batch Rejections", description = "This endpoint returns rejected transactions for a specific batch\"", tags = {
            "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Represents a Batch Transaction Rejection response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ResponseBatchTransactionRejection.class)))),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/batchtransactions/{batchId}/rejections", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<List<ResponseBatchTransactionRejection>> batchtransactionsBatchIdRejectionsGET(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify the transaction batch.", required = true, schema = @Schema()) @PathVariable("batchId") String batchId,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication.", schema = @Schema()) @RequestHeader(value = "X-User-Bearer", required = false) String xUserBearer,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId,
            @Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed.", schema = @Schema()) @RequestHeader(value = "X-Content-Hash", required = false) String xContentHash,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-1", required = false) String xUserCredential1,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-2", required = false) String xUserCredential2,
            @Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App.", schema = @Schema()) @RequestHeader(value = "X-Channel", required = false) String xChannel,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header.", schema = @Schema(allowableValues = {
                    "lei", "swiftbic",
                    "organisationid" })) @RequestHeader(value = "X-Account-Holding-Institution-Identifier-Type", required = false) String xAccountHoldingInstitutionIdentifierType,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier,
            @Parameter(in = ParameterIn.QUERY, description = "Supports pagination. If this is not supplied, then the server will apply a limit of 50 records returned for each request.", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
            @Parameter(in = ParameterIn.QUERY, description = "Supports pagination. This value will indicate the cursor position from where to retrieve the set of records. For example, a limit of 50 and offset of 10 will return records 11 to 60.", schema = @Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset,
            @Parameter(in = ParameterIn.QUERY, description = "Indicates the minimum creation date for which records should be returned.", schema = @Schema()) @Valid @RequestParam(value = "fromDateTime", required = false) OffsetDateTime fromDateTime,
            @Parameter(in = ParameterIn.QUERY, description = "Indicates the maximum creation date for which records should be returned.", schema = @Schema()) @Valid @RequestParam(value = "toDateTime", required = false) OffsetDateTime toDateTime);

    @Operation(summary = "Create A Transaction Batch", description = "Provided with a valid object representation, this endpoint allows for a new transaction batch to be created", tags = {
            "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Represents an Asynchronous response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = RequestStateObject.class))),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/batchtransactions", produces = { "application/json" }, consumes = {
            "application/json" }, method = RequestMethod.POST)
    ResponseEntity<RequestStateObject> batchtransactionsPOST(
            @Parameter(in = ParameterIn.DEFAULT, description = "Represents the request body of a batch of transactions.", required = true, schema = @Schema()) @Valid @RequestBody RequestBatchTransaction body,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to uniquely identify the request. Must be supplied as a UUID.", schema = @Schema()) @RequestHeader(value = "X-CorrelationID", required = false) String xCorrelationID,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication.", schema = @Schema()) @RequestHeader(value = "X-User-Bearer", required = false) String xUserBearer,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId,
            @Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed.", schema = @Schema()) @RequestHeader(value = "X-Content-Hash", required = false) String xContentHash,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-1", required = false) String xUserCredential1,
            @Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider.", schema = @Schema()) @RequestHeader(value = "X-User-Credential-2", required = false) String xUserCredential2,
            @Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App.", schema = @Schema()) @RequestHeader(value = "X-Channel", required = false) String xChannel,
            @Parameter(in = ParameterIn.HEADER, description = "The URL supplied by the client that will be used to return the callback in the form of a HTTP PUT.", schema = @Schema()) @RequestHeader(value = "X-Callback-URL", required = false) String xCallbackURL,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header.", schema = @Schema(allowableValues = {
                    "lei", "swiftbic",
                    "organisationid" })) @RequestHeader(value = "X-Account-Holding-Institution-Identifier-Type", required = false) String xAccountHoldingInstitutionIdentifierType,
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier);

}
