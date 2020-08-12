package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;

import java.util.Date;

enum StringType {
    TEST1, TEST2
}

public class JObjectSet {
    public static void main(final String[] args) {
        /* 枚举类型 */
        final JsonObject data = new JsonObject();
        data.put("enum", StringType.TEST1);
        /* CharSequence */
        final CharSequence sequence = "Hello World";
        data.put("str1", sequence);
        System.out.println(data.encodePrettily());
        /* Error：Date类型 */
        final Date date = new Date();
        data.put("date", date);
    }
}
