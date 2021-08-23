package com.perkins;

import org.junit.Test;

import java.util.Random;

/**
 * @author: perkins Zhu
 * @date: 2021/8/23 11:29
 * @description:
 **/
public class SimpleTest {

    @Test
    public void testAdd() {
        int a = 1;
        System.out.println(a++);
        System.out.println(a);
        System.out.println(++a);
        System.out.println(a);
    }

    @Test
    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Math.random());
        }
    }
}
