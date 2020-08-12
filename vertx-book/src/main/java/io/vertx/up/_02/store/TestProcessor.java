package io.vertx.up._02.store;

import io.vertx.config.spi.ConfigProcessor;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

public class TestProcessor implements ConfigProcessor {
    @Override
    public String name() {
        return "test";
    }

    @Override
    public void process(final Vertx vertx, final JsonObject jsonObject,
                        final Buffer buffer, final Handler<AsyncResult<JsonObject>> handler) {
        final JsonObject data = buffer.toJsonObject();
        data.put("processor", "执行Processor");
        handler.handle(Future.succeededFuture(data));
    }
}
