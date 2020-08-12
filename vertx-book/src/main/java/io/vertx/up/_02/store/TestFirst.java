package io.vertx.up._02.store;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class TestFirst {
    public static void main(final String[] args) {
        final Vertx vertx = Vertx.vertx();

        // 构造 Store Option
        final ConfigStoreOptions storeOptions = new ConfigStoreOptions()
                // 自定义类型
                .setType("test")
                // Format
                .setFormat("test")
                // 传入配置
                .setConfig(new JsonObject().put("node", "store"));

        // 构造 Retriever Option
        final ConfigRetrieverOptions options = new ConfigRetrieverOptions()
                .addStore(storeOptions);

        // 创建 Retriever
        final ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
        retriever.getConfig(handler -> {
            if (handler.succeeded()) {
                final JsonObject result = handler.result();
                System.out.println(result.encodePrettily());
            }
        });
    }
}
