package io.vertx.up._01.verticles;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println(Thread.currentThread().getName() +
                ": Hello Verticle : " +
                Thread.currentThread().getId());
    }
}
