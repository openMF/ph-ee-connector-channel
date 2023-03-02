package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.common.channel.dto.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface PartyRegistrationApi {

    @PostMapping("/channel/partyRegistration")
    void partyRegistration(@RequestHeader(value="Platform-TenantId") String tenant,
                             @RequestBody RegisterAliasRequestDTO requestBody)
            throws JsonProcessingException;
}
