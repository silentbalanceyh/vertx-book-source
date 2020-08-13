package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.up.runtime.Runner;

public class CallbackHole {

    public static void main(final String[] args) {
        // 第一个打招呼
        hiAsync("Huan", r1 -> {
            if (r1.succeeded()) {
                System.out.println(r1.result());
                // 第二个打招呼
                hiAsync("Han", r2 -> {
                    if (r2.succeeded()) {
                        System.out.println(r2.result());
                        // 第三个打招呼
                        hiAsync("Lang", r3 -> {
                            if (r3.succeeded()) {
                                System.out.println(r3.result());
                                // 打完招呼
                                System.out.println("Successful !");
                            }
                        });
                    }
                });
            }
        });
    }

    private static void hiAsync(final String name,
                                final Handler<AsyncResult<String>> handler) {
        // 每个人开一个线程执行
        Runner.run(() -> handler.handle(Future.succeededFuture("Hi, " + name)), name);
    }
}
