package com.mianshijingdian;

public class niuniu {
    int count = 0;

    public int getN(int n, int m, int k) {
        if (n < 3 || m < 2 || k < 5) return 0;
        int[][][] dp = new int[n + 1][m + 1][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        return 0;
    }

    public void dfs(int[] boy, int[] girl, int a, int b, int k) {
        if (k < 0) return;
        if (a >= 3 && b >= 2 & k >= 0) count++;
        for (int i = 1; i < boy.length; i++) {
            if (boy[i] == 1) continue;
            boy[i] = 1;

        }
    }
}
