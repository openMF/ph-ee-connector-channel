package org.mifos.connector.common.camel;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("${rest.authorization.enabled:false}")
public class AuthRouteBuilder extends ErrorHandlerRouteBuilder {

    public static final String AUTH_ERROR = "AUTH_ERROR";
    public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
    public static final String HAS_AUTHORITY = "HAS_AUTHORITY";

    public AuthRouteBuilder() {
        super.configure();
    }

    @Override
    public void configure() {
        from("direct:get-public-key")
                .id("get-public-key")
                .toD("rest:GET:/oauth/token_key?host={{rest.authorization.host}}");
    }
}