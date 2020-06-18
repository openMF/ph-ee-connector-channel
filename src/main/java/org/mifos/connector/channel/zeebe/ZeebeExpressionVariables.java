package org.mifos.connector.channel.zeebe;

public class ZeebeExpressionVariables {

    private ZeebeExpressionVariables() {
    }

    public static final String AUTH_RETRIES_LEFT = "authRetriesLeft";
    public static final String IS_AUTHORISATION_REQUIRED = "isAuthorisationRequired";
    public static final String IS_RTP_REQUEST = "isRtpRequest";
    public static final String OPERATOR_MANUAL_OVERRIDE = "operatorManualOverride"; // TODO validate in request?
    public static final String TENANT_ID = "tenantId";
}