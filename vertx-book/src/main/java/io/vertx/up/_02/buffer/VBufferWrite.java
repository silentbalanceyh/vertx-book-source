package io.vertx.up._02.buffer;

import io.vertx.core.buffer.Buffer;

public class VBufferWrite {

    public static void main(final String[] args) {
        final Buffer buff = Buffer.buffer();

        buff.appendInt(123).appendString("hello\n");
        System.out.println(buff.toString());
    }
}
