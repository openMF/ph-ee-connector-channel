package org.mifos.connector.channel.api.definition;

import com.fasterxml.jackson.core.*;
import org.mifos.connector.channel.GSMA_API.*;
import org.mifos.connector.channel.model.CollectionRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.*;

public interface CollectionApi {

    @PostMapping("/channel/collection")
    GsmaP2PResponseDto collection(@RequestHeader(value="Platform-TenantId") String tenant,
                                  @RequestHeader(value="X-CorrelationID") String correlationId,
                                  @RequestBody CollectionRequestDTO requestBody) throws ExecutionException, InterruptedException, JsonProcessingException;

}
