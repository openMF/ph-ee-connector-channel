package org.mifos.connector.common.camel;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
@ConditionalOnExpression("${rest.authorization.enabled:false}")
public class AuthConfig {

    @Bean
    @Lazy
    public JWTVerifier verifier(CamelContext camelContext, ProducerTemplate producerTemplate) throws Exception {
        Exchange exchange = new DefaultExchange(camelContext);
        producerTemplate.send("direct:get-public-key", exchange);
        JSONObject response = new JSONObject(exchange.getIn().getBody(String.class));
        String publicKeyContent = response.getString("value");
        publicKeyContent = publicKeyContent.replaceAll("\\n", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");
        KeyFactory kf = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyContent));
        RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(keySpecX509);
        return JWT.require(Algorithm.RSA256(pubKey)).build();
    }
}
