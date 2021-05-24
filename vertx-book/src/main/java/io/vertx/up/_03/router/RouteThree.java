package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import java.util.Objects;

public class RouteThree extends AbstractVerticle {
    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route1 = router.route().path("/api/three");
        route1.handler(res -> {
            System.out.println("First");
            res.next();
        }).handler(res -> {
            System.out.println("Second");
            // res.response().end("Terminal");
            res.next();
        }).handler(res -> {
            System.out.println("Third");
            final HttpServerResponse response = res.response();
            response.end("Finished");
            // res.next();
        }).failureHandler(error -> {
            final Throwable ex = error.failure();
            if (Objects.nonNull(ex)) {
                ex.printStackTrace();
            }
        });
        System.out.println(route1);
        server.requestHandler(router).listen();
    }
}
