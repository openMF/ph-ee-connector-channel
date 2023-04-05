package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.mifos.connector.channel.model.NotificationDTO;
import org.mifos.connector.channel.model.NotificationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

public interface NotificationApi {
    @PostMapping("/channel/sendNotifications")
    NotificationResponse notification(@RequestHeader(value = "Platform-TenantId") String tenant,
                                      @RequestHeader(value = CLIENTCORRELATIONID, required = false) String batchId,
                                      @RequestBody NotificationDTO requestBody) throws JsonProcessingException;
}
