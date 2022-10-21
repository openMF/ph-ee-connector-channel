package org.mifos.connector.channel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

public interface JobApi {

    @PostMapping("/channel/job/resolve")
    Object job(@RequestBody String requestBody);
}
