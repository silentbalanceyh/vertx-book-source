package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;

import java.util.Objects;

public class JsonIterator {
    public static void main(final String[] args) {
        /*
         * JsonObject
         */
        final JsonObject data = new JsonObject()
                .put("name", "Lang")
                .put("email", "lang.yu@hpe.com")
                .put("age", 34);
        /*
         * 常用迭代
         */
        data.copy().stream()
                .filter(Objects::nonNull)
                .filter(entry -> Objects.nonNull(entry.getValue()))
                .forEach(item -> {
                    if ("name".equals(item.getKey())) {
                        data.remove(item.getKey());
                    }
                });
    }
}
