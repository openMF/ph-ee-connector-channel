package org.mifos.connector.channel.camel.utils;

/**
 * The static class for getting the camel specific REST DSL paths for different http request type.
 * This class is specific to [BeneficiaryRouteBuilder] hence has a base path as [/channel/beneficiary]
 *
 * use case:
 * where [basePath] = "/channel/beneficiary"
 * Path.getPath("") >> "rest:GET:/channel/beneficiary"
 * Path.getPath("{beneficiaryId}") >> "rest:GET:/channel/beneficiary/{beneficiaryId}"
 * Path.postPath("") >> "rest:POST:/channel/beneficiary"
 * Path.deletePath("{beneficiaryId}") >> "rest:DELETE:/channel/beneficiary/{beneficiaryId}"
 */
public class CamelDslString {

    private final String basePath;

    public CamelDslString(String basePath) {
        this.basePath = basePath;
    }

    public String getCamelPath(String path, String httpRequestType) {
        if(path.isEmpty()) {
            return String.format("rest:%s:%s", httpRequestType, basePath);
        }
        return String.format("rest:%s:%s/%s", httpRequestType, basePath, path);
    }

    public String getPath(String path) {
        return getCamelPath(path, "GET");
    }

    public String postPath(String path) {
        return getCamelPath(path, "POST");
    }

    public String putPath(String path) {
        return getCamelPath(path, "PUT");
    }

    public String deletePath(String path) {
        return getCamelPath(path, "DELETE");
    }
}
