package io.vertx.up._02.buffer.cases;

import io.vertx.core.buffer.Buffer;
import io.vertx.up.eon.Values;
import io.vertx.up.util.Ut;

public class Buffalo {
    public static void write(final Buffer buffer,
                             final String... data) {
        // 遍历数据
        for (final String item : data) {
            if (Ut.isNil(item)) {
                // 字节数据
                final byte[] bytes = item.getBytes(Values.DEFAULT_CHARSET);
                buffer.appendInt(bytes.length);
                buffer.appendBytes(bytes);
            }
        }
    }

    public static int read(final int start,
                           final Buffer buffer,
                           final String[] reference) {
        int pos = start;
        for (int idx = 0; idx < reference.length; idx++) {
            // 先读取长度信息
            final int len = buffer.getInt(pos);
            // 计算偏移量
            pos += 4;
            // 读取本身内容
            final byte[] bytes = buffer.getBytes(pos, pos + len);
            reference[idx] = new String(bytes, Values.DEFAULT_CHARSET);
            pos += len;
        }
        return pos;
    }
}
