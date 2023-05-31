package org.mifos.connector.channel.camel.config;

public class CamelProperties {

    private CamelProperties() {}

    public static final String AUTH_TYPE = "authType";
    public static final String BATCH_ID = "batchId";
    public static final String PARTY_LOOKUP_FAILED = "partyLookupFailed";
    public static final String CLIENTCORRELATIONID = "X-CorrelationID";
    public static final String BATCH_ID_HEADER = "X-BatchID";
    public static final String PLATFORM_TENANT_ID = "Platform-TenantId";

}
