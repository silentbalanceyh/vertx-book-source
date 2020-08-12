package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;

public class IssueOne {
    public static void main(final String[] args) {
        final JsonObject data = new JsonObject()
                .put("name", "Test");
        data.put("data", data.copy());
        System.out.println(data.encodePrettily());
    }
}
