package com.hy.basic.java.multithreading.basic.hy_basic;

public class thread_join implements Runnable{

    public void run() {

        System.out.println("合体");
        try {
            Thread.sleep(1000);
            System.out.println("Loading...");
            Thread.sleep(1000);
            System.out.println("还在合体(其实已经成功,不然主程序先走)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        Thread t0 = new Thread(new thread_join());

        t0.start();

        //合并线程t0到当前线程,意味着t0执行完才会执行主线程
        t0.join();

        for (int i=0;i<5;i++){
            System.out.println("主线程正在运行");
        }


    }

}
