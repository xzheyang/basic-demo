package com.hy.basic.java.grammar.java8features;

/**
 * @user hy
 * @date sometime
 * @introduce            Functional Interface函数式接口(他们才能支持Lambda)
 **/
public class FuncInterface {

    /**
     *  函数式接口（Functional Interface）就是只包含一个抽象方法的声明。
     *  针对该接口类型的所有 Lambda 表达式都会与这个抽象方法匹配。
     *
     *  defualt 关键字生成的默认方法是不算的
     *
     *  1.8以后的主要的函数接口在java.util.function包
     *
     */

    public static void main(String[] args) {

        //使用
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

    }

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

}



