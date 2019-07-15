package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;
import io.vertx.up.util.Ut;

public class JObjectGet2 {
    public static void main(final String[] args) {
        final JsonObject data = Ut.ioJObject("data/input.json");
        final Integer age = data.getInteger("age");
    }
}
