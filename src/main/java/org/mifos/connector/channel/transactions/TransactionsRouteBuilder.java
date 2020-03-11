package org.mifos.connector.channel.transactions;

import org.apache.camel.LoggingLevel;
import org.mifos.phee.common.camel.ErrorHandlerRouteBuilder;
import org.mifos.connector.channel.zeebe.ZeebeProcessStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TransactionsRouteBuilder extends ErrorHandlerRouteBuilder {

    @Value("${bpmn.flows.payment-transfer}")
    private String paymentTransferFlow;

    @Autowired
    private ZeebeProcessStarter zeebeProcessStarter;

    public TransactionsRouteBuilder() {
        super.configure();
    }

    @Override
    public void configure() {
        from("rest:POST:/channel/transactions")
                .id("inbound-payment-request")
                .log(LoggingLevel.INFO, "## channel -> hub inbound payment request")
                .process(exchange -> zeebeProcessStarter.startZeebeWorkflow(paymentTransferFlow, exchange.getIn().getBody(String.class), variables -> {
                }));
    }
}