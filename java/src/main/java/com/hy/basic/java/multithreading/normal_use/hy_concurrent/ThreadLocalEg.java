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
     *  原理:使用TreadLocalMap变量来保存每个线程的变量,而Thread也会保存TreadLocalMap
     *          (轻量级的Map,会将变量封装为Entry数组[WeakReference(弱引用)接口])
     *
     */
    public static void methodExplain() {

         /*
            ThreadLocalMap:
                    每个Thread类会有一份保存不同的ThreadLocal的Entry的集合(不同ThreadLocal只会拿到自己的数据)
                    ThreadLocal也因此访问不同线程的数据的独立的.
         */


         /*
            get/set：
                get通过获得不同Thread对象中ThreadLocal.ThreadLocalMap的本ThreadLocal对象的Entry来获得值
                set通过操作本ThreadLocal的指定Thread中ThreadLocal.ThreadLocalMap来更新或者新建map
          */


        /*
            WeakReference:
                虽然Entry实现了WeakReference<ThreadLocal>(Entry弱引用了key,然后封装成了ThreadLocal),
                    但是只有在ThreadLocal(也就是key)没有其它(强,软)引用时候才会被GC掉.
                    而当线程结束时,里面的强引用必然会消失,所以不会内存溢出
                    fixme 而thread引用了ThreadLocal.ThreadLocalMap(里面包含Entry数组)来保证不同ThradLocal引用
                    // fix 但是当ThreadLocal即key是静态或者被其他一直强引用时才会内存溢出
         */


    }

    public static void deviseExplain(String[] args) {

        /*
            为什么ThreadLocal没有锁的概念
                a.添加新map不会有问题吗
                b.老的map的新set操作导致扩容不会导致同时操作的不同线程发生错误吗
                c.get因为本质是1个线程不会发生问题
         */

        /*
            为什么线程和值的key-value形式是通过ThreadLocalMap这种绑定的方式实现的?
                a.如果通过不同ThreadLocal自己以保存key-value线程id-值的方式，必须需要加锁来实现(因为不同线程添加值时,可能会把同时访问的值覆盖掉)

         */


    }


}
