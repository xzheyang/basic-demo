package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

/**
 * @user yang.he
 * @date 2019/6/25
 * @introduce
 **/
public class ThreadLocalEg {

    //ThreadLocal简单示例
    public static void simple(ThreadLocal<Long> threadLocal) {
        threadLocal.set(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName()+".id="+threadLocal.get());
    }

    public static void main(String[] args) {
        ThreadLocal<Long> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(()->{ simple(threadLocal); });
        Thread thread2 = new Thread(()->{ simple(threadLocal); });

        thread1.start();
        thread2.start();
    }

    /**
     *  用处：保存线程的独立变量
     *
     *  原理:使用TreadLocalMap变量来保存每个线程的变量
     *          (轻量级的Map,会将变量封装为Entry数组[WeakReference(弱引用)接口])
     *
     */
    public static void explain() {

        /*
            WeakReference:
                虽然Entry实现了WeakReference<ThreadLocal>(Entry弱引用了key,然后封装成了ThreadLocal),
                    但是只有在ThreadLocal(也就是key)没有其它(强,软)引用时候才会被GC掉.
                    而当线程结束时,里面的强引用必然会消失,所以不会内存溢出
                    fixme 但是ThreadLocal每个线程使用的都是同1个ThreadLocal,那它的
                    但是当ThreadLocal即key是静态或者被其他一直强引用时才会内存溢出
         */

    }


}
