package com.hy.basic.java.multithreading.basic.hy_basic;

public class thread_start {

    final public static String TEST="I do it";

    public static void main(String[] args) throws InterruptedException {

        Thread t0 = new thread_create1_notify();                  //继承Thread类的线程

        Thread t1 = new Thread(  new thread_create0_wait() );     //实现Runnable接口的线程(也可用匿名内部类)

        //t0.run();    //这里只是执行run方法
        t0.start();  //start方法才是启动线程

        Thread.sleep(666);  //sleep进入冻结时间,并不会释放锁
        t1.start();


        //0.wait线程进入冻结除非资源被唤醒,notify唤醒一个访问这个资源的线程,notifyAll唤醒访问该资源的全部线程(消费者问题重要)
        //1.wait,notify,notifyAll需要对象级锁
        //2.wait释放锁,notify不释放锁,执行完才释放





    }

}
