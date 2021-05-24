package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteOne extends AbstractVerticle {
    @Override
    public void start() {
        this.process("First");
        this.process("Second");
    }

    private void process(final String flag) {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route = router.route().path("/api/one");
        route.handler(res -> {
            final String message = "Hello! " + flag + ", " + router.hashCode()
                    + ", " + Thread.currentThread().getName();
            System.out.println(message);
            final HttpServerResponse response = res.response();
            response.end(message);
        });
        server.requestHandler(router).listen();
    }
}
