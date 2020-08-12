package io.vertx.up._02.options;

import io.vertx.core.json.JsonObject;

public class TestOptions {
    public static final int DEFAULT_AGE = 10;
    public static final String DEFAULT_NAME = "Lang";
    public static final Class<?> DEFAULT_CLS = TestOptions.class;

    private final int age = DEFAULT_AGE;
    private final String name = DEFAULT_NAME;
    private final Class<?> clazz = DEFAULT_CLS;

    public TestOptions() {
    }

    public TestOptions(final JsonObject options) {
    }
}
