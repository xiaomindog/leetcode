package com.leetcode.medium;

//不同的二叉搜索树 卡特兰数
public class numTrees_96 {


    public int numTrees_1(int n) {
        if (n < 0) return 0;
        int dp[] = new int[1000];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
