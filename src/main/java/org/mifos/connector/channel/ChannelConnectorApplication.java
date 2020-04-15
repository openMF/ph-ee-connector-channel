package org.mifos.connector.channel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChannelConnectorApplication {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    public static void main(String[] args) {
        SpringApplication.run(ChannelConnectorApplication.class, args);
    }
}
