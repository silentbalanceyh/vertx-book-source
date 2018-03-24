package io.vertx.up._01.block;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

public class VertxLanucher {
    public static void main(final String[] args) {
        Vertx.clusteredVertx(new VertxOptions(), handler -> {
            final Vertx vertx = handler.result();
            vertx.deployVerticle("io.vertx.up._01.block.ThreadIdVerticle",
                    new DeploymentOptions().setInstances(4));
        });
    }
}
