package io.vertx.up.x;

public class X1PassedByRef {

    public static void main(final String[] args) {
        final int[] arr = {1, 2, 3, 4, 5};
        output(arr);
        modify(arr);
        output(arr);
    }

    private static void output(final int[] array) {
        for (final int item : array) {
            System.out.print(item + ",");
        }
        System.out.println();
    }

    private static void modify(final int[] array) {
        array[0] = 2;
        array[2] = 5;
    }
}
