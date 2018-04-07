package io.vertx.rx._01.event;

import io.vertx.core.DeploymentOptions;
import io.vertx.rx._01.launcher.ClusterLauncher;
import io.vertx.rx._01.launcher.Launcher;
import io.vertx.rx._01.launcher.SingleLauncher;

public class EventLauncher {

    public static void main(final String[] args) {
        // 选择哪种模式
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        launcher.start(vertx -> {
            // Rx模式的发布
            vertx.rxDeployVerticle(
                    "io.vertx.rx._01.verticles.RxAcceptorVerticle",
                    new DeploymentOptions().setInstances(2))
                    .doOnSuccess(id -> {
                        System.out.println("Rx Acceptor: " + id + " has been deployed successfully!");
                    }).subscribe();
            vertx.rxDeployVerticle(
                    "io.vertx.rx._01.verticles.RxWorkerVerticle",
                    new DeploymentOptions().setInstances(4).setWorker(true))
                    .doOnSuccess(id -> {
                        System.out.println("Rx Worker: " + id + " has been deployed successfully!");
                    }).subscribe();
        });
    }
}
