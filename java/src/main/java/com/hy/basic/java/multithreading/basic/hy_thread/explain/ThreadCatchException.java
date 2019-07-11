package com.hy.basic.java.multithreading.basic.hy_thread.explain;

/**
 * @user yang.he
 * @date 2019/7/10
 * @introduce       线程异常
 **/
public class ThreadCatchException {


    public static Thread getThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试开始");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                throw new RuntimeException("异常出现");

            }
        });

        return thread;
    }

    public static void main(String[] args) {
        Thread thread = getThread();

        //线程捕获异常不能直接try catch
        thread.setUncaughtExceptionHandler(new IUnCheckedExceptionHandler());
        thread.start();


    }



    public static class IUnCheckedExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("捕获异常处理方法：" + e);
        }
    }


}
