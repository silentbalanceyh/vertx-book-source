package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteOrder extends AbstractVerticle {
    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route1 = router.route().path("/api/order");
        route1.handler(res -> {
            System.out.println("First");
            res.next();
        });
        route1.remove();
        final Route route2 = router.route().path("/api/order");
        route2.handler(res -> {
            System.out.println("Second");
            res.next();
        });
        System.out.println(route1);
        server.requestHandler(router).listen();
    }
}
