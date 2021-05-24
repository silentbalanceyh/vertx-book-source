package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteEmpty extends AbstractVerticle {
    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route = router.route().path("/api/test");
        route.handler(res -> {
            System.out.println("Hello!");
        });
        server.requestHandler(router).listen();
    }
}
