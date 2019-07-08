package io.vertx.up._02.json;

public class ETest {
    public static void main(final String[] args) {
        /*
         * 整数部分位数大于等于8开始
         */
        System.out.println(1234567.0);
        System.out.println(12345678.0);
        System.out.println(-12345678.0);
        /*
         * 整数位为0,当小数位以0开始连续出现大于等于3时开始以科学计数法显示
         */
        System.out.println(0.001);
        System.out.println(0.0001);
        System.out.println(-0.0001);
    }
}
