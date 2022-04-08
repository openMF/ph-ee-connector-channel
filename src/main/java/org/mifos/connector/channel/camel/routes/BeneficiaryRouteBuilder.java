package org.mifos.connector.channel.camel.routes;

import org.apache.camel.LoggingLevel;
import org.mifos.connector.channel.camel.utils.CamelDslString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryRouteBuilder extends BaseErrorHandlerRoute {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String basePath = "/channel/beneficiary";
    private final CamelDslString path = new CamelDslString(basePath);

    @Override
    void configureRoutes() {
        // All Beneficiary
        // todo implement the redirection to the dmt-connector
        from(path.getPath(""))
                .id("get-all-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Get all beneficiaries request: ${body}")
                .setBody(constant("This API will fetch all the beneficiaries"));

        // Get Beneficiary
        // todo implement the redirection to the dmt-connector
        from(path.getPath("{beneficiaryId}"))
                .id("get-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Get beneficiaries request for id: ${header.beneficiaryId} with body: ${body}")
                .setBody(constant("This API will fetch the beneficiary based on beneficiary id: ${header.beneficiaryId}"));

        // Add Beneficiary
        // todo implement the redirection to the dmt-connector
        from(path.postPath(""))
                .id("add-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Add beneficiary request: ${body}")
                .setBody(constant("This API will add the beneficiary: ${body}"));

        // Delete Beneficiary
        // todo implement the redirection to the dmt-connector
        from(path.deletePath("{beneficiaryId}"))
                .id("delete-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Delete beneficiary request for id: ${header.beneficiaryId} with body: ${body}")
                .setBody(constant("This API will delete the beneficiary based on beneficiary id: ${header.beneficiaryId}"));
    }

}
