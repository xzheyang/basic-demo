package com.hy.basic.java.grammar.java8features;

import com.hy.basic.java.grammar.java8features.example.Car;

import java.util.Arrays;
import java.util.List;

/**
 * @user hy
 * @date sometime
 * @introduce            java8符号的定义
 **/
public class Symbol {

    public static void main(String[] args) {

        /**
         * 方法引用:
         *  Java 8 中允许你通过 :: 关键字来引用类的方法或构造器
         *
         *  而且
         *
         */
        List<String> names = Arrays.asList("a","c","b");
        names.forEach(System.out::println);


        //引用构造器
        Car car = Car.create( Car::new );
        Car car2 = Car.create( Car::new );
        List< Car > cars = Arrays.asList( car, car2);

        //引用静态方法
//        cars.forEach( Car::collide );

        //引用List里特定类的的非静态方法引用(无参数)
//        cars.forEach(Car::repair);

        //引用List里特定对象的方法
        final Car police = Car.create( Car::new );
        cars.forEach(police::follow);
        //等于
        cars.forEach(s-> police.follow(s) );

    }


}
