package io.vertx.up._01.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

public class WorkerVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println(Thread.currentThread().getName() + ", Start Worker...");
        final EventBus event = this.vertx.eventBus();
        // 接收消息
        event.<JsonObject>consumer("MSG://EVENT/BUS", reply -> {
            System.out.println(Thread.currentThread().getName() + ", Consume Message...");
            // 提取接收消息
            final JsonObject message = reply.body();
            System.out.println(" Message: " + message.encode());
            // 回复消息
            reply.reply(new JsonObject().put("worker", "Worker Message"));
        });
    }
}
