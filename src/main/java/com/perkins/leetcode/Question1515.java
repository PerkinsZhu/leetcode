package com.perkins.leetcode;

import java.util.Random;

/**
 * @author: perkins Zhu
 * @date: 2021/8/23 15:20
 * @description:
 **/
public class Question1515 {
    public static void main(String[] args) {
        Question1515 q = new Question1515();
        int[][] pos = {{1, 1}, {0, 0}, {2, 0}};
        double res = q.getMinDistSum(pos);

        System.out.println(res);

    }

    /**
     * 模拟退火算法：
     * https://www.cnblogs.com/heaad/archive/2010/12/20/1911614.html
     */
    public double getMinDistSum(int[][] positions) {
        /**
         * 1、随机找个位置
         */
        //先随机找个位置
        double x = 1230, y = -12334;
        double distance = getDistance(positions, x, y);

        //设置循环次数
        int count = 2;
        while (count-- > 0) {
            System.out.println("执行第" + count + "次循环");
            //设置初始温度
            double T = 100000;
            //设置结束温度
            double endT = 1E-15;
            //设置温度变化率
            float K = 0.97F;

            //初始化本次循环的数据
            double currentDistance = distance;
            double x1 = x;
            double y1 = y;

            System.out.println("首次数据：当前温度为:" + T + "  距离为:" + distance + "  xy:" + x1 + "、" + y1);
            int sumCount = 0;
            while (T > endT) {
                sumCount++;
                //获取下一个随机位置
                //这里的位置每次都是从上次查找到的最优解开始波动，波动范围也随着T的递减而递减，这样就是慢慢在缩小坐标的取值范围
                double x2 = x1 + getRandom(T);
                double y2 = y1 + getRandom(T);
                double newDistance = getDistance(positions, x2, y2);

                System.out.println("当前温度为:" + T + "  距离为:" + newDistance + "  xy:" + x2 + "、" + y2);

                if (newDistance < distance) {
                    distance = newDistance;
                    x = x2;
                    y = y2;
                }
                //如果新的方案比老方案更好
                //或者 随机接受该值，这里的随机值会导致跳过局部最优解，如果发现有更优解，则跳出当前的局部最优解，找到新的最优解
                if (newDistance < currentDistance ||
                        Math.pow(Math.E, (currentDistance - newDistance) / T) > Math.random()) {
                    x1 = x2;
                    y1 = y2;
                    currentDistance = newDistance;
                }
                //降低温度
                T = T * K;
            }
            System.out.println("本次查找次数:" + sumCount);
        }

        System.out.println("结果地址:" + x + " " + y);
        return distance;
    }

    private int range = 32767;

    private double getRandom(double t) {
        Random random = new Random();
        return (t * (Math.random() * range * (random.nextBoolean() ? -1 : 1)));
    }

    private double getDistance(int[][] positions, double x, double y) {
        double distance = 0D;
        for (int i = 0; i < positions.length; i++) {
            distance += Math.pow(Math.pow(Math.abs(x - positions[i][0]), 2) + Math.pow(Math.abs(y - positions[i][1]), 2), 0.5);
        }
        return distance;
    }

}
