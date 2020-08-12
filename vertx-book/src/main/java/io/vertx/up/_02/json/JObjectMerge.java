package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;
import io.vertx.up.util.Ut;

public class JObjectMerge {
    public static void main(final String[] args) {
        /* 左值 */
        final JsonObject leftJson = Ut.ioJObject("data/merge/left.json");
        /* 右值 */
        final JsonObject rightJson = Ut.ioJObject("data/merge/right.json");
        /* 合并，深度为2 */
        final JsonObject result = leftJson.mergeIn(rightJson, 2);
        System.err.println(result.encodePrettily());
    }
}
