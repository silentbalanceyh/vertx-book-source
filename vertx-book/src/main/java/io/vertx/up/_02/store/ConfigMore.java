package io.vertx.up._02.store;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class ConfigMore {

    public static void main(final String[] args) {
        final Vertx vertx = Vertx.vertx();

        // 构造 Store
        final ConfigStoreOptions configStore1 = new ConfigStoreOptions()
                .setType("file")
                .setFormat("hocon")
                .setConfig(new JsonObject().put("path", "verticle.conf"));
        final ConfigStoreOptions configStore2 = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", "verticle.json"));
        final ConfigStoreOptions configStore3 = new ConfigStoreOptions()
                .setType("file")
                .setFormat("yaml")
                .setConfig(new JsonObject().put("path", "verticle.yaml"));

        // 构造 Retriever Option
        final ConfigRetrieverOptions options = new ConfigRetrieverOptions()
                .addStore(configStore1)
                .addStore(configStore2)
                .addStore(configStore3);
        // 创建 Retriever
        final ConfigRetriever retriever = ConfigRetriever.create(vertx, options);
        retriever.getConfig(handler -> {
            if (handler.succeeded()) {
                final JsonObject config = handler.result();
                System.out.println(config.encodePrettily());
                // ......
                final DeploymentOptions options1 =
                        new DeploymentOptions(config.getJsonObject("config1"));
                final DeploymentOptions options2 =
                        new DeploymentOptions(config.getJsonObject("config2"));
                final DeploymentOptions options3 =
                        new DeploymentOptions(config.getJsonObject("config3"));

                vertx.deployVerticle(ConfigVerticle.class, options1);
                vertx.deployVerticle(ConfigVerticle.class, options2);
                vertx.deployVerticle(ConfigVerticle.class, options3);
            }
        });
    }
}
