package com.hy.basic.java.multithreading.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/**
 *
 * 要求:
 * 1.要同时起跑,进入下一个任务
 * 2.要所有运动员都到达终点以后才能进行下一个任务
 * 3.如果有一个运动员摔跤了（异常处理），就终止这次比赛，
 *      让所有运动员都到终点进行下一个任务。
 *
 *
 */

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new Next());

        Thread p1 = new Thread(new Test2Runable(cyclicBarrier, 0));
        Thread p2 = new Thread(new Test2Runable(cyclicBarrier, 0));
        Thread p3 = new Thread(new Test2Runable(cyclicBarrier, 1));
        p1.start();
        p2.start();
        p3.start();
    }

    static class Next implements Runnable{

        @Override
        public void run() {
            System.out.println("最后一名完成的"+Thread.currentThread().getName() + "宣布:进入下个环节");
        }
    }

    static class Test2Runable implements Runnable{
        CyclicBarrier cyclicBarrier;
        int flag;
        public Test2Runable(CyclicBarrier cb, int flag) {
            this.cyclicBarrier = cb;
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                //等待前
                Thread.sleep((long) (3000 + Math.random()));
                System.out.println(Thread.currentThread().getName() + "-thread:已准备！" + "->前面有" + cyclicBarrier.getNumberWaiting() + "人准备好了");
                cyclicBarrier.await();

                System.out.println(Thread.currentThread().getName() + "-thread:开始跑！");
                if(flag == 1){
                    throw new Exception("错误");
                }
                Thread.sleep((long) (3000 + Math.random()));
                System.out.println(Thread.currentThread().getName() + "-thread:到达终点");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + "-thread:准备下一个任务");
            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + "-thread:我摔倒了");

                try {
                    System.out.println(Thread.currentThread().getName() + "-thread:终止这场比赛,传送去终点");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + "-thread:准备下一个任务");
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (BrokenBarrierException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }

    }
}
