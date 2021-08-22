package com.perkins.leetcode;

import java.util.*;

import static java.util.Arrays.sort;

public class Question15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(nums);
        print(list);
    }

    private static void print(List<List<Integer>> list) {
        list.forEach(integers -> System.out.printf(list.toString()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }
        int size = nums.length;
        sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int s = i + 1;
            int e = size - 1;
            while (s < e) {
                if (nums[s] == nums[s++]) {
                    s++;
                }
                if (nums[e] < nums[e--]) {
                    s--;
                }
                System.out.println(i + " " + s + " " + e);
                if (nums[i] + nums[s] + nums[e] == 0) {
                    List item = new ArrayList(3);
                    item.add(nums[i]);
                    item.add(nums[s]);
                    item.add(nums[e]);
                    result.add(item);
                }
            }
        }

        return result;
    }

}
