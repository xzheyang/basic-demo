package com.hy.basic.algorithm.title;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequence {


    public static void title() {
        /**
         *  给定长度为N的数组A，计算A的最长单调递增的子序列（不一定连续）。如给定数组A{5，6，7，1，2，8}，则A的LIS为{5，6，7，8}，长度为4.
         *
         */

    }


    public static void main(String[] args) {

        System.out.println("result = [" + answer(new int[]{1,5,6,2,3,4,7}) + "]");
        System.out.println("result = [" + answer2(new int[]{1,5,6,2,3,4,7}) + "]");
        System.out.println("result = [" + answer2WithArray(new int[]{1,5,6,2,3,4,7}) + "]");
//        int[] array = answer2WithArray(new int[]{1, 5, 6, 2, 3, 4, 7});
//        for (int i=0; i<array.length; i++) {
//            System.out.println("result["+i+"] = "+array[i]  );
//        }

    }

    /**
     *  Greedy Algorithm
     *  思路:   求连续长度,只要数字尽可能小往前排列(而且不影响后面判断:小的尽可能在前必然是对的),最后计算出来的长度就是最大值
     *              特质: 1.存放1个数组保存当前连续的数字
     *                      2.插入比较队末尾,如果比末尾值大,插入到后面;如果是小值替换前面比她大的第一个值(包括最后1个)
     *                          3.保证后面判断信息不丢失(小:只替换第一个比它大的值(小的来比更不会丢失信息))(大:比它还大的替换了更能组成最优解)
     *
     *              缺点:只能计算长度,不能获得列（可能可以获得）
     *
     */
    public static int answer(int[] arry) {
        if (arry==null||arry.length==0)
            return 0;

        int result[] = new int[arry.length];

        int longestIncrNum = 1;
        result[0] = arry[0];

        for (int i=1; i<arry.length; i++) {
            for (int j=0; j<arry.length; j++){
                if (result[j]>arry[i]){
                    result[j]=arry[i];
                    break;
                }
                if (result[j]==0){
                    result[j]=arry[i];
                    longestIncrNum++;
                    break;
                }
            }
        }


        return longestIncrNum;
    }


    /**
     *     dynamic programming
     *      思路:     因为是递增数组,直接求最开始的数组和以最末数组之间的可能出现的最大递增数
     *                  特质  1.拥有一个数组保存当前计算数组的最大值
     *                          2.规避中间错误数据: 只计算比当前最后1个节点小的数且之前计算的下标大于现在循环的下标值(结尾是当前数且以原来最大顺序值做前缀)
     *                              3.最后比较当前下标存放最大值和result,取最大为result
     *                  总结:  根据之前每个作为节点推断出的最大递增数,再根据现有结尾和原有结尾进行比较,获得结果
     */
    public static int answer2(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        int[] b = new int[A.length];
        b[0] = 1;
        int result = 1;
        for(int i=1; i<A.length; i++) {
            int max = -1;
            for(int j=0; j<i; j++) {
                if(A[j] < A[i] && b[j] > max)
                    max = b[j];
            }
            b[i] = max + 1;
            result = Math.max(result, b[i]);
        }
        return result;
    }

    /**
     *  在返回数字的基础上,再返回原有数组
     *      思路:原有dynamic programming再加上list的结构
     *
     */
    public static List<Integer> answer2WithArray(int[] A) {
        if(A == null || A.length == 0)
            return null;


        int lastIndex = -1;
        int longest = 0;

        //记录前驱
        int[] indexLink = new int[A.length];

        //记录推断出来每个结尾数的最长连续数量
        int[] longestNum = new int[A.length];
        longestNum[0] = 1;


        for(int i=1; i<A.length; i++) {
            int max = -1;
            int preIndex = 0;

            List[] tmp = new ArrayList[A.length];
            for(int j=0; j<i; j++) {
                if(A[j] < A[i] && longestNum[j] > max){
                    max = longestNum[j];
                    preIndex = j;
                }
            }

            //计算前面最长加上这个的结果
            longestNum[i] = max + 1;

            //记录前驱
            indexLink[i] = preIndex;

            //记录最后index
            if (longestNum[i]>longest){
                longest = longestNum[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(;lastIndex >0; ) {
            res.add(A[lastIndex]);
            lastIndex = indexLink[lastIndex];
            if (lastIndex==0)
                res.add(A[lastIndex]);
        }
        Collections.reverse(res);
        

        return res;
    }






}
