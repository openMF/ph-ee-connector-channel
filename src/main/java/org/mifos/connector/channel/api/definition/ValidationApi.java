package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.model.ValidationRequestDTO;
import org.mifos.connector.channel.model.ValidationResponseDTO;
import org.springframework.web.bind.annotation.*;

public interface ValidationApi {
    @PostMapping("/accounts/validate/{primaryIdentifierName}/{primaryIdentifierVal}")
    ValidationResponseDTO validation(@RequestBody ValidationRequestDTO validationRequestDTO,
                                     @PathVariable String primaryIdentifierName,
                                     @PathVariable String primaryIdentifierVal) throws JsonProcessingException;

}
