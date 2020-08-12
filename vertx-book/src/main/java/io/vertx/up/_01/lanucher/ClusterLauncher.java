package io.vertx.up._01.lanucher;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

import java.util.function.Consumer;

public class ClusterLauncher implements Launcher {

    @Override
    public void start(final Consumer<Vertx> consumer) {
        // 集群管理器设置
        final VertxOptions options = new VertxOptions();
        // 如果从参数传入则使用inpu中的ClusterManager，也可以在这里设计逻辑代码，毕竟这是ClusterLancher的职责所在
        Vertx.clusteredVertx(options, handler -> {
            if (handler.succeeded()) {
                final Vertx vertx = handler.result();
                if (null != vertx) {
                    consumer.accept(vertx);
                }
            } else {
                // 不推荐这样写，这个分支应该连接容错系统来处理
                final Throwable ex = handler.cause();
                if (null != ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
