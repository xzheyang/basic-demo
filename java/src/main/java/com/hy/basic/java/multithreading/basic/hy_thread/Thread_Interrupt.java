package com.hy.basic.java.multithreading.basic.hy_thread;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @user yang.he
 * @date 2019/6/24
 * @introduce
 **/
public class Thread_Interrupt {


    public static void main(String[] args) throws InterruptedException {

        //1.中断非阻塞
//        method1();
        //2.中断阻塞
//        method2();
        //3.中断不可停止
        method3();

        //stop可暴力停止,但是会出现
    }


    //1. 中断非阻塞线程
    volatile private static boolean isStop = false;
    public static void method1() throws InterruptedException {

        //1.1 通过线程中断机制
        Thread thread1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                if (LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()%1000==0){
                    System.out.println("线程1运行中");
                }
            }
            System.out.println("线程1运行完毕");
        });

        thread1.start();
        Thread.sleep(2000);
        thread1.interrupt();

        //1.2 通过共享变量
        Thread thread2 = new Thread(() -> {
            while (!isStop) {
                if (LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli()%1000==0){
                    System.out.println("线程2运行中");
                }
            }
            System.out.println("线程2运行完毕");
        });

        thread2.start();
        Thread.sleep(2000);
        isStop = true;

    }

    //2. 中断阻塞线程
    public static void method2() throws InterruptedException {
        //2. 线程阻塞的方法
        Thread thread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程运行中");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    //当阻塞方法被中断时,会抛出InterruptedException异常,并且将中断标志重新置为未中断,所以必须将其置为中断
                    Thread.currentThread().interrupt();
                    System.out.println("线程被中断");
                }
            }

        });

        thread2.start();
        Thread.sleep(2000);
        thread2.interrupt();
    }


    //3. 不可中断线程

    /**
     * 3. 不可中断线程
     *      当代码中有synchronized或者lock代码时,是不能被中断的
     *          只有reentrantLock.tryLock(time)或者reentrantLock.lockInterruptibly(相当于无限时间的tryLock(Time))有解锁的能力,并且可打破死锁,但却没释放锁
     *
     */
    public static void method3() throws InterruptedException {

        final Object lockObj1 = new Object();
        final Object lockObj2 = new Object();
        ReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReadWriteLock lock2 = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            deathLock(lock1, lock2);
        }, "A");
        Thread t2 = new Thread(() -> {
            deathLock(lock2, lock1);
        }, "B");

        t1.start();
        t2.start();

        Thread.sleep(2000);
        // 中断线程t1、t2
        t1.interrupt();
        t2.interrupt();
    }


    private static void deathLock(ReadWriteLock lock1,ReadWriteLock lock2) {

        Lock writeLock1 = lock1.writeLock();
        Lock writeLock2 = lock2.writeLock();

        try {

            writeLock1.lockInterruptibly();
            try{
                System.out.println(Thread.currentThread().getName()+ " is running");
                Thread.sleep(10);
                try {
                    writeLock2.lockInterruptibly();
                    try {
                        System.out.println(Thread.currentThread().getName());
                    }finally {
                        writeLock2.unlock();
                    }
                }catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+ " is interrupted");
                    e.printStackTrace();
                }
            }finally {
                writeLock1.unlock();
            }

        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+ " is interrupted");
            e.printStackTrace();
        }

    }

    public void deathLockNotInerr(Object lock1, Object lock2) {
        try {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName()+ " is running");
                // 让另外一个线程获得另一个锁
                Thread.sleep(10);
                // 造成死锁
                synchronized (lock2) {
                    System.out.println("死锁:"+Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+ " is interrupted");
            e.printStackTrace();
        }
    }

}
