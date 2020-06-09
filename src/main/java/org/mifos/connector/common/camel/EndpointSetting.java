package org.mifos.connector.common.camel;

public class EndpointSetting {

    private String endpoint, authority;

    public EndpointSetting() {
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
