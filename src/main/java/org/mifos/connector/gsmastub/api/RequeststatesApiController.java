package org.mifos.connector.gsmastub.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mifos.connector.gsmastub.model.RequestGenericPatch;
import org.mifos.connector.gsmastub.model.RequestStateObject;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@RestController
public class RequeststatesApiController implements RequeststatesApi {

    private static final Logger log = LoggerFactory.getLogger(RequeststatesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RequeststatesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<RequestStateObject> requeststatesServerCorrelationIdGET(@Pattern(regexp="^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$") @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify a request state. Must be supplied as a UUID.", required=true, schema=@Schema()) @PathVariable("serverCorrelationId") String serverCorrelationId,@Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API." ,schema=@Schema()) @RequestHeader(value="X-Date", required=false) OffsetDateTime xDate,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server." ,schema=@Schema()) @RequestHeader(value="X-API-Key", required=false) String xAPIKey,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server." ,schema=@Schema()) @RequestHeader(value="X-Client-Id", required=false) String xClientId,@Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed." ,schema=@Schema()) @RequestHeader(value="X-Content-Hash", required=false) String xContentHash,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-1", required=false) String xUserCredential1,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-2", required=false) String xUserCredential2,@Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App." ,schema=@Schema()) @RequestHeader(value="X-Channel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<RequestStateObject>(objectMapper.readValue("{\n  \"pollLimit\" : 0.08008281904610115,\n  \"pendingReason\" : \"pendingReason\",\n  \"expiryTime\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"objectReference\" : \"objectReference\",\n  \"notificationMethod\" : \"callback\",\n  \"error\" : {\n    \"errordescription\" : \"errordescription\",\n    \"errorCategory\" : \"businessRule\",\n    \"errorParameters\" : [ {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    }, {\n      \"value\" : \"value\",\n      \"key\" : \"key\"\n    } ],\n    \"errorDateTime\" : \"2000-01-23T04:56:07.000+00:00\",\n    \"errorCode\" : \"genericError\"\n  },\n  \"serverCorrelationId\" : \"serverCorrelationId\",\n  \"status\" : \"pending\"\n}", RequestStateObject.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<RequestStateObject>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<RequestStateObject>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> requeststatesServerCorrelationIdPATCH(@Pattern(regexp="^[0-9A-Fa-f]{8}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{4}-[0-9A-Fa-f]{12}$") @Parameter(in = ParameterIn.PATH, description = "Path variable to uniquely identify a request state. Must be supplied as a UUID.", required=true, schema=@Schema()) @PathVariable("serverCorrelationId") String serverCorrelationId,@Parameter(in = ParameterIn.DEFAULT, description = "Represents the request body of a batch of generic Patch operation.", required=true, schema=@Schema()) @Valid @RequestBody List<RequestGenericPatch> body,@Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API." ,schema=@Schema()) @RequestHeader(value="X-Date", required=false) OffsetDateTime xDate,@Parameter(in = ParameterIn.HEADER, description = "Header parameter to uniquely identify the request. Must be supplied as a UUID." ,schema=@Schema()) @RequestHeader(value="X-CorrelationID", required=false) String xCorrelationID,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server." ,schema=@Schema()) @RequestHeader(value="X-API-Key", required=false) String xAPIKey,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server." ,schema=@Schema()) @RequestHeader(value="X-Client-Id", required=false) String xClientId,@Parameter(in = ParameterIn.HEADER, description = "SHA-256 hex digest of the request content (encrypted or plain). Applicable only if basic data integrity checking is to be performed." ,schema=@Schema()) @RequestHeader(value="X-Content-Hash", required=false) String xContentHash,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential. Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-1", required=false) String xUserCredential1,@Parameter(in = ParameterIn.HEADER, description = "The end-users encrypted security credential Should only be used when OAuth 2.0/OIDC authorisation framework has not been implemented by the API Provider." ,schema=@Schema()) @RequestHeader(value="X-User-Credential-2", required=false) String xUserCredential2,@Parameter(in = ParameterIn.HEADER, description = "String containing the channel that was used to originate the request. For example USSD, Web, App." ,schema=@Schema()) @RequestHeader(value="X-Channel", required=false) String xChannel) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
