package io.vertx.up._02.store;

import io.vertx.config.ConfigRetriever;
import io.vertx.core.AbstractVerticle;

public class ConfigVerticle extends AbstractVerticle {
    @Override
    public void start() {
        final ConfigRetriever retriever = ConfigRetriever.create(this.vertx);
        // 从文件系统中读取
    }
}
