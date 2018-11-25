package com.hy.basic.algorithm;

public class base01 {


    public static int myRUP(int a,int b){

        if(b==0) return 0;
        if(b%2==0) return myRUP(a+a,b/2);
        return myRUP(a+a,b/2)+a;            //不能被2整除就加b^第几次    2,25-->25 (12,6,) 3 1 返回值是b+b^4+b^5
    }

    public static int myRUP2(int a,int b){

        if(b==0) return 1;
        if(b%2==0) return myRUP2(a*a,b/2);
        return myRUP2(a*a,b/2)*a;            //不能被2整除就加2    2,25-->25 (12,6,) 3 1 返回值是b*b^8*b^16*1
    }

    public static void main(String[] args) {



        //算法第一章课后习题

        System.out.println("习题1");
        System.out.println((0+15)/2);
        System.out.println(2.0e-6*1000000.1);
        System.out.println(true&&false||true&&true);

        System.out.println("习题2");
        System.out.println((2+2.0)/2);
        System.out.println(4.1>4);
        System.out.println(5+5+"5");
        System.out.println(1/2);


        System.out.println("迭代1");
        System.out.println(base01.myRUP(2,25));
        System.out.println("迭代2");
        System.out.println(base01.myRUP2(2,25));
        System.out.println(2*Math.pow(2,8)*Math.pow(2,16)*1);
    }
}
