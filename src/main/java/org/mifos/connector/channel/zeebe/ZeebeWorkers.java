package org.mifos.connector.channel.zeebe;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.zeebe.client.ZeebeClient;
import org.mifos.phee.common.mojaloop.dto.ErrorInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.mifos.connector.channel.camel.config.CamelProperties.ERROR_INFORMATION;

@Component
public class ZeebeWorkers {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZeebeClient zeebeClient;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void setupWorkers() {
        zeebeClient.newWorker()
                .jobType("send-error-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());

                    Object errorInfoVariable = job.getVariablesAsMap().get(ERROR_INFORMATION);
                    if (errorInfoVariable != null) {
                        ErrorInformation errorInformation = objectMapper.readValue((String) errorInfoVariable, ErrorInformation.class);
                        logger.error("Error occurred with code: {} message: {}", errorInformation.getErrorCode(), errorInformation.getErrorDescription());
                    }

                    client.newCompleteCommand(job.getKey())
                            .send();
                })
                .name("send-error-to-channel")
                .maxJobsActive(10)
                .open();

        zeebeClient.newWorker()
                .jobType("send-success-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                    client.newCompleteCommand(job.getKey())
                            .send();
                })
                .name("send-success-to-channel")
                .maxJobsActive(10)
                .open();

        zeebeClient.newWorker()
                .jobType("send-unknown-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                    client.newCompleteCommand(job.getKey())
                            .send();
                })
                .name("send-unknown-to-channel")
                .maxJobsActive(10)
                .open();
    }
}