package io.vertx.up._02.store;

import io.vertx.up._01.lanucher.Launcher;
import io.vertx.up._01.lanucher.SingleLauncher;

public class ConfigDriver {
    public static void main(final String[] args) {
        final Launcher launcher = new SingleLauncher();
        launcher.start(vertx -> vertx.deployVerticle(new ConfigVerticle()));
    }
}
