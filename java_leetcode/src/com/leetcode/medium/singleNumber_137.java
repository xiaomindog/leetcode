package com.leetcode.medium;

import java.util.HashSet;

/*给定一个非空整数数组，除了某个元素只出现一次以外，
其余每个元素均出现了三次。找出那个只出现了一次的元素。*/
public class singleNumber_137 {

    //位运算
    //思考 如何出现三次 自动抵消为0
    //利用逻辑变换
    //参考题解：https://leetcode-cn.com/problems/single-number-ii/solution/
    // luo-ji-dian-lu-jiao-du-xiang-xi-fen-xi-gai-ti-si-l/
    public int singleNumber(int[] nums) {
        int x = 0, y = 0; //xy 3个状态 00 01 10
        for (int i = 0; i < nums.length; i++) {
            y = ~x & (y ^ nums[i]); //先做低位的运算 //想清楚 每一位的处理其实都是一样的!所以可以直接一次处理到位！
            x = ~y & (x ^ nums[i]);
        }
        return y;
    }


    //一个数学方法 3(a+b+c) - a-b-c-a-a-b-b = 2c
    //该方法会遇到大数问题
    public int singleNumber_2(int[] nums) {
        long sum = 0, hsum = 0;
        HashSet hs = new HashSet();
        for (int i : nums) {
            sum += i;
            if (hs.add(i)) hsum += i;
        }
        return (int) (3 * hsum - sum) / 2;
    }
}
