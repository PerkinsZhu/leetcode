package com.perkins.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: perkins Zhu
 * @date: 2023/7/17 14:31
 * @description:
 **/
public class Question118 {

    public static void main(String[] args) {
        new Question118().generate(5).forEach(list -> {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        });
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                compute(i, j, list);
            }
        }
        return list;
    }

    public void compute(int x, int y, List<List<Integer>> list) {
        if (list.size() < x + 1) {
            list.add(x, new ArrayList<>(x + 1));
        }
        if (x == 0 || (y == 0 || x == y)) {
            list.get(x).add(y, 1);
        } else {
            list.get(x).add(y, list.get(x - 1).get(y - 1) + list.get(x - 1).get(y));
        }
    }
}
