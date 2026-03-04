package org.mifos.connector.channel.api.definition;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface WorkflowApi {

    @PostMapping("/channel/workflow/resolve")
    Object workflow(@RequestBody String requestBody);

    @PostMapping("/channel/workflow/{workflowInstanceKey}/cancel")
    Object workflowKey(@PathVariable String workflowInstanceKey);
}
