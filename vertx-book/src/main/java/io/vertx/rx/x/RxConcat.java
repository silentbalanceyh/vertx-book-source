package io.vertx.rx.x;

import io.reactivex.Single;

public class RxConcat {

    public static void main(final String[] args) {
        Single.concat(Single.just(10), Single.just(12))
                .compose(item -> item.map(integer -> integer + 2.0))
                .compose(item -> item.map(doubleValue -> doubleValue * 2))
                .subscribe(item -> {
                    System.out.println(item);
                    System.out.println("Successfully to passed !");
                });
    }
}
