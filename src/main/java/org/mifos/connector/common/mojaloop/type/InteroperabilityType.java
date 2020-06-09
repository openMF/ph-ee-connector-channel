/*
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 *
 *  https://mozilla.org/MPL/2.0/.
 */
package org.mifos.connector.common.mojaloop.type;

public enum InteroperabilityType {

    PARTIES_CONTENT_TYPE("application/vnd.interoperability.parties+json;version=1.0"),
    PARTIES_ACCEPT_TYPE("application/vnd.interoperability.parties+json;version=1.0"),
    QUOTES_CONTENT_TYPE("application/vnd.interoperability.quotes+json;version=1.0"),
    QUOTES_ACCEPT_TYPE("application/vnd.interoperability.quotes+json;version=1.0"),
    TRANSFERS_CONTENT_TYPE("application/vnd.interoperability.transfers+json;version=1.0"),
    TRANSFERS_ACCEPT_TYPE("application/vnd.interoperability.transfers+json;version=1.0"),
    TRANSACTIONS_CONTENT_TYPE("application/vnd.interoperability.transactionRequests+json;version=1.0"),
    TRANSACTIONS_ACCEPT_TYPE("application/vnd.interoperability.transactionRequests+json;version=1.0");

    private String headerValue;

    InteroperabilityType(String headerValue) {
        this.headerValue = headerValue;
    }

    public String headerValue() {
        return this.headerValue;
    }
}
