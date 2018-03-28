package io.vertx.rx._01.launcher;

import io.vertx.core.DeploymentOptions;
import io.vertx.rx._01.verticles.RxLifeVerticle;

public class MainLauncher {

    public static void main(final String[] args) {
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        launcher.start(vertx -> {
            // 发布模式
            vertx.rxDeployVerticle(RxLifeVerticle.class.getName(),
                    new DeploymentOptions().setInstances(3))
                    .doOnSuccess(id -> {
                        System.out.println("Verticle: " + id + " has been deployed successfully!");
                    }).subscribe();
        });
    }
}
