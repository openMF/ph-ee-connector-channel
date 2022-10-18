package org.mifos.connector.channel.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletResponse;

public interface WorkflowApi {

    @PostMapping("/channel/workflow/resolve")
    Object workflow(@RequestBody String requestBody);

    @PostMapping("/channel/workflow/{workflowInstanceKey}/cancel")
    Object workflowKey(@PathVariable String workflowInstanceKey);
}