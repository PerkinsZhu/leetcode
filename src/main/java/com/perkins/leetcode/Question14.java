package com.perkins.leetcode;

public class Question14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs.length;
        int index = 0;
        boolean flag = true;

        while (flag) {
            for (int i = 0; i < len - 1; i++) {
                if (strs[i].length() == index || strs[i + 1].length() == index) {
                    //到达元素末尾
                    flag = false;
                    break;
                }
                if (strs[i].charAt(index) != strs[i + 1].charAt(index)) {
                    //遇到不相等的 结束
                    flag = false;
                    break;
                }
            }
            index++;
        }
        return strs[0].substring(0, index - 1);
    }


    public static void main(String[] args) {
        String[] array = {"flower", "flow", "flight"};
        System.out.println(new Question14().longestCommonPrefix(array));
    }
}
