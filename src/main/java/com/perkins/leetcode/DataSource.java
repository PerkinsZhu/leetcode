package com.perkins.leetcode;

import java.util.Random;

public class DataSource {

    public static int[] randomIntArray(int length, int max) {
        Random random = new Random(max);
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = random.nextInt(max);
        }

        for (int item : res) {
            System.out.print(item + ".");
        }
        return res;
    }
}
