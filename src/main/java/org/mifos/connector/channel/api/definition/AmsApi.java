package org.mifos.connector.channel.api.definition;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface AmsApi {

    @RequestMapping(value = "/channel/accounts/{IdentifierType}/{IdentifierId}/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

    ResponseEntity<String> getStatus(@RequestHeader("Platform-TenantId") String tenantId,
            @PathVariable("IdentifierType") String identifierType, @PathVariable("IdentifierId") String identifierId);

    @RequestMapping(value = "/channel/accounts/{IdentifierType}/{IdentifierId}/accountname", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAccountName(@RequestHeader("Platform-TenantId") String tenantId,
            @PathVariable("IdentifierType") String identifierType, @PathVariable("IdentifierId") String identifierId);

    @RequestMapping(value = "/channel/accounts/{IdentifierType}/{IdentifierId}/balance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAccountBalance(@RequestHeader("Platform-TenantId") String tenantId,
            @PathVariable("IdentifierType") String identifierType, @PathVariable("IdentifierId") String identifierId);

    @RequestMapping(value = "/channel/accounts/{IdentifierType}/{IdentifierId}/transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAccountTransactions(@RequestHeader("Platform-TenantId") String tenantId,
            @PathVariable("IdentifierType") String identifierType, @PathVariable("IdentifierId") String identifierId);

    @RequestMapping(value = "/channel/accounts/{IdentifierType}/{IdentifierId}/statemententries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> getAccountStatemententries(@RequestHeader("Platform-TenantId") String tenantId,
            @PathVariable("IdentifierType") String identifierType, @PathVariable("IdentifierId") String identifierId);

}
