package io.vertx.up.x;

public class X1String {

    public static void main(final String[] args) {
        final String lang = "Lang";
        System.out.println(lang);
        process(lang);
        System.out.println(lang);
    }

    private static void process(String literal) {
        literal = "Hello " + literal;
        System.out.println(literal);
    }
}
