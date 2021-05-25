package io.vertx.up._03.rm;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;

public interface RAction {

    Handler<RoutingContext> handler();
}
