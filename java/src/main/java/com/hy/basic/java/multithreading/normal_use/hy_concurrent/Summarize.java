package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

/**
 * @user hy
 * @date sometime
 * @introduce            怎么保证多线程运行完的方式
 **/
public class Summarize {

    /**
     *      特别注意junit除了CountDownLatch这种堵塞主线程的,
     *      其他的主线程执行完毕都是exit杀JVM的
     *
     */
    public static void main(String[] args) throws Exception {

//        CountDownLatchEg.countDownLatch();
        CyclicBarrierEg.cyclicBarrier();
//        SemaphoreEg.semaphore();

        /*
                总结: 1.CountDownLatch是一个线程等待子线程执行完再执行
                        2.CyclicBarrier是多个线程互相等待,一起执行,而且能重用
                            3.Semaphore是类似锁一样的资源占用
         */

    }










}
