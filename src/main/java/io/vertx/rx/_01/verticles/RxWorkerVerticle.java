package io.vertx.rx._01.verticles;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.eventbus.EventBus;

public class RxWorkerVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println(Thread.currentThread().getName() + ", Start RxWorker...");
        final EventBus event = this.vertx.eventBus();
        // 接收消息
        event.<JsonObject>consumer("MSG://EVENT/RX/BUS", reply -> {
            System.out.println(Thread.currentThread().getName() + ", Rx Consume Message...");
            // 提取接收消息
            final JsonObject message = reply.body();
            System.out.println(" Message: " + message.encode());
            // 回复消息
            reply.rxReply(new JsonObject().put("worker", "Worker Message")).subscribe();
        });
    }
}
