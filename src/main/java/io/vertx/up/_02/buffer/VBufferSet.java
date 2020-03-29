package io.vertx.up._02.buffer;

import io.vertx.core.buffer.Buffer;

public class VBufferSet {

    public static void main(final String[] args) {
        final Buffer buff = Buffer.buffer();

        buff.appendString("hello\n");
        buff.setString(3, "X");
        System.out.println(buff.toString() + ", " + buff.length());
        buff.setString(8, "X");
        System.out.println(buff.toString() + ", " + buff.length());
    }
}
