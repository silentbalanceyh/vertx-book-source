package io.vertx.up._02.buffer;

import java.nio.CharBuffer;

public class BufferDrain {
    private static final
    String[] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly'",
            "Help Me! Help Me!"
    };
    private static int index = 0;

    private static void drainBuffer(final CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
    }

    private static boolean fillBuffer(final CharBuffer buffer) {
        if (index >= strings.length) return false;
        final String string = strings[index++];
        for (int i = 0; i < string.length(); i++)
            buffer.put(string.charAt(i));
        return true;
    }

    public static void main(final String[] args) {
        final CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }
}
