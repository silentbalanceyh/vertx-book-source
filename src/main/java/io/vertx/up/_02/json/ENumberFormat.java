package io.vertx.up._02.json;

import java.text.NumberFormat;

public class ENumberFormat {

    public static void main(final String[] args) {
        final NumberFormat nf = NumberFormat.getInstance();
        /*
         * 设置此格式中不使用分组
         */
        nf.setGroupingUsed(false);
        /*
         * 设置数的小数部分所允许的最大位数
         */
        nf.setMaximumFractionDigits(6);
        System.out.println(nf.format(10.000015));
        System.out.println(nf.format(10.0000107));  // 入
        System.out.println(nf.format(10.0000103));  // 舍
    }
}
