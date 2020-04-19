package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeebeClientConfiguration {

    public static final int ZEEBE_CLIENT_THREADS = 100;

    @Value("${zeebe.broker.contactpoint}")
    private String zeebeBrokerContactpoint;

    @Bean
    public ZeebeClient setup() {
        return ZeebeClient.newClientBuilder()
                .brokerContactPoint(zeebeBrokerContactpoint)
                .usePlaintext()
                .numJobWorkerExecutionThreads(ZEEBE_CLIENT_THREADS)
                .build();
    }
}
