package com.hy.basic.java.multithreading.basic.hy_basic;

public class thread_volatile implements Runnable{

    private volatile String fish="salt fish";
    //及时更新到主内存,从而实现分内存都更新
    //阻止优化指令(即指令乱序)


    public void run() {
        System.out.println(Thread.currentThread().getName()+fish);

        try {
            Thread.sleep(500);
            fish="normal fish";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName()+fish);
        }

    }


    public static void main(String[] args) {

        Thread t0  = new Thread(new thread_volatile());
        Thread t1 = new Thread(new thread_volatile());

        t0.start();
        t1.start();

    }


}
