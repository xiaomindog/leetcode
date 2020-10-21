package com.fragmentationProblem;

import java.util.Random;

//给定一个随机数生成器，这个生成器能均匀生成1到5（1,5）的随机数，
// 如何使用这个生成器生成均匀分布的1到7（1,7）的数?
public class random5_7 {
    //方法1：随机数5随机2次 得到2个数， 看成5进制的2个数 这2个数能表示的范围:5*1+1---5*5+5
    public static int random_5() {
        Random ra = new Random();
        return ra.nextInt(5) + 1;
    }
    public static int random_7() {
        int ra; //5进制的表示，范围6-30 共25种可能
        //取前21个数 6-26个数作为采样的结果  3*7=21 4*7=28
        while (true) {
            ra = random_5() * 5 + random_5();
            if (ra <= 26) break;
        }
        return (ra - 6) / 3 + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println(random_7());
        }
    }
}
