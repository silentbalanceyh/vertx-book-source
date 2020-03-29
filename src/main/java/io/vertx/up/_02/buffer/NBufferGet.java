package io.vertx.up._02.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NBufferGet {
    public static void main(final String[] args) {
        // 初始化
        final ByteBuf buf = Unpooled.buffer(16);

        for (int i = 0; i < 16; i++) {
            buf.setByte(i, i);
        }

        System.out.print(buf.getByte(5) + ", ");
        System.out.println(buf.readerIndex() + ", " + buf.writerIndex());
    }
}
