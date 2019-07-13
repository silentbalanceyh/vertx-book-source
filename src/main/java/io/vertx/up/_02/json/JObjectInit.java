package io.vertx.up._02.json;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class JObjectInit {

    public static void main(final String[] args) {
        /*
         * 空的Json对象
         */
        final JsonObject empty = new JsonObject();
        System.out.println(empty.encodePrettily());
        /*
         * 字面量初始化
         */
        final String literal = "{\"age\":18,\"name\":\"Lang\"}";
        final JsonObject strData = new JsonObject(literal);
        System.out.println(strData.encodePrettily());
        /*
         * 使用Map初始化
         */
        final Map<String, Object> map = new HashMap<String, Object>() {
            {
                this.put("email", "lang.yu@hpe.com");
                this.put("age", 18);
            }
        };
        final JsonObject mapData = new JsonObject(map);
        System.out.println(mapData.encodePrettily());
        /*
         * 使用Buffer初始化
         */
        final Buffer buffer = Buffer.buffer(literal);
        final JsonObject bufferData = new JsonObject(buffer);
        System.out.println(bufferData.encodePrettily());
    }
}
