package io.vertx.up._02.async;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.up.runtime.Runner;

public class AsyncOther {

    public static void main(final String[] args) {
        hiAsyncError("Lang").compose(result -> {
            // 这里不再输出
            System.out.println(result);
            return Future.succeededFuture();
        }).otherwise(ex -> {
            ex.printStackTrace();
            return "Huan";
        }).compose(finalResult -> {
            // 受影响的位置
            System.err.println(finalResult);
            return Future.succeededFuture();
        });
    }

    static Future<String> hiAsyncError(final String name) {
        final Promise<String> promise = Promise.promise();
        Runner.run(() -> {
            // 当前 执行 不受影响
            System.out.println(Thread.currentThread().getName() + "，" + name);
            promise.fail(new RuntimeException("Exception, " + name));
        }, "hiAsync");
        return promise.future();
    }
}
