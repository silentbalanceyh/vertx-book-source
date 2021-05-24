package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

public class RouteSub extends AbstractVerticle {
    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route1 = router.route().path("/api/*");
        route1.subRouter(this.subRouter());
        route1.handler(res -> {

        });
        server.requestHandler(router).listen();
    }

    public Router subRouter() {
        final Router router = Router.router(this.vertx);
        final Route route1 = router.route().path("/sub/name");
        route1.handler(res -> {
            final HttpServerResponse response = res.response();
            response.end("Name");
        });
        final Route route2 = router.route().path("/sub/code");
        route2.handler(res -> {
            final HttpServerResponse response = res.response();
            response.end("Code");
        });
        return router;
    }
}
