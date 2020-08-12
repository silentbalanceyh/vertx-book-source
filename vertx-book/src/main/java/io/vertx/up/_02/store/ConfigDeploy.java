package io.vertx.up._02.store;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.json.JsonObject;

public class ConfigDeploy {

    public static void main(final String[] args) {
        // 构造 Store Option
        final Vertx vertx = Vertx.vertx();
        final ConfigStoreOptions storeOptions = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", "vertx.json"));

        // 构造 Retriever Option
        final ConfigRetrieverOptions options = new ConfigRetrieverOptions()
                .addStore(storeOptions);

        // 创建 Retriever
        final ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
        retriever.getConfig(handler -> {
            if (handler.succeeded()) {
                final JsonObject config = handler.result();
                // 关闭原始 vertx 实例
                System.out.println("Will close old. " + vertx.hashCode());
                vertx.close(closed -> {
                    // 创建一个新的
                    final VertxOptions vertxOptions = new VertxOptions(config);
                    final Vertx vertxNew = Vertx.vertx(vertxOptions);
                    // 调用发布代码发布 Verticle
                    // .......
                    System.out.println("Vertx has been created. " + vertxNew.hashCode());
                });
            }
        });
    }
}
