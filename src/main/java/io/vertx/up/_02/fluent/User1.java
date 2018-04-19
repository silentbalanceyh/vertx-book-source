package io.vertx.up._02.fluent;

public class User1 {

    private String username;

    private String email;

    private Role role;

    public User1 setRole(final Role role) {
        this.role = role;
        return this;
    }

    public User1 setEmail(final String email) {
        this.email = email;
        return this;
    }

    public User1 setUsername(final String username) {
        this.username = username;
        return this;
    }
}
