package org.mifos.connector.common.camel;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static org.mifos.connector.common.camel.AuthRouteBuilder.AUTH_ERROR;
import static org.mifos.connector.common.camel.AuthRouteBuilder.HAS_AUTHORITY;
import static org.mifos.connector.common.camel.AuthRouteBuilder.UNKNOWN_ERROR;

@Component
@ConditionalOnExpression("${rest.authorization.enabled:false}")
public class AuthProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(AuthRouteBuilder.class);

    @Autowired
    @Lazy
    private JWTVerifier verifier;

    @Override
    public void process(Exchange e) {
        try {
            String authorization = e.getIn().getHeader("Authorization", String.class);
            if (authorization == null || authorization.length() < 1) {
                throw new JWTVerificationException("Invalid or empty Authorization header!");
            }

            String token = authorization.split("Bearer")[1].trim();
            DecodedJWT decoded = verifier.verify(token);
            String[] authorities = decoded.getClaim("authorities").asArray(String.class);
            String hasAuthority = e.getProperty(HAS_AUTHORITY, String.class);
            Stream.of(authorities).filter(hasAuthority::equals).findFirst().orElseThrow(() -> new JWTVerificationException("Invalid authorities!"));
        } catch (JWTVerificationException ex) {
            logger.error("Invalid Authorization!", ex);
            e.setProperty(AUTH_ERROR, true);
        } catch (Exception ex) {
            logger.error("Unknown error!", ex);
            e.setProperty(UNKNOWN_ERROR, true);
        }
    }
}
