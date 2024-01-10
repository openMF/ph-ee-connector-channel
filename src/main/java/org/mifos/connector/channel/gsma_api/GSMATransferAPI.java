package org.mifos.connector.channel.gsma_api;

import static org.mifos.connector.channel.camel.config.CamelProperties.REGISTERING_INSTITUTION_ID;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.common.gsma.dto.GSMATransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface GSMATransferAPI {

    @PostMapping("/channel/gsma/transfer")
    ResponseEntity<Object> gsmatransfer(@RequestHeader(value = "Platform-TenantId") String tenant,
            @RequestHeader(value = "X-CorrelationID", required = false) String correlationId,
            @RequestHeader(value = REGISTERING_INSTITUTION_ID, required = false) String registeringInstitutionId,
            @RequestBody GSMATransaction requestBody) throws JsonProcessingException;

}
