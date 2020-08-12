package io.vertx.rx._01.launcher;

import io.vertx.reactivex.core.Vertx;

import java.util.function.Consumer;

public interface Launcher {

    void start(Consumer<Vertx> startConsumer);
}
