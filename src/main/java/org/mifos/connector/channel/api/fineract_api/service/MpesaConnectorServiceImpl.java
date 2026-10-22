package org.mifos.connector.channel.api.fineract_api.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.mifos.connector.channel.api.fineract_api.dto.AccountLookupRequest;
import org.mifos.connector.channel.api.fineract_api.dto.AccountLookupResponse;
import org.mifos.connector.channel.api.fineract_api.dto.CreditAmountRequest;
import org.mifos.connector.channel.api.fineract_api.dto.CreditAmountResponse;
import org.mifos.connector.channel.api.fineract_api.dto.OAuthTokenResponse;
import org.mifos.connector.channel.api.fineract_api.dto.WithdrawHookRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author manoj Move this class to mepasa connector
 **/

@Service
public class MpesaConnectorServiceImpl implements MpesaConnectorService {

    public static final String TOKEN = "TOKEN";
    public static final String EXPIRES_AT = "EXPIRES_AT";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${mpesa.account.service.lookup.api.url}")
    private String accountLookUpUrl;
    @Value("${mpesa.account.service.credit.api.url}")
    private String accountCreditUrl;
    @Value("${mpesa.account.service.auth.token}")
    private String oauthToken;
    @Value("${mpesa.account.service.paymentTypeId}")
    private String paymentTypeId;

    @Value("${mpesa.account.service.auth.apiEnabled}")
    private String authApiEnabled;

    @Value("${mpesa.account.service.auth.api.url}")
    private String authApiUrl;

    @Value("${mpesa.account.service.auth.api.scope}")
    private String authScope;

    @Value("${mpesa.account.service.auth.api.userName}")
    private String authUserName;

    @Value("${mpesa.account.service.auth.api.password}")
    private String authPassword;

    private static final Map<String, Object> statcTokenMap = new HashMap<>();

    public AccountLookupResponse lookupAccount(AccountLookupRequest requestPayload) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(getAuthToken());

            HttpEntity<AccountLookupRequest> requestEntity = new HttpEntity<>(requestPayload, headers);

            ResponseEntity<AccountLookupResponse> responseEntity = restTemplate.exchange(accountLookUpUrl, HttpMethod.POST, requestEntity,
                    AccountLookupResponse.class);

            return responseEntity.getBody();

        } catch (Exception ex) {
            logger.error("Account lookup failed: ", ex);
            throw new RuntimeException("Account lookup failed", ex);
        }
    }

    private String getAuthToken() {
        logger.info("Fetching Access TOKEN");
        if (!"true".equals(authApiEnabled)) {
            logger.info("Fetching Access TOKEN: authApiEnabled {}, setting static token", authApiEnabled);
            return oauthToken;
        }

        if (statcTokenMap.get(TOKEN) != null && System.currentTimeMillis() < (Long) statcTokenMap.get(EXPIRES_AT)) {
            logger.info("Fetching Access TOKEN:  setting previous token");
            return (String) statcTokenMap.get(TOKEN);
        }

        logger.info("Fetching Access TOKEN:  Fetching new token");
        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(authUserName, authPassword);

        URI uri = UriComponentsBuilder.fromHttpUrl(authApiUrl).queryParam("scope", authScope).build().toUri();

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
        ResponseEntity<OAuthTokenResponse> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
                OAuthTokenResponse.class);

        OAuthTokenResponse token = responseEntity.getBody();
        statcTokenMap.put(TOKEN, token.getAccessToken());
        statcTokenMap.put(EXPIRES_AT, System.currentTimeMillis() + (token.getExpiresIn() * 1000));

        return (String) statcTokenMap.get(TOKEN);
    }

    public CreditAmountResponse creditAmount(CreditAmountRequest requestPayload) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(getAuthToken()); // Or: headers.add("Authorization", OAUTH_TOKEN);

            HttpEntity<CreditAmountRequest> requestEntity = new HttpEntity<>(requestPayload, headers);

            ResponseEntity<CreditAmountResponse> responseEntity = restTemplate.exchange(accountCreditUrl, HttpMethod.POST, requestEntity,
                    CreditAmountResponse.class);

            return responseEntity.getBody();

        } catch (Exception ex) {
            logger.error("Credit amount API call failed: ", ex);
            throw new RuntimeException("Credit amount API call failed", ex);
        }
    }

    @Override
    public void sendCreditRequest(String tenantId, WithdrawHookRequest request) {

        if (!paymentTypeId.equals(String.valueOf(request.getResponse().getChanges().getOrDefault("paymentTypeId", "0")))) {
            return;
        }

        AccountLookupRequest requestPayload = AccountLookupRequest.builder().tenantId(tenantId)
                .accountNo(request.getResponse().getResourceExternalId())
                .msisdn((String) request.getResponse().getChanges().getOrDefault("clientMob", "")).build();
        lookupAccount(requestPayload);

        CreditAmountRequest creditAmountRequest = CreditAmountRequest.builder().reference(request.getResponse().getResourceId().toString())
                .amount(request.getRequest().getTransactionAmount())
                .msisdn((String) request.getResponse().getChanges().getOrDefault("clientMob", "")).tenantId(tenantId)
                .accountNo(request.getResponse().getResourceExternalId()).build();
        creditAmount(creditAmountRequest);
    }

}
