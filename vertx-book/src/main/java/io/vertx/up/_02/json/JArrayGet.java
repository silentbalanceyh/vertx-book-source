package io.vertx.up._02.json;

import io.vertx.core.json.JsonArray;

public class JArrayGet {
    public static void main(final String[] args) {
        // 数组基本
        final JsonArray array = new JsonArray();
        array.add(Boolean.TRUE);
        array.add(12.1f);
        array.add("Whether");
        // 正确读取
        final int length = array.size();
        for (int idx = 0; idx < length; idx++) {
            final Object item = array.getValue(idx);
            if (item instanceof Boolean) {
                System.out.println("布尔值：" + (Boolean) item);
            } else if (item instanceof Float) {
                System.out.println("浮点数：" + (Float) item);
            } else if (item instanceof String) {
                System.out.println("字符串：" + item);
            }
        }
        // 错误遍历
        for (int idx = 0; idx < length; idx++) {
            final Float item = array.getFloat(idx);
        }
    }
}
