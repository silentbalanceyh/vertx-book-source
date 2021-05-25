package io.vertx.up._03.rm;

import io.vertx.ext.web.Route;

import javax.ws.rs.core.MediaType;
import java.util.Set;

public class MediaAim implements RAim {

    @Override
    public void mount(final Route route,
                      final RRecord record) {
        // produces
        final Set<MediaType> produces = record.getProduces();
        produces.stream()
                .map(type -> type.getType() + "/" + type.getSubtype())
                .forEach(route::produces);
        // consumes
        final Set<MediaType> consumes = record.getProduces();
        consumes.stream()
                .map(type -> type.getType() + "/" + type.getSubtype())
                .forEach(route::consumes);
    }
}
