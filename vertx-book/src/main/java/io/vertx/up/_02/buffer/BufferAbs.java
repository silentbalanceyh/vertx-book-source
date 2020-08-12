package io.vertx.up._02.buffer;

import java.nio.ByteBuffer;

public class BufferAbs {

    public static void main(final String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(3, (byte) 'M')
                .put((byte) 'w');
        final byte[] result = buffer.array();
        for (int idx = 0; idx < result.length; idx++) {
            System.out.print(idx + ":" + (char) result[idx] + ", ");
        }
    }
}
