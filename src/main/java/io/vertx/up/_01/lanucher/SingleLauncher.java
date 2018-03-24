package io.vertx.up._01.lanucher;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

public class SingleLauncher implements Launcher {

    @Override
    public void start(final Consumer<Vertx> consumer) {
        final VertxOptions options = new VertxOptions();
        final Vertx vertx = Vertx.vertx(options);
        if (null != vertx) {
            consumer.accept(vertx);
        }
    }
}
