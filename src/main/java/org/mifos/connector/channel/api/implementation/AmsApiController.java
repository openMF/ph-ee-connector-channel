package org.mifos.connector.channel.api.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.ProducerTemplate;
import org.mifos.connector.channel.api.definition.AmsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AmsApiController implements AmsApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.connector-ams.host}")
    private String amsUrl;

    @Override
    public ResponseEntity<String> getStatus(String tenantId, String identifierType, String identifierId) {

        return fetchDetailsFromRestService(tenantId, "/ams/accounts/" + identifierType + "/" + identifierId + "/status");
    }

    @Override
    public ResponseEntity<String> getAccountName(String tenantId, String identifierType, String identifierId) {

        return fetchDetailsFromRestService(tenantId, "/ams/accounts/" + identifierType + "/" + identifierId + "/accountname");
    }

    @Override
    public ResponseEntity<String> getAccountBalance(String tenantId, String identifierType, String identifierId) {

        return fetchDetailsFromRestService(tenantId, "/ams/accounts/" + identifierType + "/" + identifierId + "/balance");
    }

    @Override
    public ResponseEntity<String> getAccountTransactions(String tenantId, String identifierType, String identifierId) {

        return fetchDetailsFromRestService(tenantId, "/ams/accounts/" + identifierType + "/" + identifierId + "/transactions");
    }

    @Override
    public ResponseEntity<String> getAccountStatemententries(String tenantId, String identifierType, String identifierId) {

        return fetchDetailsFromRestService(tenantId, "/ams/accounts/" + identifierType + "/" + identifierId + "/statemententries");
    }

    private ResponseEntity<String> fetchDetailsFromRestService(String tenantId, String url) {
        /*
         * if (tenantId == null || !dfspIds.contains(tenantId)) { throw new RuntimeException("Requested tenant " +
         * tenantId + " not configured in the connector!"); }
         */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Platform-TenantId", tenantId);

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<String> exchange = restTemplate.exchange(amsUrl + url, HttpMethod.GET, entity, String.class);

        return new ResponseEntity<>(exchange.getBody(), HttpStatus.OK);

    }

}
