package io.vertx.up._02.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

public class OptionVerticle extends AbstractVerticle {

    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        server.requestHandler(handler -> {
            System.out.println(Thread.currentThread().getName());
            handler.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello Direct Server!");
        });
        server.listen(1023);
    }
}
