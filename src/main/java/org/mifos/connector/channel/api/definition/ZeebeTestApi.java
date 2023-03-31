package org.mifos.connector.channel.api.definition;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ZeebeTestApi {

    @PostMapping("/channel/workflow/zeebetest")
    Object workflow(@RequestBody String requestBody);
}
