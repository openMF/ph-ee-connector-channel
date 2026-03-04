package org.mifos.connector.channel.properties;

import java.util.HashMap;

public class TenantImplementation {

    String id;
    HashMap<String, String> flows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getFlows() {
        return flows;
    }

    public void setFlows(HashMap<String, String> flows) {
        this.flows = flows;
    }

}
