package com.hy.basic.java.multithreading.basic.hy_thread.explain;

/**
 * @user yang.he
 * @date 2019/6/24
 * @introduce
 **/
public class ThreadKeyWords {

    /**
     *
     * 关键词:
     *
     * 	synchronized:	线程绑定,只有一个线程可以使用当前对象
     *
     * 	1.放在方法声明中,表示整个方法为同步方法
     *
     * 	2.synchronized(this){}执行到此语句则,绑定对象到当前线程(this代表对象,可换成其他),当然也可以锁类xx.class.    //但是注意
     *
     * 	3.普通方法是对象(实例)锁,静态方法是类锁
     * 	注意:线程死锁(两个或以上对象被锁死在一个线程里),最好只锁定一个对象
     *
     *
     *
     * 	volatile:禁止进行指令重排序,保证了不同线程对这个变量进行操作时的可见性
     *
     * 	1.使用volatile关键字会强制将修改的值立即写入主存
     *
     * 	2.当其他线程修改这个变量,会导致其它线程的这个变量缓存失效,而去读取主存的值,从而实现可见性
     *
     */

}
