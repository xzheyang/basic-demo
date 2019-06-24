package com.hy.basic.java.multithreading.basic.hy_thread.explain;

/**
 * @user yang.he
 * @date 2019/6/24
 * @introduce
 **/
public class ThreadMethod {

    /**
     * 方法:
     *
     * 	run():储存非主线程的代码(直接使用它,不会创造一个新线程)
     *
     * 	start():执行run方法
     *
     * 	join():合并此线程到当前线程
     *
     * 	Thread.yield():让出线程,让其他线程先执行(只先执行几次)
     *
     * 	setName():设置进程名称(构造方法也行)
     *
     * 	setPriority():设置执行优先级(1-10,Thread.NORM_PRIORITY=5为默认)
     *
     * 	sleep,wait():使线程睡眠,等待[单位毫秒](注意:wait会释放锁,sleep会继续保持锁)
     *
     * 	stop():消亡[弃用,原因是]
     *
     * 	notify():激活等待这个对象锁的一个线程,除了消亡的线程
     *
     * 	notifyAll():激活等待这个对象锁的所有线程,除了消亡的线程
     *
     *  interrupt():
     * 	Thread.interrupted():检查当前线程是否发生中断
     *
     */

    public static void main(String[] args) {

    }

}
