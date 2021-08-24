package com.perkins.leetcode;

import java.util.Arrays;

/**
 * @author: perkins Zhu
 * @date: 2021/8/24 9:43
 * @description:
 **/
public class Question1815 {

    public static void main(String[] args) {

        Question1815 q = new Question1815();
//        int batchSize = 3;
//        int[] groups = new int[]{1, 2, 3, 4, 5, 6};
//        int batchSize = 6;
//        int[] groups = new int[]{369205928,981877451,947462486,899465743,737778942,573732515,520226542,824581298,571789442,251943251,70139785,778962318,43379662,90924712,142825931,182207697,178834435,978165687};
        int batchSize = 8;
        int[] groups = new int[]{244197059, 419273145, 329407130, 44079526, 351372795, 200588773, 340091770, 851189293, 909604028, 621703634, 959388577, 989293607, 325139045, 263977422, 358987768, 108391681, 584357588, 656476891, 621680874, 867119215, 639909909, 98831415, 263171984, 236390093, 21876446};
        int res = q.maxHappyGroups(batchSize, groups);
        System.out.println(res);

    }

    public int count(int batchSize, int[] groups) {
        int count = 0;
        int remainder = 0;
        for (int i = 0; i < groups.length; i++) {
            //是否满意只和上一波是否有剩下有关，上一波没有剩下，则这一波就会满意
            if (remainder == 0) {
                count++;
            }
            int num = groups[i] - remainder;
            //上一波上下的就满足了这一波，则继续剩下
            if (num < 0) {
                remainder = -1 * num;
                continue;
            }
            //上一波剩下的正好满足当前这波，则不再继续剩下
            if (num == 0) { //上次剩下的正好满足当前的，则本次剩下为0
                remainder = 0;
                continue;
            }
            //上一波剩下的满足不了当前这一波，则分两种情况:batchSize大于等于等待人数/小于等待人数
            if (batchSize >= num) {
                remainder = batchSize - num;
            } else {
                int temp = num % batchSize;
                if (temp != 0) {
                    remainder = batchSize - temp;
                } else {
                    remainder = 0;
                }
            }
        }
        return count;
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        int result = count(batchSize, groups);
        for (int m = 0; m < 100; m++) {
            int tempResult = result;

            int[] tempGroup = copyArray(groups);
            int x1 = (int) (Math.random() * groups.length);
            int y1 = (int) (Math.random() * groups.length);
            swap(tempGroup, x1, y1);

            for (double t = 1e7; t > 1e-20; t *= 0.99) {
                int[] currentGroups = copyArray(tempGroup);
                int x = (int) (Math.random() * groups.length);
                int y = (int) (Math.random() * groups.length);
                swap(currentGroups, x, y);
                int current = count(batchSize, currentGroups);
                double a = Math.pow(Math.E, (tempResult - current) / t);
                double b = Math.random();
                System.out.println(String.format("t:%10.25f, result:%d,  currentGroups:%d, tempResult:%d, t:%.10f diff:%d  a:%.10f ,b:%.10f", t, result, current, tempResult, t, tempResult - current, a, b));
                if (current > result) {
                    System.out.println("current: " + current + "  array: " + getArrayString(currentGroups));
                    result = current;
                }

                if (current > tempResult || a > b) {
                    tempResult = current;
                    tempGroup = copyArray(currentGroups);
                }

            }
        }


        return result;
    }

    private String getArrayString(int[] currentGroups) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentGroups.length; i++) {
            sb.append(currentGroups[i] + "、");
        }
        return sb.toString();
    }

    private int[] copyArray(int[] groups) {
        int[] newArray = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            newArray[i] = groups[i];
        }
        return newArray;
    }

    private void swap(int[] groups, int x, int y) {
        if (x == y) {
            y = x == 0 ? groups.length - 1 : 0;
        }
        groups[x] = groups[x] ^ groups[y];
        groups[y] = groups[x] ^ groups[y];
        groups[x] = groups[x] ^ groups[y];
    }


    /**
     * 输入：batchSize = 3, groups = [1,2,3,4,5,6]
     * 输出：4
     * 解释：你可以将这些批次的顾客顺序安排为 [6,2,4,5,1,3] 。那么第 1，2，4，6 组都会感到开心。
     * 示例 2：
     *
     * 输入：batchSize = 4, groups = [1,3,2,5,2,2,1,6]
     * 输出：4
     *  6
     * [369205928,981877451,947462486,899465743,737778942,573732515,520226542,824581298,571789442,251943251,70139785,778962318,43379662,90924712,142825931,182207697,178834435,978165687]
     *  10
     *
     */
}
