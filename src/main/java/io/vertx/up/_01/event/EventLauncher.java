package io.vertx.up._01.event;

import io.vertx.core.DeploymentOptions;
import io.vertx.up._01.lanucher.ClusterLauncher;
import io.vertx.up._01.lanucher.Launcher;
import io.vertx.up._01.lanucher.SingleLauncher;

public class EventLauncher {
    public static void main(final String[] args) {
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        System.out.println(Thread.currentThread().getName() + ","
                + Thread.currentThread().getId());
        launcher.start(vertx -> {
            // 发布Standard
            vertx.deployVerticle("io.vertx.up._01.verticles.AcceptorVerticle",
                    new DeploymentOptions().setInstances(4));
            // 发布Worker
            vertx.deployVerticle("io.vertx.up._01.verticles.WorkerVerticle",
                    new DeploymentOptions().setWorker(true).setInstances(16));
        });
    }
}
