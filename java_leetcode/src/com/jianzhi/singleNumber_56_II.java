package com.jianzhi;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 * [3,4,3,3]
 */
public class singleNumber_56_II {


    //位运算 逻辑电路的思路
    public int singleNumber(int[] nums) {
        if (nums.length <= 0) return 0;
        int x = 0, y = 0; //用2位二进制位表示3位数

        for (int i : nums) {
            y = ~x & (y ^ i);  //先计算低位
            x = ~y & (x ^ i);
        }
        return y;
    }

    public int singleNumber_1(int[] nums) {
        if (nums.length <= 0) return 0;
        int count[] = new int[32]; //用长度为32的数组保存每一个位的个数 最后%3
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                count[j] += (i & 1);
                i >>>= 1;
            }
        }
        int p = 1, res = 0;
        for (int j = 0; j < 32; j++) {
            res += p * (count[j] % 3);
            p *= 2;
        }
        return res;
    }
}
