package io.vertx.up._02.store;

import io.vertx.config.spi.ConfigStore;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

public class TestStore implements ConfigStore {
    private final JsonObject configuration;

    public TestStore(final JsonObject configuration) {
        if (Objects.isNull(configuration)) {
            this.configuration = new JsonObject();
        } else {
            this.configuration = configuration;
        }
    }

    public void get(final Handler<AsyncResult<Buffer>> completionHandler) {
        System.out.println("传入配置：" + this.configuration.encodePrettily());
        final Buffer buffer = Buffer.buffer();
        final JsonObject output = new JsonObject();
        final String node = this.configuration.getString("node");
        if (Objects.nonNull(node)) {
            output.put(node, "测试配置输出");
        }
        completionHandler.handle(Future.succeededFuture(output.toBuffer()));
    }
}
