package org.mifos.connector.common.mojaloop.type;

public enum MojaloopHeaders {

    FSPIOP_SOURCE("fspiop-source"),
    FSPIOP_DESTINATION("fspiop-destination");

    private String headerName;

    MojaloopHeaders(String headerName) {
        this.headerName = headerName;
    }

    public String headerName() {
        return this.headerName;
    }
}
