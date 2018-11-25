package com.hy.basic.java.multithreading.basic.hy_basic;

public class thread_yield implements Runnable {


    public void run() {

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
            //让出线程
            Thread.yield();
        }

    }


    public static void main(String[] args) throws InterruptedException {

        Thread t0  = new Thread(new thread_yield());
        Thread t1 = new Thread(new thread_yield());

        t0.start();
        t1.start();

        //设置优先级(10 max,5 normal,1 min)
        //t0.setPriority(10);
        //t1.setPriority(1);


    }

}
