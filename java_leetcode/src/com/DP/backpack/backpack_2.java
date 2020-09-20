package com.DP.backpack;

/**
 * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 * 问最多能装入背包的总价值是多大?每个物品只能取一次
 * 样例
 * 样例 1:
 * 输入: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * 输出: 9
 * 解释: 装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9
 * 样例 2:
 * 输入: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * 输出: 10
 * 解释: 装入 A[0] 和 A[2] 可以得到最大价值, V[0] + V[2] = 10
 */
public class backpack_2 {
    public int backPackII_1(int m, int[] A, int[] V) {
        if (m == 0 || A.length == 0 || V.length == 0) return 0;
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPackII_2(int m, int[] A, int[] V) {
        if (m == 0 || A.length == 0 || V.length == 0) return 0;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 1; j--) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[m];
    }
}
