package org.mifos.connector.gsmastub.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.*;
import org.mifos.connector.gsmastub.model.ResponseHeartbeat;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-09-27T11:46:46.417Z[GMT]")
@RestController
@Hidden
public class HeartbeatApiController implements HeartbeatApi {

    private static final Logger log = LoggerFactory.getLogger(HeartbeatApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public HeartbeatApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ResponseHeartbeat> heartbeatGET(@Parameter(in = ParameterIn.HEADER, description = "Header parameter to indicate the date and time that the message was originated. It is used for basic message integrity checks, to ensure the request is not stale. Note that the header was previously referenced as 'Date' in version 1.0 of the Mobile Money API." ,schema=@Schema()) @RequestHeader(value="X-Date", required=false) OffsetDateTime xDate,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's API key to the server." ,schema=@Schema()) @RequestHeader(value="X-API-Key", required=false) String xAPIKey,@Parameter(in = ParameterIn.HEADER, description = "Used to pass pre-shared client's identifier to the server." ,schema=@Schema()) @RequestHeader(value="X-Client-Id", required=false) String xClientId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<ResponseHeartbeat>(
                        objectMapper.readValue(
                                "{\n  \"plannedRestorationTime\" : \"2000-01-23T04:56:07.000+00:00\",\n " +
                                        " \"delay\" : 0.8008281904610115,\n  \"serviceStatus\" : \"available\"\n}", ResponseHeartbeat.class),
                        HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ResponseHeartbeat>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ResponseHeartbeat>(HttpStatus.OK);
    }

}
