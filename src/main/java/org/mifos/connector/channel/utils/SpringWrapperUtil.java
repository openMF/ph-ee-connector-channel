package org.mifos.connector.channel.utils;

import org.apache.camel.*;
import org.apache.camel.support.*;

import java.util.*;

public class SpringWrapperUtil {
    public static Exchange getDefaultWrappedExchange(CamelContext camelContext,
                                                     Headers headers,
                                                     String body) {
        Exchange exchange = new DefaultExchange(camelContext);

        // Setting headers
        for (String headerKey : headers.getHeadersKey()) {
            exchange.getIn().setHeader(headerKey, headers.get(headerKey));
        }

        // Setting body if available
        if (body != null) {
            try {
                exchange.getIn().setBody((String) body);
            } catch (Exception e) {
                exchange.getIn().setBody(body);

            }
        }
        return exchange;
    }
}
