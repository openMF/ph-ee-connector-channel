package org.mifos.connector.channel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface CollectionApi {

    @PostMapping("/channel/collection")
    String collection(@RequestHeader(value="Platform-TenantId") String tenant, String requestBody, HttpServletResponse response);

}
