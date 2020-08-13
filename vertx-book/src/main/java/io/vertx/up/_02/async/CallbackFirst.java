package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.up.runtime.Runner;

public class CallbackFirst {

    public static void main(final String[] args) {
        hiAsync("Lang", r1 -> {
            if (r1.succeeded()) {
                System.out.println(Thread.currentThread().getName() +
                        ", " + r1.result());
            }
        });
        hiAsync("Huan", r2 -> {
            if (r2.succeeded()) {
                System.out.println(Thread.currentThread().getName() +
                        ", " + r2.result());
            }
        });
        hiAsync("Han", r3 -> {
            if (r3.succeeded()) {
                System.out.println(Thread.currentThread().getName() +
                        ", " + r3.result());
            }
        });
        System.out.println("Successful !");
    }

    private static void hiAsync(final String name,
                                final Handler<AsyncResult<String>> handler) {
        // 每个人开一个线程执行
        Runner.run(() -> handler.handle(Future.succeededFuture("Hi, " + name)), name);
    }
}
