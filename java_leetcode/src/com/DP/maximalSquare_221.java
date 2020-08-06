package com.DP;

//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
public class maximalSquare_221 {

    //dp数组  当前状态与左上角 左 上 3个有关系
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = (int) matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        int t = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                        dp[i][j] = (int) matrix[i][j] - '0' + Math.min(t, dp[i][j - 1]);
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
