package io.vertx.rx.x;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class RxCreate {

    public static void main(final String[] args) {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(final SingleEmitter<Integer> singleEmitter)
                    throws Exception {
                singleEmitter.onSuccess(120);
            }
        });

        Single.create(item -> item.onSuccess(120));
    }
}
