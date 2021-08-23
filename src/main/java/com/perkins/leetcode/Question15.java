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
        System.out.printf(list.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(0);
        }
        int size = nums.length;
        java.util.Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < size; i++) {
            int s = i + 1;
            int e = size - 1;
            if ((i + 1) < size && nums[i] == nums[i + 1]) {
                continue;
            }
            while (s < e) {
                System.out.println(i + " " + s + " " + e);
                int sum = nums[i] + nums[s] + nums[e];
                if (sum == 0) {
                    while (nums[s] == nums[s + 1]) {
                        s++;
                    }

                    while (nums[e] < nums[e - 1]) {
                        e--;
                    }

                    List item = new ArrayList(3);
                    item.add(nums[i]);
                    item.add(nums[s]);
                    item.add(nums[e]);
                    result.add(item);
                    s++;
                    e--;
                } else if (sum > 0) {
                    e--;
                } else if (sum < 0) {
                    s++;
                }
            }
        }
        return result;
    }

}
