package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import io.zeebe.client.impl.oauth.OAuthCredentialsProviderBuilder;
import io.zeebe.client.impl.oauth.OAuthCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZeebeClientConfiguration {

    @Value("${zeebe.broker.contactpoint}")
    private String zeebeBrokerContactpoint;

    @Value("${zeebe.client.max-execution-threads}")
    private int zeebeClientMaxThreads;

    @Value("${zeebe.broker.audience}")
    private String zeebeAudience;

    @Value("${zeebe.broker.clientId}")
    private String zeebeClientId;

    @Value("${zeebe.broker.clientSecret}")
    private String zeebeClientSecret;

    // public final OAuthCredentialsProvider cred = new OAuthCredentialsProviderBuilder()
    //             .audience("4ae8d42c-5f02-4e18-b4d4-f4d3d92fc824.zeebe.camunda.io")
    //             .clientId("ruU.ptno_wct_PXW~ngW4Pp0A0QWw.E1")
    //             .clientSecret("is20pecUw4p_9s3DakWcayYPdDn.GhWfmkm7jtznSErP.ed1iR.z.Qg97EBVz~Pc")
    //             .authorizationServerUrl("https://login.cloud.camunda.io/oauth/token")
    //             .build();

    @Bean
    public ZeebeClient setup() {

        OAuthCredentialsProvider cred = new OAuthCredentialsProviderBuilder()
                .audience("4ae8d42c-5f02-4e18-b4d4-f4d3d92fc824.zeebe.camunda.io")
                .clientId("ruU.ptno_wct_PXW~ngW4Pp0A0QWw.E1")
                .clientSecret("is20pecUw4p_9s3DakWcayYPdDn.GhWfmkm7jtznSErP.ed1iR.z.Qg97EBVz~Pc")
                // .authorizationServerUrl("https://login.cloud.camunda.io/oauth/token")
                .build();

        return ZeebeClient.newClientBuilder()
                .brokerContactPoint("4ae8d42c-5f02-4e18-b4d4-f4d3d92fc824.zeebe.camunda.io:443")
                .credentialsProvider(cred)
                // .usePlaintext()
                .numJobWorkerExecutionThreads(zeebeClientMaxThreads)
                .build();
    }
}
