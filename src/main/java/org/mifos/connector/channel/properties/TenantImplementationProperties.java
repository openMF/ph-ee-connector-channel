package org.mifos.connector.channel.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.List;

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


