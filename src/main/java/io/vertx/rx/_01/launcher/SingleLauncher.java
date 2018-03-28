package io.vertx.rx._01.launcher;

import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

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
