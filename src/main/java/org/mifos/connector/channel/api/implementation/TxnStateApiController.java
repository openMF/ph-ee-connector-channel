package org.mifos.connector.channel.api.implementation;

import static org.mifos.connector.channel.camel.config.CamelProperties.CLIENTCORRELATIONID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.TxnStateApi;
import org.mifos.connector.channel.api.service.TxnStateService;
import org.mifos.connector.channel.model.TxnStateResponseDTO;
import org.mifos.connector.channel.utils.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TxnStateApiController implements TxnStateApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    TxnStateService service;

    @Override
    public TxnStateResponseDTO txnState(String tenant, String correlationId, String requestType) throws JsonProcessingException {
        Headers headers = new Headers.HeaderBuilder().addHeader("Platform-TenantId", tenant).addHeader("requestType", requestType)
                .addHeader(CLIENTCORRELATIONID, correlationId).build();
        /*
         * TODO : Remove this camel route Exchange exchange =
         * SpringWrapperUtil.getDefaultWrappedExchange(producerTemplate.getCamelContext(), headers, null);
         * producerTemplate.send("direct:get-txnState-correlationId", exchange); String body =
         * exchange.getIn().getBody(String.class); return objectMapper.readValue(body, TxnStateResponseDTO.class);
         */
        TxnStateResponseDTO response = service.getTxnState(headers, correlationId, requestType);
        return response;
    }
}
