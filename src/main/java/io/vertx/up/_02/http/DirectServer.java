package io.vertx.up._02.http;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

public class DirectServer {

    public static void main(final String[] args) {
        final Vertx vertx = Vertx.vertx();
        final HttpServer server = vertx.createHttpServer();
        server.requestHandler(handler -> {
            System.out.println(Thread.currentThread().getName());
            handler.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello Direct Server!");
        });
        server.listen(8099);
    }
}
