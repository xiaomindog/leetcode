package com.leetcode.medium;

/**
 * 518. 零钱兑换 II
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 示例 1:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2:
 * 输入: amount = 3, coins = [2]
 * 输出: 0
 * 解释: 只用面额2的硬币不能凑成总金额3。
 * 示例 3:
 * 输入: amount = 10, coins = [10]
 * 输出: 1
 */
public class change_518 {

    //每个硬币可以拿无限个  完全背包问题
    //正确的子问题定义应该是，problem(k,i) = problem(k-1, i) + problem(k, i-k)
    public int change(int amount, int[] coins) {
        if (amount == 0 && coins.length == 0) return 1;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //思考：重复可用体现在哪里呢？
        // j-coins[i-1] 这个地方
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i - 1]) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }

        }

        return dp[amount];
    }
}
