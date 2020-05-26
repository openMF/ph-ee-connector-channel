package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;
import static org.mifos.connector.channel.camel.config.CamelProperties.ERROR_INFORMATION;
import static org.mifos.connector.channel.camel.config.CamelProperties.TRANSACTION_ID;
import static org.mifos.connector.common.mojaloop.type.ErrorCode.fromCode;

@Component
public class ZeebeWorkers {

    private static final int ZEEBE_WORKERS = 5;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZeebeClient zeebeClient;

    @Value("${zeebe.client.evenly-allocated-max-jobs}")
    private int workerMaxJobs;

    @PostConstruct
    public void setupWorkers() {
        zeebeClient.newWorker()
                .jobType("send-error-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());

                    Object errorInfoVariable = job.getVariablesAsMap().get(ERROR_INFORMATION);
                    if (errorInfoVariable != null) {
                        JSONObject errorInformation = new JSONObject((String)errorInfoVariable).getJSONObject("errorInformation");
                        int errorCode = Integer.parseInt(errorInformation.getString("errorCode"));
                        logger.error("Error occurred with code: {} type: {} message: {}",
                                errorCode,
                                fromCode(errorCode).name(),
                                errorInformation.getString("errorDescription"));
                    }

                    client.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                })
                .name("send-error-to-channel")
                .maxJobsActive(workerMaxJobs)
                .open();

        zeebeClient.newWorker()
                .jobType("send-success-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                    client.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                })
                .name("send-success-to-channel")
                .maxJobsActive(workerMaxJobs)
                .open();

        zeebeClient.newWorker()
                .jobType("notify-operator")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                    client.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                })
                .name("notify-operator")
                .maxJobsActive(workerMaxJobs)
                .open();

        zeebeClient.newWorker()
                .jobType("notify-ams-failure")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                    client.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                })
                .name("notify-ams-failure")
                .maxJobsActive(workerMaxJobs)
                .open();

        zeebeClient.newWorker()
                .jobType("send-unknown-to-channel")
                .handler((client, job) -> {
                    logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());

                    Map<String, Object> variables = job.getVariablesAsMap();
                    logger.info("Transfer {} response did not arrive after {} retries, operator decision required! Variables:\n{}",
                            variables.get(TRANSACTION_ID),
                            3, // TODO externalize bpmn expression variables
                            variables.keySet().stream()
                            .sorted(naturalOrder())
                            .map(k -> k + " -- " + variables.get(k))
                            .collect(Collectors.joining("\n"))
                    );

                    client.newCompleteCommand(job.getKey())
                            .send()
                            .join();
                })
                .name("send-unknown-to-channel")
                .maxJobsActive(workerMaxJobs)
                .open();
    }
}