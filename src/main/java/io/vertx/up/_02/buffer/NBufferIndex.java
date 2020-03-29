package io.vertx.up._02.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NBufferIndex {
    public static void main(final String[] args) {
        // 初始化
        final ByteBuf buf = Unpooled.buffer(16);

        for (int i = 0; i < 16; i++) {
            buf.writeByte(i);
        }
        final ByteBuf result = buf.readBytes(5);
        System.out.println(result);
        for (int idx = 0; idx < 5; idx++) {
            System.out.print(result.getByte(idx) + ",");
        }
        System.out.println();
        System.out.println(result);
        System.out.println(buf.readerIndex() + ", " + buf.writerIndex());
    }
}
