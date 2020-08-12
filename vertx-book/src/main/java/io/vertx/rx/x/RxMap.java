package io.vertx.rx.x;

import io.reactivex.Single;

import java.util.HashMap;
import java.util.Map;

public class RxMap {

    public static void main(final String[] args) {
        final Map<String, String> dataMap = new HashMap<String, String>() {
            {
                this.put("Key1", "Data1");
                this.put("Key2", "Data2");
            }
        };
        Single.just(dataMap).flatMap(item -> {
            return Single.just(item);
        }).subscribe(System.out::println);
    }
}
