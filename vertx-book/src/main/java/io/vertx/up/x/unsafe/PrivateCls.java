package io.vertx.up.x.unsafe;

class DefaultScope {
    private String username;
    private int age;

    private DefaultScope() {
        this.age = 21;
        this.username = "Lang";
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }
}
