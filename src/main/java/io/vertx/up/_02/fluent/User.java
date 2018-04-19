package io.vertx.up._02.fluent;

public class User {

    private String username;
    private Role role;

    public String getUsername() {
        return this.username;
    }

    public User setUsername(final String username) {
        this.username = username;
        return this;
    }

    public Role getRole() {
        return this.role;
    }

    public Role setRole(final Role role) {
        this.role = role;
        return this.role;
    }
}
