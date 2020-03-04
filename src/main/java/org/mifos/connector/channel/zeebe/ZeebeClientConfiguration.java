package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeebeClientConfiguration {

    @Value("${zeebe.broker.contactpoint}")
    private String zeebeBrokerContactpoint;

    @Bean
    public ZeebeClient setup() {
        return ZeebeClient.newClientBuilder()
                .brokerContactPoint(zeebeBrokerContactpoint)
                .usePlaintext()
                .build();
    }
}
