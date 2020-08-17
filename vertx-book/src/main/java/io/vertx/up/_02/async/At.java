package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.up.fn.Fn;
import io.vertx.up.runtime.Runner;

import java.util.function.Supplier;

class At {
    static void hiAsync(final String name,
                        final Handler<AsyncResult<String>> handler) {
        // 每个人开一个线程执行
        Runner.run(() -> {
            System.out.println(Thread.currentThread().getName() + ", " + name);
            // 让子线程休眠
            Fn.safeJvm(() -> Thread.sleep(1000));
            handler.handle(Future.succeededFuture("Hi, " + name));
        }, name);
    }

    static Future<String> hiAsync(final String name) {
        final Promise<String> promise = Promise.promise();
        hiAsync(name, promise);
        return promise.future();
    }

    static Future<String> hiAsyncError(final String name) {
        final Promise<String> promise = Promise.promise();
        Runner.run(() -> {
            System.out.println(Thread.currentThread().getName() + "，" + name);
            promise.fail(name);
        }, "hiAsync");
        return promise.future();
    }

    static Future<String> hiAsync(final Supplier<String> supplier) {
        final Promise<String> promise = Promise.promise();
        Runner.run(() -> {
            final String name = supplier.get();
            System.out.println(Thread.currentThread().getName() + "，" + name);
            promise.complete(name);
        }, "hiAsync");
        return promise.future();
    }
}
