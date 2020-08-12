package io.vertx.up.x;

public class X1PassByValue {

    public static void main(final String[] args) {
        final int num1 = 13;
        final int num2 = 27;

        shift(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    private static void shift(int a, int b) {
        final int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
