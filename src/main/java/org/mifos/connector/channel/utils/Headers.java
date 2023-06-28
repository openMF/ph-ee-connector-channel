package org.mifos.connector.channel.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Headers {

    private Map<String, Object> headers;

    private Headers() {}

    private void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public Set<String> getHeadersKey() {
        return this.headers.keySet();
    }

    public Object get(String key) {
        return this.headers.get(key);
    }

    public static class HeaderBuilder {

        private Map<String, Object> headers = new HashMap<>();

        public HeaderBuilder addHeader(String key, Object value) {
            headers.put(key, value);
            return this;
        }

        public Headers build() {
            Headers headersClassInstance = new Headers();
            headersClassInstance.setHeaders(this.headers);

            return headersClassInstance;
        }
    }
}
