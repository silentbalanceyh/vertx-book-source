package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;

public class JObjectGet {
    public static void main(final String[] args) {
        final JsonObject json = new JsonObject();
        json.put("result", "true");
        // java.lang.String cannot be cast to java.lang.Boolean
        final Boolean result = json.getBoolean("result");
    }
}
