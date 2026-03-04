package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.common.channel.dto.RegisterAliasRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface PartyRegistrationApi {

    @PostMapping("/channel/partyRegistration")
    void partyRegistration(@RequestHeader(value = "Platform-TenantId") String tenant, @RequestBody RegisterAliasRequestDTO requestBody)
            throws JsonProcessingException;
}
