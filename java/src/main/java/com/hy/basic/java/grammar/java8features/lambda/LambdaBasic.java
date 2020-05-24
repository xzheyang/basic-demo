package com.hy.basic.java.grammar.java8features.lambda;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @user yang.he
 * @date 2019/7/10
 * @introduce
 **/
public class LambdaBasic {

    //consumer包装类来做程序
    public static <T> Consumer<T> pack(Consumer<T> consumer) {
        return consumer;
    }

    //lambda的实现(实现这个注解的接口就能使用lambda)[相当于函数式编程]
    @FunctionalInterface
    public interface BasicConsumer<T> {
        void accept(T t);
    }
    public static <T> Consumer<T> myPack(BasicConsumer<T> consumer) {
        return i->{try {
            consumer.accept(i);
        }catch (Exception e){
            throw e;
        }};
    }


    public static void main(String[] args) {
        List<String> test = new ArrayList<>(Arrays.asList("1","2","",null,"3"));


        test.stream().
//                filter(Objects::nonNull).
                filter(StringUtils::isNotBlank).
                forEach(myPack(System.out::println));
    }

}
