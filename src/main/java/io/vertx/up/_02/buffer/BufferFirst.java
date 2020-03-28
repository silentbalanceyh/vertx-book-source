package io.vertx.up._02.buffer;

import java.nio.ByteBuffer;

public class BufferFirst {

    public static void main(final String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H')
                .put((byte) 'e')
                .put((byte) 'l')
                .put((byte) 'l')
                .put((byte) 'o');
        System.out.println(buffer);
    }
}
