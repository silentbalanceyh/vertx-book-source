package io.vertx.up._03.rm;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

class RTool {

    static <V> V pool(final ConcurrentMap<String, V> pool, final Supplier<V> poolFn) {
        final String key = Thread.currentThread().getName();
        V reference = pool.get(key);
        if (null == reference) {
            reference = poolFn.get();
            if (null != reference) {
                pool.put(key, reference);
            }
        }
        return reference;
    }
}
