package com.hy.basic.java.annotation.basic;

import java.lang.annotation.*;

/**
 *
 *  需要重复使用而生成的注解，即负数注解
 *
 */

@Inherited                  //继承注解在单数注解使用
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExampleMeanings {

    ExampleMeaning[] value();

}
