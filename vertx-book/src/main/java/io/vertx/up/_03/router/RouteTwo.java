package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.Objects;

public class RouteTwo extends AbstractVerticle {
    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        final Route route1 = router.route().path("/api/two");
        route1.handler(this.buildHandler(route1, "First", false))
                .failureHandler(this.buildFailure(route1, "First"));
        final Route route2 = router.route().path("/api/two");
        route2.handler(this.buildHandler(route2, "Second", true))
                .failureHandler(this.buildFailure(route2, "Second"));
        System.out.println(route1);
        System.out.println(route2);
        server.requestHandler(router).listen();
    }

    private Handler<RoutingContext> buildHandler(final Route route, final String flag, final boolean ended) {
        return res -> {
            final String message = "Hello! " + route.hashCode() + ", " + flag
                    + ", " + Thread.currentThread().getName();
            System.out.println(message);
            if (ended) {
                // 最后一个Handler调用
                final HttpServerResponse response = res.response();
                response.end(message);
            } else {
                // 中间的Handler调用
                res.next();
            }
        };
    }

    private Handler<RoutingContext> buildFailure(final Route route, final String flag) {
        return res -> {
            System.out.println("Failure, " + flag + ", " + route.hashCode()
                    + ", " + Thread.currentThread().getName());
            final Throwable ex = res.failure();
            if (Objects.nonNull(ex)) {
                ex.printStackTrace();
            }
        };
    }
}
