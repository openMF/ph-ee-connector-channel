package org.mifos.connector.channel.camel.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "identity.channel")
public class ClientProperties {

    private List<Client> clients = new ArrayList<>();

    public ClientProperties() {}

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getClient(String tenant) {
        return getClients().stream().filter(t -> t.getTenant().equals(tenant)).findFirst()
                .orElseThrow(() -> new RuntimeException("Client for tenant: " + tenant + ", not configuerd!"));
    }
}
