package com.hy.basic.java.multithreading.normal_use.hy_threadloacl;

public class ThreadLocalDeep {


    public static void deviseTitle() {

        /*
               大概介绍:
                    https://www.jianshu.com/p/98b68c97df9b

                Transmittable ThreadLocal(TTL)
                    https://www.jianshu.com/p/9fcbd499a1f6


         */


    }


    public static void deviseExplain() {

        /*

            一.避免线程冲突设计

                1.为什么ThreadLocal没有锁的概念
                    a.添加新map不会有问题吗
                    b.老的map的新set操作导致扩容不会导致同时操作的不同线程发生错误吗
                     解答: 因为本质是1个线程操作1个ThreadLocalMap所以不会发生问题

                2.为什么线程和值的key-value形式是通过ThreadLocalMap这种绑定的方式实现的?
                    a.如果通过不同ThreadLocal自己以保存key-value线程id-值的方式，必须需要加锁来实现(因为不同线程添加值时,可能会把同时访问的值覆盖掉)

                3.同一线程有不同的ThreadLocal怎么办
                    a.是用ThreadLoaclMap方式在Thread中存储,而且因为线程自己控制的代码,所以避免了冲突

            二:ThreadLocalMap的Hash冲突

                1.采用线性探测的方式: 如果发现这个位置上已经有其他key值的元素被占用，则利用固定的算法寻找一定步长的下个位置.
                     建议最好1个线程只存一个变量,否则多个变量要存储多个ThreadLocal,增加Hash冲突的可能

         */


    }


    public static void deviseDetails() {

        /*
            一.地址寻找
                https://www.jianshu.com/p/56f64e3c1b6c

         */


    }


}
