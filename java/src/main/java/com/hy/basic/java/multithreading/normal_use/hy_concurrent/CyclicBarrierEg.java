package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @user hy
 * @date sometime
 * @introduce
 **/
public class CyclicBarrierEg {

    /**
     *      利用回环栅栏,实现让一组线程等待至某个状态之后再全部同时执行。
     *      叫做回环是因为当所有等待线程都被释放以后，
     *      CyclicBarrier可以被重用。
     */
    public static void cyclicBarrier() throws InterruptedException, BrokenBarrierException {
        int N = 4;
//        创建回环,如果加入Runnable()接口,会让最后一个到达的程序执行这个接口
        CyclicBarrier barrier  = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("最后一个到达的线程"+Thread.currentThread().getName());
            }
        });

        for(int i=0;i<N;i++)
            new CyclicWriter(barrier).start();

    }


    static class CyclicWriter extends Thread{
        private CyclicBarrier cyclicBarrier;
        public CyclicWriter(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(2000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");

//              await是等待其他的线程,有超时接口
                cyclicBarrier.await();

                Thread.sleep(2000);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

}
