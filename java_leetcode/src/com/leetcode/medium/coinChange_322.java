package com.leetcode.medium;

/*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
如果没有任何一种硬币组合能组成总金额，返回 -1。
示例 1:
输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:
输入: coins = [2], amount = 3
输出: -1
*/
public class coinChange_322 {


    //递推公式 f(n) = min(f(n - c1), f(n - c2), ... f(n - cn)) + 1
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }

            }
        }
        if (dp[amount] == amount+1)
            return -1;
        else
            return dp[amount];
    }
}
