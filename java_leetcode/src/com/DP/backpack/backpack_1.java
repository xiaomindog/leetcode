package com.DP.backpack;

/**
 * 描述：在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 */
public class backpack_1 {
    public int backPack_1(int m, int[] A) {
        if (A.length == 0 || m == 0) return 0;
        int[][] dp = new int[A.length + 1][m + 1]; //表示 当前选择第i个物品背包容量为j的情况
        for (int i = 1; i <= A.length; i++) { //遍历物品
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) { //2种情况： 当前物品选和不选
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }

    //二维变一维
    public int backPack_2(int m, int[] A) {
        if (A.length == 0 || m == 0) return 0;
        int[] dp = new int[m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 1; j--) { //这边需要倒序 因为dp[i-1][j-A[i-1]]不会被提前更新
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + A[i - 1]);
                }
            }
        }
        return dp[m];
    }
}
