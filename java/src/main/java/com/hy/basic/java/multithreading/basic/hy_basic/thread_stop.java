package com.hy.basic.java.multithreading.basic.hy_basic;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Description:
 *
 * @author hy
 * Create in 2018/4/22 20:16
 */
public class thread_stop {


    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("线程1启动");

                while (true){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("线程1运行中");
                }
            }
        };

//        t1.start();
//        Thread.sleep(7000);
//        t1.stop();

        /**
         * 为什么过时:
         *
         *1.stop方法会导致代码逻辑不完整
         * stop方法是一种"恶意" 的中断,一旦执行stop方法,即终止当前正在运行的线程,不管线程逻辑是否完整,这是非常危险的.
         *
         *2.stop方法会破坏原子逻辑
         *  stop方法却会带来更大的麻烦,它会丢弃所有的锁,导致原子逻辑受损
         *
         *  改进:
         *
         *1.使用volatile
         *
         *2.run里关联interrupt方法
         *
         *注意:   interrupt不能终止一个正在执行着的线程,它会修改中断标志位(isInterrupted方法),且遇到阻塞抛出异常.
         *          如果线程被wait, join和sleep三种方法之一阻塞，
         *          此时调用该线程的interrupt()方法，那么该线程将抛出一个 InterruptedException中断异常
         *          （该线程必须事先预备好处理此异常），从而提早地终结被阻塞状态。
         *          如果线程没有被阻塞，这时调用 interrupt()将不起作用，
         *          直到执行到wait(),sleep(),join()时,才马上会抛出 InterruptedException。
         **/

//        MySafeThread t2_safeThread = getInner();
//
//        t2_safeThread.start();
//        Thread.sleep(2666);
//        System.out.println("线程2安全终止");
//        t2_safeThread.stopThread();





        Thread t3_safeThread = new Thread(){
            @Override
            public void run() {
                while (!Thread.interrupted()){
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程3总想做点什么");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        //必须重新设置一下当前线程中断标示，因为抛出InterruptedException异常后，中断标示位会自动清除
                    }
                }
            }
        };
        t3_safeThread.start();


        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("终结线程3的想法");
                t3_safeThread.interrupt();
            }
        }, 4666);

    }

    //非静态方法访问内部类
    public static MySafeThread getInner() {
        thread_stop out = new thread_stop();
        MySafeThread in = out.new MySafeThread();
        return in;
    }


    class MySafeThread extends Thread{
        volatile boolean sign=true;

        public void stopThread(){
            sign=false;
        }

        @Override
        public void run() {
            while (sign==true){
                try {
                    System.out.println("线程2还未终止");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }

    }


}
