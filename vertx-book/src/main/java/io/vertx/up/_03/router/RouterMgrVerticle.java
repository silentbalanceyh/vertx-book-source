package io.vertx.up._03.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

/**
 * @author <a href="http://www.origin-x.cn">lang</a>
 */
public class RouterMgrVerticle extends AbstractVerticle {
    @Override
    public void start() {

        final Router router = Router.router(this.vertx);                // 创建路由管理器
        final Route route = router.route().path("/api/test");      // 创建该路由管理器下的路由
        route.handler(res -> {
            // 处理器执行逻辑
        });
    }
}
