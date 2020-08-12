package io.vertx.up._02.buffer;


import io.vertx.core.buffer.Buffer;

public class VBufferSeq {

    public static void main(final String[] args) {
        /*
         * 插入处理
         */
        final Buffer buffer = Buffer.buffer();
        buffer.appendDouble(12.5);
        buffer.appendString("Hello");
        buffer.appendInt(33);
        /*
         * 读取数据
         */
        System.out.println(buffer.getDouble(0));
        System.out.println(buffer.getString(8, 13));
        System.out.println(buffer.getInt(13));
        
    }
}
