package io.vertx.up._02.async;

import io.vertx.core.Future;

public class FutureFirst {
    public static void main(final String[] args) {
        final Future<String> success = Future.succeededFuture("Ok!");
        final Future<String> failure = Future.failedFuture("Ko!");
        System.out.println(success);
        System.out.println(failure);
    }
}
