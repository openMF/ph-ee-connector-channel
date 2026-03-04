package org.mifos.connector.channel.camel.routes;

import org.apache.camel.LoggingLevel;
import org.mifos.connector.channel.utils.CamelDslString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DmtOperationsRouteBuilder extends BaseErrorHandlerRoute {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String basePath = "/channel/dmtops";
    private final CamelDslString path = new CamelDslString(basePath);

    @Override
    void configureRoutes() {
        // Add Sender info
        // todo do request handling and trigger the zeebe message task [sender_info] with correlationId as
        // [transactionId]
        from(path.postPath("/senderinfo")).id("post-sender-info").log(LoggingLevel.INFO, "## CHANNEL -> Post sender info request: ${body}")
                .setBody(constant("This API will trigger the add sender path with sender info: ${body}"));

        // Verify OTP
        // todo do request handling and trigger the zeebe message task [otp] with correlationId as [transactionId]
        from(path.postPath("/otp/verify")).id("verify-otp").log(LoggingLevel.INFO, "## CHANNEL -> Verify OTP request: ${body}")
                .setBody(constant("This API will trigger the verify OTP path: ${body}"));

        // Resend OTP
        // todo do request handling and trigger the zeebe message task [otp] with correlationId as [transactionId]
        from(path.postPath("/otp/resend")).id("resend-otp").log(LoggingLevel.INFO, "## CHANNEL -> Resend OTP request: ${body}")
                .setBody(constant("This API will trigger the resend OTP path: ${body}"));

        // Beneficiary lookup
        // todo do request handling and trigger the zeebe message task [beneficiary_details] with correlationId as
        // [transactionId]
        from(path.postPath("/beneficiarydetails")).id("post-beneficiary-details")
                .log(LoggingLevel.INFO, "## CHANNEL -> Post beneficiary details request: ${body}")
                .setBody(constant("This API will trigger the beneficiary lookup path with beneficiary info: ${body}"));

    }

}
