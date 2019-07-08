package io.vertx.up._02.json;

import java.text.DecimalFormat;

public class EDecimalFormat {
    static public void SimgleFormat(final String pattern, final double value) {
        //实例化DecimalFormat对象
        final DecimalFormat myFormat = new DecimalFormat(pattern);
        final String output = myFormat.format(value);
        System.out.println(value + " " + pattern + " " + output);
    }

    //使用applyPattern()方法对数字进行格式化
    static public void UseApplyPatternMethodFormat(final String pattern, final double value) {
        final DecimalFormat myFormat = new DecimalFormat();
        myFormat.applyPattern(pattern);
        System.out.println(value + " " + pattern + " " + myFormat.format(value));
    }

    public static void main(final String[] args) {
        SimgleFormat("###,###.###", 123456.789);
        SimgleFormat("00000000.###kg", 123456.789);
        //按照格式模版格式化数字，不存在的位以0显示
        SimgleFormat("000000.000", 123.78);
        //调用静态UseApplyPatternMethodFormat()方法
        UseApplyPatternMethodFormat("#.###%", 0.789);
        //将小数点后格式化为两位
        UseApplyPatternMethodFormat("###.##", 123456.789);
        //将数字转化为千分数形式
        UseApplyPatternMethodFormat("0.00\u2030", 0.789);
    }
}
