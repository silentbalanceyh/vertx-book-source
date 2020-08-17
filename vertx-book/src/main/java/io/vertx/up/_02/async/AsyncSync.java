package io.vertx.up._02.async;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.up.atom.Refer;
import io.vertx.up.fn.Fn;
import io.vertx.up.fn.JvmActuator;
import io.vertx.up.runtime.Runner;

import java.util.concurrent.CountDownLatch;

public class AsyncSync {

    public static void main(final String[] args) {
        final String callback = hiCallback();
        System.out.println(callback);
    }

    private static String hiCallback() {
        final Future<String> response = hiChoice("Lang");
        final CountDownLatch latch = new CountDownLatch(1);
        final Refer refer = new Refer();
        response.onComplete(res -> {
            if (res.succeeded()) {
                //
                // Java中的限制 line = res.result();
                refer.add(res.result());
            } else {
                //
                res.cause().printStackTrace();
            }
            latch.countDown();
        });
        // 手动阻塞，破坏黄金法则
        Fn.safeJvm((JvmActuator) latch::await);
        return refer.get();
    }

    static Future<String> hiChoice(final String name) {
        final Promise<String> promise = Promise.promise();
        Runner.run(() -> {
            // 当前 执行 不受影响
            System.out.println(Thread.currentThread().getName() + "，" + name);
            Fn.safeJvm(() -> Thread.sleep(1000));
            if ("Lang".equals(name)) {
                promise.complete(name);
            } else {
                promise.fail(new RuntimeException("Exception, " + name));
            }
        }, "hiAsync");
        return promise.future();
    }
}
