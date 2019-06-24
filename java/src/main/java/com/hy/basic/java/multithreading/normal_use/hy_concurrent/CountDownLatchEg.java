package com.hy.basic.java.multithreading.normal_use.hy_concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @user hy
 * @date sometime
 * @introduce
 **/
public class CountDownLatchEg {

    /**
     *       使用CountDownLatch类保持运行
     *       利用记数器来减数,然后让主线程等待子线程,然后再通过
     */
    public static void countDownLatch() throws InterruptedException {

//        有多少线程,参数则是几
        final CountDownLatch countDownLatch = new CountDownLatch(3);

        for(int i=0; i<3; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行一个线程");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//                   计数器减一
                    countDownLatch.countDown();

//                   计数器减操作会有时间,这样可能最后一二条不显示(因为其他减一,但是最后个线程还在跑),
//                      但是这样的做法是致命的,不能在减后面写代码
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("结束一个线程(这条可能不会显示)");
                }
            });
            thread.start();
        }

//      必须让主线程等待计数器完成
        countDownLatch.await();

    }

}
