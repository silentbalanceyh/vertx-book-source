package io.vertx.up._02.async;

import io.vertx.core.Future;

public class AsyncCompose {
    public static void main(final String[] args) {
        // 生成第一个节点
        Future.succeededFuture("Lang")
                // 打招呼
                .compose(AsyncCompose::sayHi)
                // 再打招呼
                .compose(lang -> AsyncCompose.sayHi("Hi", lang))
                // 切换人打招呼
                .compose(nil -> AsyncCompose.sayHi("Han"))
                // 再打招呼
                .compose(han -> AsyncCompose.sayHi("Hello", han));
    }

    private static Future<String> sayHi(final String prefix, final String name) {
        return At.hiAsync(() -> prefix + "," + name);
    }

    private static Future<String> sayHi(final String name) {
        return At.hiAsync(() -> name);
    }
}
