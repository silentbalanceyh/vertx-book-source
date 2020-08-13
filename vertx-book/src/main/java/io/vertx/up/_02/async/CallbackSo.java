package io.vertx.up._02.async;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;
import io.vertx.up.runtime.Runner;
import io.vertx.up.unity.Ux;

/**
 * @author <a href="http://www.origin-x.cn">lang</a>
 */
public class CallbackSo {

    public static void main(final String[] args) {
        hiJson2("name").compose(Ux::debug);
    }

    /*
     * 封装（无类型转换）
     */
    private static Future<String> hiString(final String name) {
        final Promise<String> result = Promise.promise();
        hiAsync(name, result);
        return result.future();
    }

    /*
     * 封装（有类型转换）
     */
    private static Future<JsonObject> hiJson(final String name) {
        final Promise<JsonObject> result = Promise.promise();
        hiAsync(name, res -> {
            if (res.succeeded()) {
                result.complete(new JsonObject().put("result", res.result()));
            } else {
                result.fail(new RuntimeException("Exception found"));
            }
        });
        return result.future();
    }

    private static Future<JsonObject> hiJson2(final String name) {
        final Promise<String> result = Promise.promise();
        hiAsync(name, result);
        return result.future().compose(done -> {
            final JsonObject response = new JsonObject().put("result", done);
            return Future.succeededFuture(response);
        });
    }

    /*
     * 原始函数
     */
    private static void hiAsync(final String name,
                                final Handler<AsyncResult<String>> handler) {
        // 每个人开一个线程执行
        Runner.run(() -> handler.handle(Future.succeededFuture("Hi, " + name)), name);
    }
}
