package com.hy.basic.java.grammar.java8features.lambda;

import java.io.IOException;
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


    private static void noCheckExceptionSuit() {
        List<Integer> integers = new ArrayList<>(Arrays.asList(3, 9, 7, 0, 10, 20));
        integers.forEach(consumerWrapper(i -> System.out.println(50 / i),  ArithmeticException.class));
    }


    public static void main(String[] args) {

        //fixme 主要通过Consumer实现lambda程序实现函数式编程处理
        //fixme   lambda本质上就是参数是  拥有@FunctionalInterface注解的接口


//        noCheckExceptionSuit();

//        throwCheckExceptionSuit();
        catchCheckExceptionSuit();
    }


    private static void catchCheckExceptionSuit() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(handlingConsumerWrapper(i -> write(i),IOException.class));
    }


    private static void throwCheckExceptionSuit() {
        List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
        integers.forEach(throwingConsumerWrapper(i -> write(i)));
    }


    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }


    static <T> Consumer<T> throwingConsumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
            ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }



    public static <T> void write(T value) throws IOException {
        throw new IOException("test");
    }



}
