package org.mifos.connector.channel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface JobApi {

    @PostMapping("/channel/job/resolve")
    Object job(@RequestBody String requestBody);
}