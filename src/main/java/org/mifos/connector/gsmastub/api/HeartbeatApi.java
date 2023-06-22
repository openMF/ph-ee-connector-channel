/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.mifos.connector.gsmastub.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mifos.connector.gsmastub.model.ErrorObject;
import org.mifos.connector.gsmastub.model.ResponseHeartbeat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@Validated
public interface HeartbeatApi extends BaseGsmaApi {

    @Operation(summary = "Check API availability", description = "This endpoint returns the current status of the API", tags = {
            "Supporting" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Represents a Heartbeat response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseHeartbeat.class))),

            @ApiResponse(responseCode = "400", description = "Represents an Error Caused by the Violation of a Business Rule", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "401", description = "Represents an Error Caused by an Authorisation Failure", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "404", description = "Represents an Error Caused by a Failure to Identify the Target Resource", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "500", description = "Represents an Error Caused by a General Server-Side Issue", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))),

            @ApiResponse(responseCode = "503", description = "Represents an Error Caused by System Unavailability", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorObject.class))) })
    @RequestMapping(value = "/heartbeat", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<ResponseHeartbeat> heartbeatGET(
            @Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API.", schema = @Schema()) @RequestHeader(value = "X-Date", required = false) OffsetDateTime xDate,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server.", schema = @Schema()) @RequestHeader(value = "X-API-Key", required = false) String xAPIKey,
            @Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server.", schema = @Schema()) @RequestHeader(value = "X-Client-Id", required = false) String xClientId);

}
