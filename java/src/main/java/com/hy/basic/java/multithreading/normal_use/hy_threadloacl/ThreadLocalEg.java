package com.hy.basic.java.multithreading.normal_use.hy_threadloacl;

/**
 * @user yang.he
 * @date 2019/6/25
 * @introduce
 **/
public class ThreadLocalEg {


    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(()-> simpleUse(threadLocal));
        Thread thread2 = new Thread(()-> simpleUse(threadLocal));

        thread1.start();
        thread2.start();


    }


    //ThreadLocal简单使用示例
    public static void simpleUse(ThreadLocal<Long> threadLocal) {
        threadLocal.set(Thread.currentThread().getId());                                    //设置每个线程单独的值
        System.out.println(Thread.currentThread().getName()+".id="+threadLocal.get());      //获得每个线程单独的值
        threadLocal.remove();                                                               //删除每个线程单独的值(防止内存溢出)
    }

    /**
     *  用处：保存线程的独立变量
     *
     *  应用场景:    eg: 独立的Session会话
     *
     *  原理:使用TreadLocalMap变量来保存每个线程的变量,而Thread也会保存TreadLocalMap
     *          (轻量级的Map,会将变量封装为Entry数组[WeakReference(弱引用)接口])
     *
     */
    public static void methodExplain() {

         /*
            [struct]ThreadLocalMap(核心):
                        每个Thread类会有一份保存不同的ThreadLocal的Entry的集合(不同ThreadLocal只会拿到自己的数据)
                        ThreadLocal也因此访问不同线程的数据的独立的.
         */


         /*
            get/set：
                get通过获得不同Thread对象中ThreadLocal.ThreadLocalMap的本ThreadLocal对象的Entry来获得值
                set通过操作本ThreadLocal的指定Thread中ThreadLocal.ThreadLocalMap来更新或者新建map
          */


        /*
            remove

            WeakReference(弱引用):
                虽然Entry实现了WeakReference<ThreadLocal>(Entry弱引用了ThreadLocal,不同ThreadLocal的引用不一样),
                    但是只有在ThreadLocal(也就是key)没有其它(强,软)引用时候才会被GC掉.
                    而当线程结束时,里面的强引用必然会消失,所以不会内存溢出
                    attention: 但是线程池可能会导致问题出现内存溢出(应该用完后清理)或者脏数据(业务问题)的问题
                    因为ThreadLocal-->Entry被回收了,但是Thread-->ThreadLocalMap-->Entry未被回收

                防止内存溢出
                    1.remove方法
                    2.java8中会回收过期的ThreadLocalMap中的值
                            set 方法通过调用 replaceStaleEntry 方法回收键为 null 的 Entry 对象的值,
                            get方法会间接调用expungeStaleEntry 方法将键和值为 null 的 Entry 设置为 null 从而使得该 Entry 可被回收;


         */


    }




}
