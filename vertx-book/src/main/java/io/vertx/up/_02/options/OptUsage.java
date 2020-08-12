package io.vertx.up._02.options;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class OptUsage {
    public static void main(final String[] args) {
        final VertxOptions options = new VertxOptions();
        final Vertx vertx = Vertx.vertx();
    }
}
