package io.vertx.rx._01.verticles;

import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.eventbus.EventBus;
import io.vertx.reactivex.core.http.HttpServer;

public class RxAcceptorVerticle extends AbstractVerticle {

    @Override
    public void start() {
        final HttpServer server = this.vertx.createHttpServer();
        System.out.println(Thread.currentThread().getName() + ", Rx Start Acceptor...");
        server.requestHandler(request -> {
            // 调用Event Bus
            final EventBus event = this.vertx.eventBus();
            System.out.println(Thread.currentThread().getName() + ", Rx Accept Request...");
            // 发送消息
            event.<JsonObject>rxSend("MSG://EVENT/RX/BUS",
                    new JsonObject().put("message", "Event Communication"))
                    .doOnSuccess(message -> {
                        // 发送消息回客户端
                        System.out.println(Thread.currentThread().getName() + ", Rx Reply Message...");
                        System.out.println(" Message: " + message.body());
                        request.response().end(message.body().encode());
                    }).subscribe();
        }).rxListen(8099).subscribe();
    }
}
