package io.vertx.up._02.json;

import io.vertx.core.json.JsonArray;

public class JArrayAdd {
    public static void main(final String[] args) {
        // 原始数组
        final JsonArray original = new JsonArray();
        original.add("A").add("B").add("C");
        // add
        final JsonArray added = new JsonArray();
        added.add("D").add("E");
        final JsonArray add = original.copy().add(added);
        // addAll
        final JsonArray addedAll = new JsonArray();
        addedAll.add("D").add("E");
        final JsonArray addAll = original.copy().addAll(addedAll);

        // 打印结果
        System.out.println(add.encodePrettily());
        System.out.println("--- 分割 ---");
        System.out.println(addAll.encodePrettily());
    }
}
