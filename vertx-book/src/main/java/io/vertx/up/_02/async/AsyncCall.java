package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

public class AsyncCall {

    public static void main(final String[] args) {
        hiCallback(handler -> {
            if (handler.succeeded()) {
                System.out.println(handler.result());
            } else {
                handler.cause().printStackTrace();
            }
        });
    }

    private static void hiCallback(final Handler<AsyncResult<String>> handler) {
        final Future<String> response = At.hiAsync("Huan");
        response.onComplete(handler);
    }

}
