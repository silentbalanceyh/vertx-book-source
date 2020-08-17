package io.vertx.up._02.async;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.up.runtime.Runner;

public class AsyncHandle {
    public static void main(final String[] args) {
        final Future<String> response = hiChoice("Huan");
        response.onFailure(error -> {
            System.out.println("Error");
            error.printStackTrace();
        });
        response.onComplete(item -> {
            if (item.succeeded()) {
                System.out.println("Complete");
                System.out.println(item.result());
            } else {
                System.err.println("Complete");
                item.cause().printStackTrace();
            }
        });
        response.onSuccess(handler -> {
            System.out.println("Success");
            System.out.println(handler);
        });
    }


    static Future<String> hiChoice(final String name) {
        final Promise<String> promise = Promise.promise();
        Runner.run(() -> {
            // 当前 执行 不受影响
            System.out.println(Thread.currentThread().getName() + "，" + name);
            if ("Lang".equals(name)) {
                promise.complete(name);
            } else {
                promise.fail(new RuntimeException("Exception, " + name));
            }
        }, "hiAsync");
        return promise.future();
    }
}
