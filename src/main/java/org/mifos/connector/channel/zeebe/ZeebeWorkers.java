package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import org.json.JSONObject;
import org.mifos.connector.common.mojaloop.type.TransactionRequestState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.naturalOrder;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.ERROR_INFORMATION;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.TRANSACTION_ID;
import static org.mifos.connector.common.mojaloop.type.ErrorCode.fromCode;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.AUTH_VALIDATION_SUCCESS;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.PAYER_CONFIRMED;
import static org.mifos.connector.channel.zeebe.ZeebeVariables.TRANSACTION_STATE;
import static org.mifos.connector.channel.zeebe.ZeebeMessages.ACCEPT_QUOTE;

@Component
public class ZeebeWorkers {

    public static final String WORKER_SEND_ERROR_TO_CHANNEL = "send-error-to-channel-";
    public static final String WORKER_SEND_SUCCESS_TO_CHANNEL = "send-success-to-channel-";
    public static final String WORKER_NOTIFY_OPERATOR = "notify-operator-";
    public static final String WORKER_NOTIFY_AMS_FAILURE = "notify-ams-failure-";
    public static final String WORKER_SEND_UNKNOWN_TO_CHANNEL = "send-unknown-to-channel-";
    public static final String WORKER_PAYER_REQUEST_CONFIRM = "payer-request-confirm-";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZeebeClient zeebeClient;

    @Value("#{'${dfspids}'.split(',')}")
    private List<String> dfspids;

    @Value("${zeebe.client.evenly-allocated-max-jobs}")

    private int workerMaxJobs;

    @PostConstruct
    public void setupWorkers() {
        for (String dfspid : dfspids) {
            logger.info("## generating " + WORKER_SEND_ERROR_TO_CHANNEL + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_SEND_ERROR_TO_CHANNEL + dfspid)
                    .handler((client, job) -> {
                        logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());

                        Object errorInfoVariable = job.getVariablesAsMap().get(ERROR_INFORMATION);
                        if (errorInfoVariable != null) {
                            JSONObject errorInformation = new JSONObject((String) errorInfoVariable).getJSONObject("errorInformation");
                            int errorCode = Integer.parseInt(errorInformation.getString("errorCode"));
                            logger.error("Error occurred with code: {} type: {} message: {}",
                                    errorCode,
                                    fromCode(errorCode).name(),
                                    errorInformation.getString("errorDescription"));
                        }

                        client.newCompleteCommand(job.getKey())
                                .send()
                        ;
                    })
                    .name(WORKER_SEND_ERROR_TO_CHANNEL + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();

            logger.info("## generating " + WORKER_SEND_SUCCESS_TO_CHANNEL + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_SEND_SUCCESS_TO_CHANNEL + dfspid)
                    .handler((client, job) -> {
                        logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                        client.newCompleteCommand(job.getKey())
                                .send()
                        ;
                    })
                    .name(WORKER_SEND_SUCCESS_TO_CHANNEL + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();

            logger.info("## generating " + WORKER_NOTIFY_OPERATOR + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_NOTIFY_OPERATOR + dfspid)
                    .handler((client, job) -> {
                        logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                        client.newCompleteCommand(job.getKey())
                                .send()
                        ;
                    })
                    .name(WORKER_NOTIFY_OPERATOR + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();

            logger.info("## generating " + WORKER_NOTIFY_AMS_FAILURE + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_NOTIFY_AMS_FAILURE + dfspid)
                    .handler((client, job) -> {
                        logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                        client.newCompleteCommand(job.getKey())
                                .send()
                        ;
                    })
                    .name(WORKER_NOTIFY_AMS_FAILURE + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();

            logger.info("## generating " + WORKER_SEND_UNKNOWN_TO_CHANNEL + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_SEND_UNKNOWN_TO_CHANNEL + dfspid)
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
                        ;
                    })
                    .name(WORKER_SEND_UNKNOWN_TO_CHANNEL + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();

            logger.info("## generating " + WORKER_PAYER_REQUEST_CONFIRM + "{} zeebe worker", dfspid);
            zeebeClient.newWorker()
                    .jobType(WORKER_PAYER_REQUEST_CONFIRM + dfspid)
                    .handler((client, job) -> {
                        logger.info("Job '{}' started from process '{}' with key {}", job.getType(), job.getBpmnProcessId(), job.getKey());
                        Map<String, Object> variables = new HashMap<>();
                        variables.put(PAYER_CONFIRMED, true);
                        // TODO these should be somewhere else
                        variables.put(AUTH_VALIDATION_SUCCESS, true);
                        variables.put(TRANSACTION_STATE, TransactionRequestState.ACCEPTED.name());

                        // TODO sum local and payee quote and send to customer

                        zeebeClient.newPublishMessageCommand()
                                .messageName(ACCEPT_QUOTE)
                                .correlationKey((String) job.getVariablesAsMap().get(TRANSACTION_ID))
                                .timeToLive(Duration.ofMillis(30000))
                                .send()
                        ;

                        client.newCompleteCommand(job.getKey())
                                .variables(variables)
                                .send()
                        ;
                    })
                    .name(WORKER_PAYER_REQUEST_CONFIRM + dfspid)
                    .maxJobsActive(workerMaxJobs)
                    .open();
        }
    }
}