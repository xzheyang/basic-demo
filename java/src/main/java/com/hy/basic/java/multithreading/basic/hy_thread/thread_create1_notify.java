package com.hy.basic.java.multithreading.basic.hy_thread;

public class thread_create1_notify extends Thread {

    //例子在run运行

    //notify:   线程唤醒,不释放锁,还是会执行后面代码

    @Override
    public void run() {
        System.out.println("继承Thread并重写run方法,创造线程1");

        try {
            Thread.sleep(500);
            System.out.println("在Runnable创建之前,代表t1的数据进入冻结状态");
            Thread.sleep(500);
            System.out.println("在Runnable创建之前,代表没有开启线程,只是使用方法");


            synchronized (thread_start.TEST){
                System.out.println("马上唤醒1个线程");
                //线程唤醒,不释放锁
                thread_start.TEST.notify();
                System.out.println("但需要执行完这个,才释放锁");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     *  notify执行时不会释放锁
     */
    public static void main(String[] args) {

    }
}
