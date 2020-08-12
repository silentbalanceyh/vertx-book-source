package io.vertx.up._02.buffer;

import java.nio.ByteBuffer;

public class BufferMark {
    public static void main(final String[] args) {
        final ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 'H').put((byte) 'e').put((byte) 'l').put((byte) 'l').put((byte) 'o');
        buffer.put(0, (byte) 'M').put((byte) 'w');
        // 主要关注这一行的调用
        buffer.position(2).mark().position(4);
    }
}
