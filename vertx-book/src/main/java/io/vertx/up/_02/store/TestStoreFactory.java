package io.vertx.up._02.store;

import io.vertx.config.spi.ConfigStore;
import io.vertx.config.spi.ConfigStoreFactory;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class TestStoreFactory implements ConfigStoreFactory {
    public TestStoreFactory() {

    }

    public String name() {
        return "test";
    }

    public ConfigStore create(final Vertx vertx, final JsonObject configuration) {
        return new TestStore(configuration);
    }
}
