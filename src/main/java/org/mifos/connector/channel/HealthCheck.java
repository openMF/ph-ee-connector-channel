package org.mifos.connector.channel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck extends RouteBuilder {

    @Override
    public void configure() {
        from("rest:GET:/")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
                .setBody(constant(""));
    }
}
