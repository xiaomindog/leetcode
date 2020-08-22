package com.leetcode.medium;

/***给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，
 * 其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和： 
 i - K <= r <= i + K, j - K <= c <= j + K 
 (r, c) 在矩阵内。
 示例 1：
 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 输出：[[12,21,16],[27,45,33],[24,39,28]]
 示例 2：
 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 输出：[[45,45,45],[45,45,45],[45,45,45]]
 */
public class matrixBlockSum_1314 {

    //二维数组前缀和问题
    public int[][] matrixBlockSum(int[][] mat, int K) {
        if (mat.length == 0 || mat[0].length == 0) return new int[0][0];
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = mat[0][0]; //二维数组前缀和
        for (int i = 1; i < m; i++) {
            sum[i][0] = mat[i][0] + sum[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            sum[0][j] = mat[0][j] + sum[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }


        //区域和 sum[i+k][j+k]-sum[i+k][j-k-1]-sum[i-k-1][j+k]+sum[i-k-1][j-k-1] a-b-c+d
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + K < m && j + K < n) {
                    dp[i][j] += sum[i + K][j + K];
                } else if (i + K < m) {
                    dp[i][j] += sum[i + K][n - 1];
                } else if (j + K < n) {
                    dp[i][j] += sum[m - 1][j + K];
                } else {
                    dp[i][j] += sum[m - 1][n - 1];
                }
                if (i + K < m && j - K - 1 >= 0) {
                    dp[i][j] -= sum[i + K][j - K - 1];
                } else if (j - K - 1 >= 0) {
                    dp[i][j] -= sum[m - 1][j - K - 1];
                }
                if (i - K - 1 >= 0 && j + K < n) {
                    dp[i][j] -= sum[i - K - 1][j + K];
                } else if (i - K - 1 >= 0) {
                    dp[i][j] -= sum[i - K - 1][n - 1];
                }
                if (i - K - 1 >= 0 && j - K - 1 >= 0) {
                    dp[i][j] += sum[i - K - 1][j - K - 1];
                }
            }
        }
        return dp;
    }
}
