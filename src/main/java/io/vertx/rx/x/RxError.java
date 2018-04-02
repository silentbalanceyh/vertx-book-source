package io.vertx.rx.x;

import io.reactivex.Single;

public class RxError {

    public static void main(final String[] args) {
        Single.error(new RuntimeException());
    }
}
