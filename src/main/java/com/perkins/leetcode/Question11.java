package com.perkins.leetcode;

/**
 * @author: perkins Zhu
 * @date: 2023/7/13 9:18
 * @description:
 **/
public class Question11 {

    // 从两端向中间压缩,可降低时间复杂度
    public int maxArea(int[] height) {
        int max = 0;
        int endIndex = height.length - 1;
        int startIndex = 0;
        while (startIndex < endIndex) {
            int a = height[startIndex];
            int b = height[endIndex];
            int area = (endIndex - startIndex) * Math.min(a, b);
            if (area > max) {
                max = area;
            }
            if (a < b) {
                while (a >= height[++startIndex] && startIndex < endIndex) {
                }
            } else {
                while (b >= height[--endIndex] && startIndex < endIndex) {
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {2, 14, 6, 18, 4, 56, 3, 2};
        int max = new Question11().maxArea(height);
        System.out.println(max);
    }
}
