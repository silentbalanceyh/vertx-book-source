package io.vertx.up._02.fluent;

public class NoFluent {

    private static void main(final String[] args) {
        final User user = new User();
        // 潜在的Bug
        user.setUsername("Lang").getRole().setName("XXXXX");
    }
}
