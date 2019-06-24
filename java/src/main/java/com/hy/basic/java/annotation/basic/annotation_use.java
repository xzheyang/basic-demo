package com.hy.basic.java.annotation.basic;

import java.beans.*;
import java.lang.reflect.Method;

public class annotation_use {


    @example_meaning(date = "2017.12.26", comments = "empty")
    public void test1() throws ClassNotFoundException, NoSuchMethodException {
        System.out.println("获得注解信息一般靠反射");

        //获得使用注释的方法
        Method method = Class.forName("com.hy.basic.java.annotation.basic.annotation_use").getMethod("test1");
        //获得注释(getAnnotation方法)
        example_meaning a1 = method.getAnnotation(example_meaning.class);

        System.out.println("注释作者(测试版):"+a1.author());

    }


    //上面方法解析注释很多次,应该只解析一次

    private String comments;

    {
        try {
            Method method =this.getClass().getMethod("test2");
            example_meaning a1 = method.getAnnotation(example_meaning.class);
            comments = a1.comments();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    @example_meaning(date = "2017.12.26", comments = "注解")
    public void test2() throws ClassNotFoundException, NoSuchMethodException {

        System.out.println("注释信息(改良版):"+comments);

    }

    //set方法
    @example_meaning(date = "2019.06.20", comments = "empty")
    public void setComments(String comments) {
        this.comments = comments;
    }

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IntrospectionException {
        annotation_use use = new annotation_use();
        //方式一:每次都解析
        use.test1();
        //方法二:只解析一次,但是是在本身方法里
        use.test2();


        //方法三: 内省调用注解(只有set和get方法才会生效)

        //使用内省获得数据,除开父类Object
        BeanInfo nx =Introspector.getBeanInfo(Class.forName("com.hy.basic.java.annotation.basic.annotation_use"),Object.class);
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
            example_meaning a = writeMethod.getAnnotation(example_meaning.class);

            if(a==null){
                System.out.println(writeMethod.getName()+"方法没有em注释");
            }else{
                System.out.println(writeMethod.getName()+"方法有em注释( date = "+a.date()+" )");
            }
        }

    }

}
