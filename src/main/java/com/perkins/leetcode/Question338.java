package com.perkins.leetcode;

/**
 * @author: perkins Zhu
 * @date: 2023/7/18 9:01
 * @description:
 **/
public class Question338 {
//给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，
//计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。

    /***
     *
     *  0
     *  1
     *  10
     *  11
     *  100
     *  101
     *  110
     *  111
     *  1000
     *  1001
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(new Question338().toBinary(10));
    }

    public int[] countBits(int n) {
        return null;
    }

    String toBinary(int num) {
        int[] a = new int[num];
        int count = 0;
        int index = 0;

        String str = "";
        while (num != 0) {

            int x = num % 2;
            if (x == 1) {
                count++;
            }

            str = num % 2 + str;
            num = num / 2;

            System.out.println(index + "  " + count + "   " + str);

            a[index++] = count;

        }
        return str;
    }
}
