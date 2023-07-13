package org.mifos.connector.channel.properties;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "bpmns")
public class TenantImplementationProperties {

    List<TenantImplementation> tenants;

    public List<TenantImplementation> getTenants() {
        return tenants;
    }

    public void setTenants(List<TenantImplementation> tenants) {
        this.tenants = tenants;
    }

}
