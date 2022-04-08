package org.mifos.connector.channel.camel.routes;

import org.apache.camel.LoggingLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BeneficiaryRouteBuilder extends BaseErrorHandlerRoute {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void configure() {
        super.configure();
        routes();
    }

    private void routes() {
        // All Beneficiary
        // todo implement the redirection to the dmt-connector
        from(Path.getPath(""))
                .id("get-all-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Get all beneficiaries request: ${body}")
                .setBody(constant("This API will fetch all the beneficiaries"));

        // Get Beneficiary
        // todo implement the redirection to the dmt-connector
        from(Path.getPath("{beneficiaryId}"))
                .id("get-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Get beneficiaries request for id: ${header.beneficiaryId} with body: ${body}")
                .setBody(constant("This API will fetch the beneficiary based on beneficiary id: ${header.beneficiaryId}"));

        // Add Beneficiary
        // todo implement the redirection to the dmt-connector
        from(Path.postPath(""))
                .id("add-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Add beneficiary request: ${body}")
                .setBody(constant("This API will add the beneficiary: ${body}"));

        // Delete Beneficiary
        // todo implement the redirection to the dmt-connector
        from(Path.deletePath("{beneficiaryId}"))
                .id("delete-beneficiary")
                .log(LoggingLevel.INFO, "## CHANNEL -> Delete beneficiary request for id: ${header.beneficiaryId} with body: ${body}")
                .setBody(constant("This API will delete the beneficiary based on beneficiary id: ${header.beneficiaryId}"));
    }

    /**
     * The static class for getting the camel specific REST DSL paths for different http request type.
     * This class is specific to [BeneficiaryRouteBuilder] hence has a base path as [/channel/beneficiary]
     *
     * use case:
     * Path.getPath("") >> "rest:GET:/channel/beneficiary"
     * Path.getPath("{beneficiaryId}") >> "rest:GET:/channel/beneficiary/{beneficiaryId}"
     * Path.postPath("") >> "rest:POST:/channel/beneficiary"
     * Path.deletePath("{beneficiaryId}") >> "rest:DELETE:/channel/beneficiary/{beneficiaryId}"
     */
    static class Path {
        private static final String basePath = "/channel/beneficiary";


        private static String getCamelPath(String path, String httpRequestType) {
            if(path.isEmpty()) {
                return String.format("rest:%s:%s", httpRequestType, basePath);
            }
            return String.format("rest:%s:%s/%s", httpRequestType, basePath, path);
        }

        public static String getPath(String path) {
            return getCamelPath(path, "GET");
        }

        public static String postPath(String path) {
            return getCamelPath(path, "POST");
        }

        public static String putPath(String path) {
            return getCamelPath(path, "PUT");
        }

        public static String deletePath(String path) {
            return getCamelPath(path, "DELETE");
        }

    }

}
