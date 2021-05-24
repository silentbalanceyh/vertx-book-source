package io.vertx.up._03;

import io.vertx.core.DeploymentOptions;
import io.vertx.up._01.lanucher.Launcher;
import io.vertx.up._01.lanucher.SingleLauncher;
import io.vertx.up._03.router.RouteSub;

public class MainRoute {
    public static void main(final String[] args) {
        final Launcher launcher = new SingleLauncher();
        launcher.start(vertx ->
                vertx.deployVerticle(RouteSub::new, new DeploymentOptions().setInstances(2)));
    }
}
