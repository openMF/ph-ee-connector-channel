package org.mifos.connector.channel.api;

import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.support.DefaultExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
@RestController
public class WorkflowApiController implements WorkflowApi{

    @Autowired
    private ProducerTemplate producerTemplate;

    @Override
    public Object workflow(String requestBody){
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:post-workflow-resolve", exchange);

        return exchange.getIn().getBody();
    }

    @Override
    public Object workflowKey(String workflowInstanceKey){
        Exchange exchange = new DefaultExchange(producerTemplate.getCamelContext());
        producerTemplate.send("direct:post-workflow-instanceKey-cancel", exchange);

        return exchange.getIn().getBody();
    }
}
