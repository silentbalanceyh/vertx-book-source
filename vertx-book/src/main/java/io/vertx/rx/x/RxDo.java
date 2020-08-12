package io.vertx.rx.x;

import io.reactivex.Single;

public class RxDo {

    public static void main(final String[] args) {
        Single.just("Lang")
                .doOnSuccess(item -> output("doOnSuccess", item))
                .doOnError(ex -> output("doOnError", ex.getMessage()))
                .doAfterSuccess(item -> output("doAfterSuccess", item))
                .doAfterTerminate(() -> output("doAfterTerminate", " ( None ) "))
                .doFinally(() -> output("doFinally", " ( None ) "))
                .doOnDispose(() -> output("doOnDispose", " ( None ) "))
                .doOnSubscribe(item -> output("doOnSubscribe", item.toString()))
                .doOnEvent((item, ex) -> output("doOnEvent", item + ":" + ((null == ex) ? "" : ex.getMessage())))
                .subscribe();
    }

    private static void output(final String prefix, final String item) {
        System.out.println(prefix + " : " + item);
    }
}
