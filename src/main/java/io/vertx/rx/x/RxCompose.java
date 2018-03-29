package io.vertx.rx.x;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;

public class RxCompose {

    public static void main(final String[] args) {
        Single.just(10)
                .compose(item -> item.map(integer -> integer + 2.0))
                .compose(item -> item.map(doubleValue -> doubleValue * 2))
                .subscribe(item -> {
                    System.out.println(item);
                    System.out.println("Successfully to passed !");
                });

        Single.just(10)
                .compose(new SingleTransformer<Integer, Double>() {
                    @Override
                    public SingleSource<Double> apply(final Single<Integer> single) {
                        return single.map(integer -> integer + 0.2);
                    }
                })
                .compose(new SingleTransformer<Double, Double>() {
                    @Override
                    public SingleSource<Double> apply(final Single<Double> single) {
                        return single.map(doubleValue -> doubleValue * 2);
                    }
                })
                .subscribe(item -> {
                    System.out.println(item);
                    System.out.println("Successfully to passed !");
                });
    }
}
