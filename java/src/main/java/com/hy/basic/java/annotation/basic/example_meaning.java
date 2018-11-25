package com.hy.basic.java.annotation.basic;

import java.lang.annotation.*;


@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface example_meaning {

        String author() default "Hy";
        String date();
        int revision() default 1;
        String comments();

}
