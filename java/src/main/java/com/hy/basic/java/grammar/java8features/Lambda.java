package com.hy.basic.java.grammar.java8features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @user hy
 * @date sometime
 * @introduce            java8的Lambda表达式总结
 **/
public class Lambda {

    /*
          Lambda的详细解释
     */
    public static void main(String[] args) {

        /**
         *
         *  1.Lambda允许函数作为一个方法的参数
         *      所以主要是学习函数式编程
         *
         *  2.只能对于Functional Interface函数式接口(见Java8其他特性)
         *      和只有一个需要实现方法(default的不算)的接口使用
         */

        /*
                函数创建的接收
         */

        //单参数
        GreetingService helloWorld = s-> System.out.println("hello");
        //无参数
        NullParameter noParas = ()->5;

        // 多参数需要类型声明
        MathOperation addition = (int a, int b) -> a + b;
        //不需要
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (a, b) -> { return a * b; };

        //对支持Lambda的方法进行调用
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //见Symbol
        names.forEach(System.out::println);

    }

    //错误点
    public static void error() {
        //lambda只能引用final域外局部变量,也不能在内修改

        //lambda可以访问外层局部变量(可不为final),但不能被后面的代码修改(即隐形的final)
        final int num = 1;
        FuncInterface.Converter<Integer, String> s = (param) -> String.valueOf(param + num);
        s.convert(2);  // 输出结果为 3
    }

    interface NullParameter{
        Integer noParameter();
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}


