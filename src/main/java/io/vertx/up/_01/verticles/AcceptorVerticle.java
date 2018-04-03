package io.vertx.up._01.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;

public class AcceptorVerticle extends AbstractVerticle {

    @Override
    public void start() {

        final HttpServer server = this.vertx.createHttpServer();
        System.out.println(Thread.currentThread().getName() + ", Start Acceptor...");
        server.requestHandler(request -> {
            // 调用Event Bus
            final EventBus event = this.vertx.eventBus();
            System.out.println(Thread.currentThread().getName() + ", Accept Request...");
            // 发送消息
            event.<JsonObject>send("MSG://EVENT/BUS",
                    new JsonObject().put("message", "Event Communication"),
                    reply -> {
                        if (reply.succeeded()) {
                            // 发送回客户端
                            System.out.println(Thread.currentThread().getName() + ", Reply Message...");
                            System.out.println(" Message: " + reply.result().body());
                            request.response().end(reply.result().body().encode());
                        }
                    });
        });

        server.listen(8099);
    }
}
