package com.hy.basic.java.grammar.java8features;

/**
 * @user hy
 * @date sometime
 * @introduce        java8新特性:   通过 default 关键字对接口中定义的抽象方法
 *                                              提供一个默认的实现。
 *                                 现在接口还能实现静态方法
 **/
public class NewInterface {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        double calculate = formula.calculate(100);// 100.0
        double sqrt = formula.sqrt(16);// 4.0

        System.out.println("自定义计算 = [" + calculate + "]");
        System.out.println("默认接口计算 = [" + sqrt + "]");


    }

    // 定义一个公式接口
    interface Formula {
        // 计算
        double calculate(int a);

        // 默认方法求平方根
        default double sqrt(int a) {
            return Math.sqrt(a);
        }

        //静态方法求平方根
        static double sqrtStatic(int a) {
            return Math.sqrt(a);
        }

    }

}



