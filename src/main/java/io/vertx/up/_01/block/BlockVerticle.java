package io.vertx.up._01.block;

import io.vertx.core.AbstractVerticle;

public class BlockVerticle extends AbstractVerticle {

    @Override
    public void start() {
        try {
            Thread.sleep(4000);
        } catch (final Exception ex) {
            ex.printStackTrace();
        }
    }
}
