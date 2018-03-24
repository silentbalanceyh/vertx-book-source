package io.vertx.up._01.lanucher;

import io.vertx.core.Vertx;

import java.util.function.Consumer;

public interface Launcher {

    void start(Consumer<Vertx> startConsumer);
}
