package io.vertx.up._02.json;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonArray;

import java.util.ArrayList;
import java.util.List;

public class JArrayInit {

    public static void main(final String[] args) {
        /*
         * 空的JSON数组
         */
        final JsonArray empty = new JsonArray();
        System.out.println(empty.encodePrettily());
        /*
         * 字面量初始化
         */
        final String literal = "[1,true,\"Lang\",{\"name\":\"Lang\"}]";
        final JsonArray strData = new JsonArray(literal);
        System.out.println(strData.encodePrettily());
        /*
         * 使用List初始化
         */
        final List list = new ArrayList() {
            {
                this.add(Boolean.TRUE);
                this.add(Integer.MAX_VALUE);
                this.add("Hello World");
            }
        };
        final JsonArray listData = new JsonArray(list);
        System.out.println(listData.encodePrettily());
        /*
         * 使用Buffer初始化
         */
        final Buffer buffer = Buffer.buffer(literal);
        final JsonArray bufferData = new JsonArray(buffer);
        System.out.println(bufferData.encodePrettily());
    }
}
