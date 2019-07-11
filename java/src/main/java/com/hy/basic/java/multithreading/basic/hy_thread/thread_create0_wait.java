package com.hy.basic.java.multithreading.basic.hy_thread;

public class thread_create0_wait implements Runnable {

    //wait: 将线程挂起,并且释放锁

    //例子在run运行
    public void run() {         //线程不能throw异常,因为出现异常异常线程就中断
        System.out.println("实现Runnable接口的run方法,创造线程2");


        //不是锁这个TEST,而是说看到这个TEST上有相同类型的锁就锁住了,不往下执行
        synchronized (thread_start.TEST){
            System.out.println("线程2冻结");

            try {
                //进入线程冻结,释放锁
                System.out.println("线程2释放锁");
                thread_start.TEST.wait();     //wait执行时会释放锁


                System.out.println("线程2再次获得锁");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread_start.TEST);
        }

    }


    /**
     *  wait延迟
     *  wait执行时会释放锁
     */
    public static void main(String[] args) {


    }

}
