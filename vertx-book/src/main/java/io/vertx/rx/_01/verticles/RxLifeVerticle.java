package io.vertx.rx._01.verticles;

import io.vertx.reactivex.core.AbstractVerticle;

public class RxLifeVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                ": Start : " +
                Thread.currentThread().getId()
                + ", Did: " + this.deploymentID());
    }

    @Override
    public void stop() throws Exception {
        System.out.println(Thread.currentThread().getName() +
                ": Start : " +
                Thread.currentThread().getId()
                + ", Did: " + this.deploymentID());
    }
}
