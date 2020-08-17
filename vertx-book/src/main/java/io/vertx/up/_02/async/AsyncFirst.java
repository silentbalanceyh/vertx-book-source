package io.vertx.up._02.async;

import io.vertx.core.Future;

import java.util.ArrayList;
import java.util.List;

public class AsyncFirst {
    public static void main(final String[] args) {
        // 基本调用
        At.hiAsync("Begin").compose(result -> {
            // 最终执行
            System.out.println(Thread.currentThread().getName() + ", End Actual");
            return Future.succeededFuture();
        });
        // 最终执行
        System.out.println(Thread.currentThread().getName() + ", End");

        final List<String> response = new ArrayList<>();
        At.hiAsync("Lang").compose(result -> {
            response.add(result);
            return Future.succeededFuture();
        });
        System.out.println(response.size());
    }
}
