package io.vertx.up._02.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.vertx.core.buffer.Buffer;

public class VBufferFirst {

    public static void main(final String[] args) {
        // 创建默认的Buffer（无内容）
        final Buffer buffer = Buffer.buffer();
        System.out.println(buffer.toString() + "," + buffer.length());

        // 字节数组创建
        final String helloWorld = "Hello World";
        final Buffer byteBuf = Buffer.buffer(helloWorld.getBytes());
        System.out.println(byteBuf.toString() + "," + byteBuf.length());

        // 字符串创建
        final Buffer strBuf = Buffer.buffer(helloWorld);
        System.out.println(strBuf.toString() + "," + strBuf.length());

        // 带编码的字符串创建
        final Buffer strEBuf = Buffer.buffer(helloWorld, "utf-8");
        System.out.println(strEBuf.toString() + "," + strEBuf.length());

        // 直接使用 ByteBuf
        final ByteBuf buf = Unpooled.buffer(16);
        for (int i = 0; i < 16; i++) {
            buf.writeByte(i);
        }
        final Buffer defaultBuf = Buffer.buffer(buf);
        System.out.println(defaultBuf.toString() + "," + defaultBuf.length());

        // 直接初始化带尺寸的
        final Buffer sizeBuf = Buffer.buffer(20);
        System.out.println(sizeBuf.toString() + "," + sizeBuf.length());
    }
}
