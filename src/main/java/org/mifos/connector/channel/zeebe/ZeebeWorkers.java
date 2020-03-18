package org.mifos.connector.channel.zeebe;

import io.zeebe.client.ZeebeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ZeebeWorkers {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ZeebeClient zeebeClient;

    @PostConstruct
    public void setupWorkers() {
        zeebeClient.newWorker()
                .jobType("send-error-to-channel")
                .handler((client, job) -> {
                    logger.info("send-error-to-channel task done");
                    client.newCompleteCommand(job.getKey()).send();
                }).open();

        zeebeClient.newWorker()
                .jobType("send-success-to-channel")
                .handler((client, job) -> {
                    logger.info("send-success-to-channel task done");
                    client.newCompleteCommand(job.getKey()).send();
                }).open();

        zeebeClient.newWorker()
                .jobType("send-unknown-to-channel")
                .handler((client, job) -> {
                    logger.info("send-unknown-to-channel task done");
                    client.newCompleteCommand(job.getKey()).send();
                }).open();
    }
}