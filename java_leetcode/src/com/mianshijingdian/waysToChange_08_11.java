package com.mianshijingdian;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 * 示例1:
 * 输入: n = 5
 * 输出：2
 * 解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 */
public class waysToChange_08_11 {

    public static int waysToChange(int n) {
        if (n <= 0) return 0;
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1; //0个硬币组成面值为0的情况
        for (int coin : coins) {
            for (int j = 1; j <= n; j++) {
                if (j - coin >= 0) {
                    dp[j] = (dp[j] + dp[j - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }

    //时间复杂度4n 空间复杂度 4n+4
    public static int waysToChange_1(int n) {
        if (n <= 0) return 0;
        int[] coins = new int[]{1, 5, 10, 25};
        int[][] dp = new int[5][n + 1];  //表示 i 种硬币组成面值为 j 时的方法数
        for (int i = 1; i < 5; i++) {
            dp[i][0] = 1;   //i种硬币组成面值0， 一个都不选，所以 方法数为1
        }
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j] % 1000000007;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i - 1]]) % 1000000007;
                }
            }
        }
        return dp[4][n];
    }

    public static void main(String[] args) {
        System.out.println(waysToChange(10));
    }
}
