package com.hy.basic.java.annotation.basic;

import org.junit.Test;

/**
 *  基础注解使用单元测试类
 *
 */
public class AnnotationUseTest {

    private AnnotationUse annUse = new AnnotationUse();

    @Test
    public void testReflect() {
        annUse.reflect();
    }

    @Test
    public void testReflectOnce() {
        annUse.reflectOnce();
    }

    @Test
    public void testIntrospectorSetMethod() {
        annUse.IntrospectorSetMethod();
    }

}