package org.mifos.connector.gsmastub.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import org.mifos.connector.gsmastub.model.RequestBillPayment;
import org.mifos.connector.gsmastub.model.ResponseBillPayment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@RestController
@Hidden
public class BillsApiController implements BillsApi {

    private static final Logger log = LoggerFactory.getLogger(BillsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public BillsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseBillPayment> abillsBillReferencePaymentsGET(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify a bill.", required = true, schema = @Schema()) @PathVariable("billReference") String billReference,
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
            @Parameter(in = ParameterIn.QUERY, description = "Indicates the maximum creation date for which records should be returned.", schema = @Schema()) @Valid @RequestParam(value = "toDateTime", required = false) OffsetDateTime toDateTime) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseBillPayment>(objectMapper.readValue(
                        "{\n  \"supplementaryBillReferenceDetails\" : [ {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  } ],\n  \"serviceProviderNotification\" : \"serviceProviderNotification\",\n  \"metadata\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"requestingOrganisation\" : \"requestingOrganisation\",\n  \"customData\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"paymentType\" : \"partialpayment\",\n  \"modificationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"billPaymentStatus\" : \"billPaymentStatus\",\n  \"amountPaid\" : \"15.21\",\n  \"customerReference\" : \"customerReference\",\n  \"requestDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"requestingOrganisationTransactionReference\" : \"requestingOrganisationTransactionReference\",\n  \"currency\" : \"AED\",\n  \"serviceProviderPaymentReference\" : \"serviceProviderPaymentReference\",\n  \"serviceProviderComment\" : \"serviceProviderComment\"\n}",
                        ResponseBillPayment.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseBillPayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseBillPayment>(HttpStatus.OK);
    }

    public ResponseEntity<ResponseBillPayment> billsBillReferencePaymentsPOST(
            @Size(min = 1, max = 256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify a bill.", required = true, schema = @Schema()) @PathVariable("billReference") String billReference,
            @Parameter(in = ParameterIn.DEFAULT, description = "Represents the request body of a bill payment.", required = true, schema = @Schema()) @Valid @RequestBody RequestBillPayment body,
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
            @Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header.", schema = @Schema()) @RequestHeader(value = "X-Account-Holding-Institution-Identifier", required = false) String xAccountHoldingInstitutionIdentifier) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseBillPayment>(objectMapper.readValue(
                        "{\n  \"supplementaryBillReferenceDetails\" : [ {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  }, {\n    \"paymentReferenceType\" : \"paymentReferenceType\",\n    \"paymentReferenceValue\" : \"paymentReferenceValue\"\n  } ],\n  \"serviceProviderNotification\" : \"serviceProviderNotification\",\n  \"metadata\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"requestingOrganisation\" : \"requestingOrganisation\",\n  \"customData\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"paymentType\" : \"partialpayment\",\n  \"modificationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"billPaymentStatus\" : \"billPaymentStatus\",\n  \"amountPaid\" : \"15.21\",\n  \"customerReference\" : \"customerReference\",\n  \"requestDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"requestingOrganisationTransactionReference\" : \"requestingOrganisationTransactionReference\",\n  \"currency\" : \"AED\",\n  \"serviceProviderPaymentReference\" : \"serviceProviderPaymentReference\",\n  \"serviceProviderComment\" : \"serviceProviderComment\"\n}",
                        ResponseBillPayment.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseBillPayment>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseBillPayment>(HttpStatus.OK);
    }

}
