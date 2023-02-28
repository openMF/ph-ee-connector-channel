package org.mifos.connector.channel.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@ConfigurationProperties(prefix = "ams")
public class AMSProps {


    private List<AMS> groups;


    public List<AMS> getGroups() {
        return groups;
    }

    public void setGroups(List<AMS> groups) {
        this.groups = groups;
    }
    public static class AMS{
        private String identifier;
        private String value;

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
        public String getDefaultValue(){
            String value = null;
            if(getIdentifier().equals("default")){
                value = getValue();
            }
            return value;
        }
    }
}

