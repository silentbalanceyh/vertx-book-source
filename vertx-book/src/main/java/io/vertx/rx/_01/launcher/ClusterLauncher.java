package io.vertx.rx._01.launcher;

import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

import java.util.function.Consumer;

public class ClusterLauncher implements Launcher {

    @Override
    public void start(final Consumer<Vertx> consumer) {
        final VertxOptions options = new VertxOptions();

        Vertx.rxClusteredVertx(options)
                .doOnSuccess(consumer::accept)
                .doOnError(error -> {
                    if (null != error) {
                        error.printStackTrace();
                    }
                }).subscribe();
    }
}
