package com.hy.basic.java.multithreading.basic.hy_thread;

public class thread_join implements Runnable{

    //join: 当我们调用某个线程的这个方法时，这个方法会挂起调用线程，直到被调用线程结束执行，调用线程才会继续执行。

    public void run() {

        System.out.println("合体");
        try {
            Thread.sleep(1000);
            System.out.println("Loading...");
            Thread.sleep(1000);
            System.out.println("合体完成(调用线程开始运行)");

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
