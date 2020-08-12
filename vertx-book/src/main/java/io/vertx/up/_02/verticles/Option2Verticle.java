package io.vertx.up._02.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

public class Option2Verticle extends AbstractVerticle {

    @Override
    public void start() {
        final HttpServerOptions options = new HttpServerOptions();
        // 使用代码块解释options
        {
            // 压缩的支持，对应到Json中的
            options.setCompressionSupported(true);
        }
        final HttpServer server = this.vertx.createHttpServer(options);
        server.requestHandler(handler -> {
            System.out.println(Thread.currentThread().getName());
            handler.response()
                    .putHeader("content-type", "text/plain")
                    .end("Hello Option Server!");
        });
        // 使用了options过后可以直接省略掉端口号，同时也不会使用80端口
        server.listen();
    }
}
