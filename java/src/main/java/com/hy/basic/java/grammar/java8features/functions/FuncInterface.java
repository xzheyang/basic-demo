package com.hy.basic.java.grammar.java8features.functions;

import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        //使用自建函数
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        //使用Predicate,Function,Supplier,Consumer,UnaryOperator,UnaryOperator,BinaryOperator核心接口测试
        List<String> listExample =new ArrayList<>(Arrays.asList("4","5",null,"","8"));

        Predicate<String> intPred = StringUtils::isNumeric;
        Function<String, Integer> toInteger = Integer::valueOf;
        Supplier<List<Integer>> sumInit = ArrayList::new;
        Consumer<Integer> printInt = System.out::print;

        Stream<Integer> integerStream = listExample.stream().filter(intPred).map(toInteger);

        integerStream.forEach(printInt);


        List<Integer> collect = integerStream.collect(sumInit, List::add, List::addAll);


    }


    /**
     *
     *  已有函数方式核心接口
     *
     * Predicate<T>，参数：T，返回boolean。用于判别一个对象。比如求一个人是否为男性
     * Function<T, R> ，参数T，返回R。用于转换一个对象为不同类型的对象。
     * Supplier<T> ，无参数。返回T。用于提供一个对象。
     * Consumer<T> ，参数T，返回void。用于接收一个对象进行处理但没有返回，比如接收一个人并打印他的名字
     * UnaryOperator<T>，参数T，返回T。用于接收对象并返回同类型的对象。
     * BinaryOperator<T>，参数(T, T)，返回T。用于接收两个同类型的对象，并返回一个原类型对象。
     *
     * 接口只是一种通用,也可以自建
     *
     */


    /**
     *  自建转换接口
     *
     * @param <F>
     * @param <T>
     */
    @FunctionalInterface
    public interface Converter<F, T> {
        T convert(F from);
    }

}



