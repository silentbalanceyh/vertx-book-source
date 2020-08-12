package io.vertx.up._01.life;

import io.vertx.core.DeploymentOptions;
import io.vertx.up._01.lanucher.Launcher;
import io.vertx.up._01.lanucher.SingleLauncher;
import io.vertx.up._01.verticles.LifeVerticle;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LifeCycle {

    private static final ConcurrentMap<String, String> IDS = new ConcurrentHashMap<>();

    public static void main(final String[] args) {
        // 选择单点模式
        final Launcher launcher = new SingleLauncher();

        launcher.start(vertx -> {
            // 发布
            vertx.deployVerticle(LifeVerticle::new, new DeploymentOptions().setInstances(10), res -> {
                if (res.succeeded()) {
                    IDS.put(res.result(), res.result());
                }
            });
            vertx.deployVerticle(LifeVerticle::new, new DeploymentOptions().setInstances(3), res -> {
                if (res.succeeded()) {
                    IDS.put(res.result(), res.result());
                }
            });

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                // 撤销
                IDS.keySet().forEach(item -> vertx.undeploy(item, res -> {
                    System.out.println("Successfully undeploy the item: " + item);
                }));
            }));
        });
    }
}
