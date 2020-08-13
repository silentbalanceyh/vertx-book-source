package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.up.runtime.Runner;

public class CallbackHole1 {

    public static void main(final String[] args) {
        // 第一个打招呼
        hiHuan();
    }

    private static void hiHuan() {
        hiAsync("Huan", rs -> {
            if (rs.succeeded()) {
                System.out.println(rs.result());
                hiHan();
            }
        });
    }

    private static void hiHan() {
        hiAsync("Han", rs -> {
            if (rs.succeeded()) {
                System.out.println(rs.result());
                hiLang();
            }
        });
    }

    private static void hiLang() {
        hiAsync("Lang", rs -> {
            if (rs.succeeded()) {
                System.out.println(rs.result());
                System.out.println("Successful !");
            }
        });
    }

    private static void hiAsync(final String name,
                                final Handler<AsyncResult<String>> handler) {
        // 每个人开一个线程执行
        Runner.run(() -> handler.handle(Future.succeededFuture("Hi, " + name)), name);
    }
}
