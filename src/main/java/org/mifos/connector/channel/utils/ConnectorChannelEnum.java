package org.mifos.connector.channel.utils;

public enum ConnectorChannelEnum {


    PROCESS_DEFINITION_NOT_FOUND("01", "Process definition not found"),
    INTERNAL_SERVER_OCCURRED("01", "Internal Server Occurred");


    private final String value;
    private final String message;

    ConnectorChannelEnum(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return this.value;
    }

    public String getMessage() {
        return message;
    }
}
