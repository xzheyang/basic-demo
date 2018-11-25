package com.hy.basic.java.annotation.basic;

public class usual_annotation extends Thread {

    @Override       //检查它是否重写方法   ,根据它的@Retention说明它只能用作方法
    public void run() {
        super.run();
    }

    @Deprecated     //废弃        @Retention全部
    public static void oldMethod() {
        System.out.println("过时的老方法");
    }

    @SuppressWarnings("deprecation")    //取消废弃警告,还可以取消很多警告      @Retention全部
    public static void main(String[] args) {

        usual_annotation.oldMethod();

    }


}
