package com.hy.basic.java.multithreading.basic.hy_synchronized;

public class s_basic {

    final private Integer x=0;
    final private static Integer xx=0;

    //锁住的是对象 (实例锁)
    public synchronized void test01() throws InterruptedException {
        System.out.println("1begin");
        Thread.sleep(1000);
        System.out.println("1Ending");
    }

    //锁住的是类 (类锁)[实例和类锁互不干扰]
    public static synchronized void test02() throws InterruptedException {
        System.out.println("2begin");
        Thread.sleep(1000);
        System.out.println("2Ending");
    }

    public void test03() throws InterruptedException {


        synchronized (this){  //锁实例,()里面是要锁住的东西
            System.out.println("3begin");
            Thread.sleep(1000);
            System.out.println("3Ending");

        }
    }

    public static void test04() throws InterruptedException {


        synchronized (s_basic.class){ //锁类
            System.out.println("4begin");
            Thread.sleep(1000);

            System.out.println("4Ending");
        }


    }


    public void test05() throws InterruptedException {


        synchronized (xx){ //锁静态数据
            System.out.println("数据:"+xx);
            //xx++;                             加值后,不就是用的其他锁了吗??
            Thread.sleep(1000);
            synchronized (xx) { //可重入锁 :当线程请求一个由其它线程持有的对象锁时，该线程会阻塞，
                                // 而当线程请求由自己持有的对象锁时，如果该锁是重入锁,请求就会成功，否则阻塞。
                                //就比如同时运行一个对象的
                System.out.println("数据更新:"+xx);
            }

        }


    }


    public static void main(String[] args) throws InterruptedException {

        s_basic s = new s_basic();

        for (int i = 0; i < 3; i++) {
            Thread thread = s.new MyThread();
            thread.start();
        }

//        s_basic sb = new s_basic();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    sb.test03();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        sb.test01();



    }


    //成员内部类
    class MyThread extends Thread {

        public void run() {

            try {
                test05();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

/*外部类,一个java文件只能有一个public类,不建议这么做,因为会其他类会覆盖这种外部类,出现未知错误
class MyThread extends Thread {

    public void run() {
        s_basic s = new s_basic();

        try {
            s.test01();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}*/
