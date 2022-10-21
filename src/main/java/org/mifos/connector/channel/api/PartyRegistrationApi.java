package org.mifos.connector.channel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface PartyRegistrationApi {

    @PostMapping("/channel/partyRegistration")
    Object partyRegistration(@RequestHeader(value="Platform-TenantId") String tenant, @RequestBody String requestBody);
}
