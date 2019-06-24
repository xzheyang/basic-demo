package com.hy.basic.java.multithreading.basic.hy_thread;

/**
 * @user yang.he
 * @date 2019/6/24
 * @introduce
 **/
public class Thread_Interrupt {


    public static void main(String[] args) throws InterruptedException {

        //1. 线程中断控制运行方法
        Thread thread1 = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("线程运行中");
            }
            System.out.println("线程运行完毕");
        });

//        thread1.start();
//        Thread.sleep(2000);
//        thread1.interrupt();


        //2. 线程阻塞的方法
        Thread thread2 = new Thread(() -> {

            try {
                while (true) {
                    System.out.println("线程运行中");
                    Thread.sleep(50000);
                }
            } catch (InterruptedException e) {
                //里面必须有线程方法
                System.out.println("线程运行完毕");
            }
        });

        thread2.start();
        Thread.sleep(2000);
        thread2.interrupt();

    }


}
