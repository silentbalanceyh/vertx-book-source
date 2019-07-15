package io.vertx.up._02.json;

import io.vertx.core.json.JsonObject;

public class JavaMapJson {
    public static void main(final String[] args) {
        final JsonObject json = new JsonObject()
                .put("username", "Lang")
                .put("password", "test");
        // Json转User
        final User user = json.mapTo(User.class);
        System.out.println(user);
    }
}

class User {
    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + this.username + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}
