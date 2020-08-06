package com.leetcode.medium;


//最大加号标志
public class orderOfLargestPlusSign_764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int dp[][][] = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = 1;
                }
            }
        }

        for (int[] m : mines) {
            for (int k = 0; k < 4; k++) {
                dp[m[0]][m[1]][k] = 0;  //左上右下0123
            }
        }

        //先遍历左上，从左上角开始遍历
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (dp[i][j][0] == 0) continue;
                dp[i][j][0] = 1 + dp[i][j - 1][0];
                dp[i][j][1] = 1 + dp[i - 1][j][1];

            }
        }
        //再遍历右下，从右下角开始遍历
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 2; j >= 0; j--) {
                if (dp[i][j][2] == 0) continue;
                dp[i][j][2] = 1 + dp[i][j + 1][2];
                dp[i][j][3] = 1 + dp[i + 1][j][3];
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = Math.min(Math.min(dp[i][j][0], dp[i][j][1]),
                        Math.min(dp[i][j][2], dp[i][j][3]));
                max = Math.max(max, k);
            }
        }
        return max;
    }
}
