package io.vertx.up._02.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class NBufferConsider {
    public static void main(final String[] args) {

        {
            // discard
            final ByteBuf buf = create();
            System.out.println("Buffer, " +
                    buf.hashCode() + ", " + buf);

            final ByteBuf discard = buf.discardReadBytes();
            System.out.println("Discard, " +
                    discard.hashCode() + ", " + discard);
            System.out.println(buf == discard);
        }

        {
            // read
            final ByteBuf buf = create();
            System.out.println("Buffer, " +
                    buf.hashCode() + ", " + buf);

            final ByteBuf sub = buf.readBytes(4);
            System.out.println("Sub, " +
                    sub.hashCode() + ", " + sub);
            System.out.println(buf == sub);
        }

        {
            // slice
            final ByteBuf buf = create();
            System.out.println("Buffer, " +
                    buf.hashCode() + ", " + buf);

            final ByteBuf slice = buf.slice(3, 8);
            System.out.println("Slice, " +
                    slice.hashCode() + ", " + slice);
            System.out.println(buf == slice);
        }
        {
            // duplicated
            final ByteBuf buf = create();
            System.out.println("Buffer, " +
                    buf.hashCode() + ", " + buf);

            final ByteBuf duplicated = buf.duplicate();
            System.out.println("Duplicated, " +
                    duplicated.hashCode() + ", " + duplicated);
            System.out.println(buf == duplicated);
        }
    }

    private static ByteBuf create() {
        // 初始化
        final ByteBuf buf = Unpooled.buffer(16);

        for (int i = 0; i < 16; i++) {
            buf.writeByte(i);
        }
        buf.readBytes(7);
        return buf;
    }
}
