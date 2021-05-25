package io.vertx.up._03.rm;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RouteAgent extends AbstractVerticle {
    private static final ConcurrentMap<String, RStore> POOL_STORE = new ConcurrentHashMap<>();

    private static final ConcurrentMap<String, RAim> POOL_AIMB = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, RAim> POOL_AIMM = new ConcurrentHashMap<>();
    private static final ConcurrentMap<String, RAim> POOL_AIMA = new ConcurrentHashMap<>();

    @Override
    public void start() {
        // 路由器
        final HttpServer server = this.vertx.createHttpServer();
        final Router router = Router.router(this.vertx);
        // 构造存储管理器
        final RStore store = RTool.pool(POOL_STORE, RStore::getInstance);
        final List<RRecord> definitions = store.fetchAll();
        definitions.forEach(item -> {
            // 构造
            final Route route = router.route();
            // 1. 基础构造
            RTool.pool(POOL_AIMB, BasicAim::new).mount(route, item);
            // 2. 偏好构造
            RTool.pool(POOL_AIMM, MediaAim::new).mount(route, item);
            // 3. 行为构造
            RTool.pool(POOL_AIMA, ActionAim::new).mount(route, item);
        });
        // .....
        server.requestHandler(router).listen();
    }
}
