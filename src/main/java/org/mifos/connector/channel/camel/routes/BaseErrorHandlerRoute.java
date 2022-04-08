package org.mifos.connector.channel.camel.routes;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.camel.Exchange;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mifos.connector.common.camel.ErrorHandlerRouteBuilder;

public abstract class BaseErrorHandlerRoute extends ErrorHandlerRouteBuilder {

    @Override
    public void configure() {
        super.configure();
        handleExceptions();
        configureRoutes();
    }

    abstract void configureRoutes();

    private void handleExceptions(){
        onException(BeanValidationException.class)
                .process(e -> {
                    JSONArray violations = new JSONArray();
                    e.getProperty(Exchange.EXCEPTION_CAUGHT, BeanValidationException.class).getConstraintViolations()
                            .forEach(v -> violations.put(v.getPropertyPath() + " --- " + v.getMessage()));
                    JSONObject response = new JSONObject();
                    response.put("violations", violations);
                    e.getIn().setBody(response.toString());
                    e.removeProperties("*");
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .stop();

        onException(InvalidFormatException.class)
                .process(e -> {
                    JSONArray violations = new JSONArray();
                    violations.put(e.getProperty(Exchange.EXCEPTION_CAUGHT, InvalidFormatException.class).getMessage());

                    JSONObject response = new JSONObject();
                    response.put("violations", violations);
                    e.getIn().setBody(response.toString());
                    e.removeProperties("*");
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .stop();
    }

}
