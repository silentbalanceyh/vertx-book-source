package io.vertx.up._02.fluent;

public class Fluent {

    public static void main(final String[] args) {
        final User1 user = new User1()
                .setEmail("lang.yu@hpe.com")
                .setRole(new Role())
                .setUsername("Lang Yu");

        final User1 user1 = new User1();
        user1.setEmail("lang.yu@hp1.com");
        user1.setRole(new Role());
        user1.setUsername("Lang Yu");
    }
}
