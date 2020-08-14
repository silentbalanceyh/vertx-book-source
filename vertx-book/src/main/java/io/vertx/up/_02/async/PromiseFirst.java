package io.vertx.up._02.async;

import io.vertx.core.Future;
import io.vertx.core.Promise;

public class PromiseFirst {

    public static void main(final String[] args) {
        // 构造一个 Promise
        final Promise<String> promise = Promise.promise();

        /*
         * 构造一个 Future
         * @Deprecated
         */
        final Future<String> future1 = Future.future();

        /*
         * 构造一个 Future
         */
        final Future<String> future2 = Future.future(handler -> {
            handler.complete("Hello");
        });

        /*
         * 转换一个 Future
         */
        final Future<String> future3 = promise.future();

        // ------------ Promise 三态 --------------
        final Promise<String> success = Promise.promise();
        final Promise<String> failure = Promise.promise();
        System.out.println(success);
        System.out.println(failure);
        success.complete("Ok!");
        failure.fail("Ko!");
        System.out.println(success);
        System.out.println(failure);

        // ------------ Future 三态 --------------
        final Future<String> f1 = Future.future();
        final Future<String> f2 = Future.future();
        System.out.println(f1);
        System.out.println(f2);
        f1.complete("Ok!");
        f2.fail("Ko!");
        System.out.println(f1);
        System.out.println(f2);
    }
}
