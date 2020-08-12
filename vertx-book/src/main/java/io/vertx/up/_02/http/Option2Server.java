package io.vertx.up._02.http;

import io.vertx.up._01.lanucher.Launcher;
import io.vertx.up._01.lanucher.SingleLauncher;
import io.vertx.up._02.verticles.Option2Verticle;

public class Option2Server {
    public static void main(final String[] args) {
        final Launcher launcher = new SingleLauncher();
        launcher.start(vertx -> vertx.deployVerticle(new Option2Verticle()));
    }
}
