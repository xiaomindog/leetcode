package com.jianzhi;

//面试题14- I. 剪绳子 整数拆分 乘积最大
// DP
public class cuttingRope_14 {
    public int cuttingRope(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));  //拆分了2段
                dp[i] = Math.max(dp[i], dp[j] * (i - j));  //拆分成3段甚至更多
            }
        }
        return dp[n];
    }

}
