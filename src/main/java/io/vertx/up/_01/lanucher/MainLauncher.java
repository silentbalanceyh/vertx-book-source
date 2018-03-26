package io.vertx.up._01.lanucher;

import io.vertx.core.DeploymentOptions;
import io.vertx.up._01.verticles.MyFirstVerticle;

import java.util.ArrayList;

public class MainLauncher {

    public static void main(final String[] args) {
        // 哪种模式？
        final boolean isClustered = false;
        final Launcher launcher = isClustered ? new ClusterLauncher() :
                new SingleLauncher();
        
        // 设置Options
        launcher.start(vertx -> {
            // 函数模式发布
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setInstances(-1)));
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setMultiThreaded(true)));
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setExtraClasspath(new ArrayList<>())));
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setIsolationGroup("NEW GROUP")));
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setIsolatedClasses(new ArrayList<>())));
            safeJvm(() -> vertx.deployVerticle(MyFirstVerticle::new,
                    new DeploymentOptions().setInstances(10), res -> {
                        System.out.println(res.result());
                    }));
        });
    }

    private static void safeJvm(final Executor executor) {
        try {
            executor.execute();
        } catch (final Throwable ex) {
            System.err.println(ex.getMessage());
        }
    }
}

@FunctionalInterface
interface Executor {

    void execute();
}
