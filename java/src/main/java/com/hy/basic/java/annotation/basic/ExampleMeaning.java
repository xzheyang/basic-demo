package com.hy.basic.java.annotation.basic;

import java.lang.annotation.*;

/**
 *
 *  熟悉使用注解
 *
 */

@Documented                                 //指定被标注的注解会包含在javadoc中
@Inherited                                  //注解可被在子类继承（但是注意这个注解里面源码，事只在注解类上生效）
@Target(ElementType.METHOD)                 //适用注释使用的范围
@Retention(RetentionPolicy.RUNTIME)         //生命周期
@Repeatable(ExampleMeanings.class)          //帮组快捷重复使用一个注释的语法糖
public @interface ExampleMeaning {

        String author() default "hy";
        String date();
        int revision() default 1;
        String comments();

}
