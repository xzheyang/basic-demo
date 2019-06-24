package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

import java.util.concurrent.Semaphore;

/**
 * @user hy
 * @date sometime
 * @introduce
 **/
public class SemaphoreEg {

    /**
     *      使用Semaphore量来操作数据,Semaphore可以控同时访问的线程个数，
     *      通过 acquire() 获取一个许可，如果没有就等待，
     *      而 release() 释放一个许可。
     *
     */
    public static void semaphore() {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for(int i=0;i<N;i++)
            new SemaphoreWorker(i,semaphore).start();
    }

    static class SemaphoreWorker extends Thread{
        private int num;
        private Semaphore semaphore;
        public SemaphoreWorker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
