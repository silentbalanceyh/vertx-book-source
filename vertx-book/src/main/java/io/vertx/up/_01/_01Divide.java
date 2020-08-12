package io.vertx.up._01;

public class _01Divide {

    public static void main(final String[] args) {
        // final int result = divide(10, 0);
        final int result2 = divide2(10, 0);
        System.out.println(result2);
    }

    private static int divide(final int a, final int b) {
        return a / b;
    }

    private static int divide2(final int a, final int b) {
        return (int) (a / (float) b);
    }
}
