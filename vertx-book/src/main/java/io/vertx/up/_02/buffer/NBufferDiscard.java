package io.vertx.up._02.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NBufferDiscard {
    public static void main(final String[] args) {
        // 初始化
        final ByteBuf buf = Unpooled.buffer(16);

        for (int i = 0; i < 16; i++) {
            buf.writeByte(i);
        }
        for (int i = 0; i < 16; i++) {
            System.out.print(buf.getByte(i) + ",");
        }
        System.out.println();
        final ByteBuf sub = buf.readBytes(7);
        System.out.println("Buffer, " + buf);
        final ByteBuf created = buf.discardReadBytes();
        for (int i = 0; i < 16; i++) {
            System.out.print(buf.getByte(i) + ",");
        }
        System.out.println();
        System.out.println("Buffer, " + buf);
        System.out.println("Sub, " + sub);
        System.out.println("Discard, " + created);
    }
}
