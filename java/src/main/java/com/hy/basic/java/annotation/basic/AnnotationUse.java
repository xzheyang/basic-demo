package com.hy.basic.java.annotation.basic;

import java.beans.*;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationUse {

    final private static String CLASS_PATH = "com.hy.basic.java.annotation.basic.AnnotationUse";

    @ExampleMeaning(date = "2017.12.26", comments = "empty")
    public void reflect() {
        String methodStr = "reflect";

        try {

            //获得注解信息一般靠反射

            //获得使用注释的方法
            Method method = Class.forName(CLASS_PATH).getMethod(methodStr);

            //获得注释(getAnnotation方法)
            method.setAccessible(true);
            if (method.isAnnotationPresent(ExampleMeaning.class)){
                ExampleMeaning a1 = method.getAnnotation(ExampleMeaning.class);
                System.out.println("注释作者(测试版):" + a1.author());
            }

        } catch (NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到注解类,CLASS_PATH=["+ CLASS_PATH +"],method=["+ methodStr +"]");
        }


    }

    @ExampleMeaning(date = "2017.12.26", comments = "注解")
    public void reflectOnce() {

        System.out.println("注释信息(改良版):"+comments);

    }

    //上面方法解析注释很多次,应该只解析一次
    private String comments;

    {
        String methodStr = "reflectOnce";
        try {
            Method method =this.getClass().getMethod(methodStr);
            ExampleMeaning a1 = method.getAnnotation(ExampleMeaning.class);
            comments = a1.comments();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到注解类,CLASS_PATH=["+ this.getClass().getName() +"],method=["+ methodStr +"]");
        }
    }

    //set方法
    @ExampleMeaning(date = "2019.06.20", comments = "empty")
    @ExampleMeaning(date = "2020.05.30", comments = "温故而知新")
    public void setComments(String comments) {
        this.comments = comments;
    }



    public void IntrospectorSetMethod() {

        try {
            //使用内省获得数据,除开父类Object
            BeanInfo nx = Introspector.getBeanInfo(Class.forName(CLASS_PATH),Object.class);
            PropertyDescriptor[] pds = nx.getPropertyDescriptors();

            for(PropertyDescriptor pd :pds){
                //获得数据set方法
                Method writeMethod = pd.getWriteMethod();
                //跳过不能获得方法
                if(writeMethod==null){
                    System.out.println("没有set方法的属性:"+pd.getName());
                    continue;
                }
                //获得注释
                ExampleMeanings meanings = writeMethod.getAnnotation(ExampleMeanings.class);

                if(meanings==null){
                    System.out.println(writeMethod.getName()+"方法没有em注释");
                }else{
                    Arrays.stream(meanings.value()).forEach(m->{
                        System.out.println(writeMethod.getName()+"方法有em注释( author=["+m.author()+"], comments=["+m.comments()+"] revision=["+m.revision()+"], date = ["+m.date()+"] )");
                    });
                }
            }

        } catch (IntrospectionException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("找不到注解类,CLASS_PATH=["+ CLASS_PATH +"]");
        }

    }



}
