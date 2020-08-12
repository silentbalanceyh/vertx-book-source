package io.vertx.up._02.store;

import io.vertx.core.AbstractVerticle;

public class ConfigVerticle extends AbstractVerticle {
    @Override
    public void start() {
        System.out.println(Thread.currentThread().getName());
    }
}
