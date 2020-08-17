package io.vertx.up._02.async;

import io.vertx.core.Future;
import io.vertx.up.unity.Ux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AsyncCombine {
    public static void main(final String[] args) {
        final List<String> nameSet = new ArrayList<>();
        nameSet.add("Lang");
        nameSet.add("Huan");
        nameSet.add("Han");

        Ux.thenCombineT(
                // 为每个人构造打招呼的行为
                nameSet.stream()
                        .map(At::hiAsync)
                        .collect(Collectors.toList())
        ).compose(response -> {
            // 最终返回的结果
            response.forEach(System.out::println);
            return Future.succeededFuture();
        });
    }
}
