package org.mifos.connector.gsmastub.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mifos.connector.gsmastub.model.ResponseStatementEntries;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@RestController
public class StatemententriesApiController implements StatemententriesApi {

    private static final Logger log = LoggerFactory.getLogger(StatemententriesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public StatemententriesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseStatementEntries> statemententriesTransactionReferenceGET(@Size(min=1,max=256) @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify the transaction.", required=true, schema=@Schema()) @PathVariable("transactionReference") String transactionReference,@Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API." ,schema=@Schema()) @RequestHeader(value="X-Date", required=false) OffsetDateTime xDate,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server." ,schema=@Schema()) @RequestHeader(value="X-API-Key", required=false) String xAPIKey,@Parameter(in = ParameterIn.HEADER, description = "Used to pass user’s access token when OAuth 2.0/OIDC authorisation framework is used for end-user authentication." ,schema=@Schema()) @RequestHeader(value="X-User-Bearer", required=false) String xUserBearer,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server." ,schema=@Schema()) @RequestHeader(value="X-Client-Id", required=false) String xClientId,@Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed." ,schema=@Schema()) @RequestHeader(value="X-Content-Hash", required=false) String xContentHash,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-1", required=false) String xUserCredential1,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-2", required=false) String xUserCredential2,@Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App." ,schema=@Schema()) @RequestHeader(value="X-Channel", required=false) String xChannel,@Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the type of the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier header." ,schema=@Schema(allowableValues={ "lei", "swiftbic", "organisationid" }
)) @RequestHeader(value="X-Account-Holding-Institution-Identifier-Type", required=false) String xAccountHoldingInstitutionIdentifierType,@Parameter(in = ParameterIn.HEADER, description = "A header variable that identifies the account holding institution. This header is used to support request routing and should be used in conjunction with the X-Account-Holding-Institution-Identifier-Type header." ,schema=@Schema()) @RequestHeader(value="X-Account-Holding-Institution-Identifier", required=false) String xAccountHoldingInstitutionIdentifier) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseStatementEntries>(objectMapper.readValue("{\n  \"debitParty\" : [ null, null, null, null, null, null, null, null, null, null ],\n  \"amount\" : \"15.21\",\n  \"transactionReference\" : \"transactionReference\",\n  \"transactionStatus\" : \"transactionStatus\",\n  \"customData\" : [ {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  }, {\n    \"value\" : \"value\",\n    \"key\" : \"key\"\n  } ],\n  \"dateModified\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"descriptionText\" : \"descriptionText\",\n  \"creationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"displayType\" : \"displayType\",\n  \"modificationDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"dateCreated\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"transactionReceipt\" : \"transactionReceipt\",\n  \"requestDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"currency\" : \"AED\",\n  \"creditParty\" : [ {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  }, {\n    \"value\" : \"+33555123456\",\n    \"key\" : \"msisdn\"\n  } ]\n}", ResponseStatementEntries.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseStatementEntries>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseStatementEntries>(HttpStatus.OK);
    }

}
