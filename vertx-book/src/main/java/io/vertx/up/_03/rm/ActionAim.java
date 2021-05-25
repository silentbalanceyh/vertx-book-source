package io.vertx.up._03.rm;

import io.vertx.ext.web.Route;

public class ActionAim implements RAim {
    @Override
    public void mount(final Route route, final RRecord record) {
        route.handler(record.getSuccess().handler())
                .failureHandler(record.getFailure().handler());
    }
}
