package com.hy.basic.java.multithreading.basic.hy_thread.explain;

import java.util.concurrent.*;

/**
 * @user yang.he
 * @date 2019/6/24
 * @introduce       线程
 **/
public class ThreadCreate {


    /**
     * 线程的创造:
     *
     * 	1.创造继承Thread类的子类,或实现Runnable接口,或使用Callable、FutureTask实现有返回结果的多线程
     *
     * 	2.重写run()方法
     *
     * 	3.执行父类的start()方法
     *
     * 	注意:Thread类没有抛出异常,所以不要用throw,出现异常异常线程就中断
     *
     */
    public static void main(String[] args) {

        Thread threadCreateExample1 = new Example_Thread();
        Thread threadCreateExample2 = new Thread(() -> System.out.println("实现Runnable接口创造线程"));


        threadCreateExample1.run();     //错误的使用
        threadCreateExample2.start();


        ExecutorService e = Executors.newFixedThreadPool(3);
        //submit方法有多重参数版本，及支持callable也能够支持runnable接口类型.
        Future future = e.submit(new Example_Callable());
        future.isDone(); //return true,false 无阻塞
        try {
            future.get(); // return 返回值，阻塞直到该线程运行结束
        } catch (InterruptedException | ExecutionException er) {
            er.printStackTrace();
        }

    }


    static class Example_Thread extends Thread {

        @Override
        public void run() {
            System.out.println("继承Thread创造线程(使用正确这里不阻塞)");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Example_Callable implements Callable {

        @Override
        public Object call() throws Exception {

            System.out.println("实现Callable接口,使用ExecutorService创造Future线程");

            return null;
        }
    }

}
