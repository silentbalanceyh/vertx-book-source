package io.vertx.up._03.rm;

import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Route;

import java.util.Objects;

public class BasicAim implements RAim {
    @Override
    public void mount(final Route route, final RRecord record) {
        final HttpMethod method = Objects.isNull(record.getMethod())
                ? HttpMethod.GET : record.getMethod();
        route.path(record.getPath()).method(method).order(record.getOrder());
    }
}
