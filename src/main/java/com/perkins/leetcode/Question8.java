package com.perkins.leetcode;

/**
 * @author: perkins Zhu
 * @date: 2022/8/3 13:52
 * @description:
 **/
public class Question8 {

    public static void main(String[] args) {
//        String str = "   -d392f232323g634";
        String str ="words and 987";
//        String str = "   -005d392f232323g634";
        Question8 q = new Question8();
        int result = q.myAtoi(str);
        System.out.println("result = " + result);
    }

    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.trim().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int item = chars[i];
            if (item == 43 || item == 45 || item >= 48 && item <= 57) {
                sb.append((char) item);
            } else if (sb.length() > 0) {
                break;
            }
        }
        String str = sb.toString();
        if (str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
