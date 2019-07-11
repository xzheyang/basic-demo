package com.hy.basic.java.grammar;

/**
 * @user yang.he
 * @date 2019/7/3
 * @introduce
 **/
public class IFinally {


    public static void main(String[] args) {
        explain();
//        invalid();
    }


    public static void explain() {

        /**
         *  在Java语言的异常处理中，finally块的作用就是为了保证无论出现什么情况，finally块里的代码一定会被执行。
         *  由于程序执行return就意味着结束对当前函数的调用并跳出这个函数体，
         *  因此任何语句要执行都只能在return前执行（除非碰到exit函数），
         *  1. 因此finally块里的代码也是在return之前执行的。
         *  2. 此外，如果try-finally或者catch-finally中都有return，
         *  那么finally块中的return将会覆盖别处的return语句，
         *  最终返回到调用者那里的是finally中return的值。
         *  3. finally只能改变引用传递的值,而不能直接改变值传递的值
         *
         */

        System.out.println(testFinallyReturn());
        System.out.println(testFinallyValue());
        System.out.println(testFinallyReference());


    }


    public static int testFinallyReturn() {
        try {
            return 1;
        } catch (Exception e) {
            return 0;
        } finally {
            System.out.println("execute finally");
            return 3;
        }
    }

    //值传递不会更改具体返回数值,执行到return时会首先将返回值存储在一个指定的位置，其次去执行finally块
    public static int testFinallyValue(){
        int result = 1;
        try {
            result = 2;
            return result;
        } catch (Exception e) {
            return 0;
        }finally{
            result = 3;
            System.out.println("execute finallyValue");
        }
    }

    //引用传递才会改变具体数值
    public static StringBuffer testFinallyReference(){
        StringBuffer s = new StringBuffer("Hello");
        try {
            return s;
        } catch (Exception e) {
            return null;
        }finally{
            s.append(" World");
            System.out.println("execute finallyReference");
        }
    }


    //失效的情况
    public static void invalid() {

        /*
            1.当遇到exit的情况下
         */

        System.out.println("enter invalid()");
        try {
            System.out.println("enter try block");
            System.exit(0);
        } finally {
            System.out.println("enter finally block");
        }

        /*
            2.  非守护线程被kill掉
                java线程分为两类，守护线程和非守护线程。当所有的非守护线程中止时，不论存不存在守护线程，虚拟机都会kill掉守护线程从而中止程序。
                虚拟机中，执行main方法的线程就是一个非守护线程，垃圾回收则是另一个守护线程，main执行完，程序就中止了，而不管垃圾回收线程是否中止。
                所以，如果守护线程中存在finally代码块，那么当所有的非守护线程中止时，守护线程被kill掉，其finally代码块是不会执行的。

         */

    }

}
