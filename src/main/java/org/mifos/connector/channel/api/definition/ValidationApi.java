package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.model.ValidationRequestDTO;
import org.mifos.connector.channel.model.ValidationResponseDTO;
import org.springframework.web.bind.annotation.*;

import static org.apache.camel.Exchange.CONTENT_TYPE;

public interface ValidationApi {
    @PostMapping("/accounts/validate/{primaryIdentifierName}/{primaryIdentifierVal}")
    ValidationResponseDTO validation(
            @RequestHeader("amsUrl") String amsUrl,
            @RequestHeader("amsName") String amsName,
            @RequestHeader("accountHoldingInstitutionId") String accountHoldingInstitutionId,
            @RequestHeader(CONTENT_TYPE) String CONTENT_TYPE_VAL,
            @RequestBody ValidationRequestDTO validationRequestDTO,
                                     @PathVariable String primaryIdentifierName,
                                     @PathVariable String primaryIdentifierVal) throws JsonProcessingException;

}
