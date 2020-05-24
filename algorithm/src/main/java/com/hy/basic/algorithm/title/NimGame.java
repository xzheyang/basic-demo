package com.hy.basic.algorithm.title;

public class NimGame {

    public static void title() {
        /**
         *  你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
         *
         * 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。
         *
         */

    }


    public static void main(String[] args) {

        System.out.println("result = [" + answer(13) + "]");

    }


    public static boolean answer(int sum) {
        //我的思路(穷举):   1~3能赢,4不能赢,5~7能赢,8~10不能赢,11~13能赢
        //                       穷举发现规律,让人不得不走4,8,12
        //
        if (sum%4==0){
            return true;                //时间&空间复杂度O(1)
        }

        return false;
    }

}
