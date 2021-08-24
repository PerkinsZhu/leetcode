package com.perkins.leetcode;

import java.util.Random;

/**
 * @author: perkins Zhu
 * @date: 2021/8/24 11:33
 * @description:
 **/
public class Submit {
    public static void main(String[] args) {
        Submit q = new Submit();
        int batchSize = 8;
        int[] groups = new int[]{244197059, 419273145, 329407130, 44079526, 351372795, 200588773, 340091770, 851189293, 909604028, 621703634, 959388577, 989293607, 325139045, 263977422, 358987768, 108391681, 584357588, 656476891, 621680874, 867119215, 639909909, 98831415, 263171984, 236390093, 21876446};
        int res = q.maxHappyGroups(batchSize, groups);
        System.out.println(res);

    }


    public int count(int batchSize, int[] groups) {
        int count = 0;
        int remainder = 0;
        for (int i = 0; i < groups.length; i++) {
            if (remainder == 0) {
                count++;
            }
            int num = groups[i] - remainder;
            if (num < 0) {
                remainder = -1 * num;
                continue;
            }
            if (num == 0) {
                remainder = 0;
                continue;
            }
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
        for (int m = 0; m < 300; m++) {
            int tempResult = result;
            int[] tempGroup = copyArray(groups);

            for (double t = 1e8; t > 1e-15; t *= 0.99) {
                int[] currentGroups = copyArray(tempGroup);
                int x = (int) (Math.random() * groups.length);
                int y = (int) (Math.random() * groups.length);
                swap(currentGroups, x, y);
                int current = count(batchSize, currentGroups);
                double a = Math.pow(Math.E, (tempResult - current) / t);
                if (current > result) {
                    result = current;
                }

                if (current > tempResult || a > Math.random()) {
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
            return;
        }
        groups[x] = groups[x] ^ groups[y];
        groups[y] = groups[x] ^ groups[y];
        groups[x] = groups[x] ^ groups[y];
    }
}
