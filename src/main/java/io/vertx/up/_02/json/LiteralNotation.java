package io.vertx.up._02.json;

public class LiteralNotation {

    public static void main(final String[] args) {
        // 布尔字面量
        final Boolean bool = true;

        // 字符串字面量
        final String str = "Hello";

        // 字符字面量（Json非法）
        final char character = 'Y';

        // 字节字面量（Json无字节类型）
        final byte bytes = 12;

        // 整数字面量（Json中只支持十进制）
        final int number10 = 10;        // 十进制
        final int number16 = 0x10;      // 十六进制
        final int number8 = 012;        // 八进制

        // 浮点数字面量（Json中不支持）
        final float float1 = 1.1f;

        // 长整（Json中不支持）
        final long long1 = 1L;

        // 短整：Java中短整和整数同字面量（隐式转换）
        final short short1 = 2;
    }
}
