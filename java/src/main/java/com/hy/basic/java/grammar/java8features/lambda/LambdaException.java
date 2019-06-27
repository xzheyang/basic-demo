package com.hy.basic.java.grammar.java8features.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @user yang.he
 * @date 2019/6/26
 * @introduce       lambda异常问题
 *
 *      参考: https://blog.csdn.net/neweastsun/article/details/82557509
 **/
public class LambdaException {


    //初步 解决非检查异常
    static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println("Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }


    public static void noCheckExceptionSuit() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(3, 9, 7, 0, 10, 20));
        integers.forEach(consumerWrapper(i -> System.out.println(50 / i),  ArithmeticException.class));
    }


    public static void main(String[] args) {
        noCheckExceptionSuit();
    }



}
