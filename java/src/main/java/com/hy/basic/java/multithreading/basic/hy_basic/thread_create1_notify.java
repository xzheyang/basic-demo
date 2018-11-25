package com.hy.basic.java.multithreading.basic.hy_basic;

public class thread_create1_notify extends Thread {

    //例子在run运行

    @Override
    public void run() {
        System.out.println("继承Thread并重写run方法,创造线程1");

        try {
            Thread.sleep(500);
            System.out.println("在Runnable创建之前,代表t1的数据进入冻结状态");
            Thread.sleep(500);
            System.out.println("在Runnable创建之前,代表没有开启线程,只是使用方法");


            synchronized (thread_start.TEST){
                System.out.println("线程1唤醒");
                //线程唤醒,不释放锁
                thread_start.TEST.notify();
                System.out.println("但需要执行完这个,才释放锁");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
