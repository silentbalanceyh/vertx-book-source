package io.vertx.up._01.block;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;

public class ThreadIdVerticle extends AbstractVerticle {

    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
        server.requestHandler(res -> {
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId());
            res.response()
                    .putHeader("Content-Type", "text/plain")
                    .end("Hello World!");
        });
        server.listen(8088);
    }
}
