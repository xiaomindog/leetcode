package com.BitManipulation;

/***<>比特位计数</>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
 * 计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]*/

public class countBits_338 {

    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i >> 1] + (i & 1);  // i&1 取最右边的那位数
        }
        return dp;
    }

    // i&（i-1）
    public int[] countBits_1(int num) {
        int dp[] = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            //i&(i-1)可以去掉i最右边的1，因此 i&(i-1）是比 i 小的，
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
