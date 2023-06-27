package org.mifos.connector.channel.utils;

import org.json.JSONObject;

public class NullUtil {
    public static Object getOrDefault(JSONObject body, String value, Object defaultValue) {
        return body.has(value) ? body.get(value) : defaultValue;
    }
}
