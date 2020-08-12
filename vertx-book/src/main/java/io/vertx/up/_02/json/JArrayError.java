package io.vertx.up._02.json;

import io.vertx.core.json.DecodeException;
import io.vertx.core.json.JsonArray;

public class JArrayError {
    public static void main(final String[] args) {
        // 字符串元素使用单引号
        final String singleValue = "['Lang']";
        out(singleValue);
        // 布尔大小写敏感
        final String boolValue = "[True]";
        out(boolValue);
        // null字面量异常
        final String nullValue = "[Null]";
        out(nullValue);
        // 数值Java格式
        final String numberValue = "[1L]";
        out(numberValue);
    }

    private static void out(final String literal) {
        try {
            final JsonArray data = new JsonArray(literal);
            System.out.println(data.encodePrettily());
        } catch (final DecodeException ex) {
            System.out.println("解析异常：" + literal);
        }
    }
}
