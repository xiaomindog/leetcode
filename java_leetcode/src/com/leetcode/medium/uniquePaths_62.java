package com.leetcode.medium;

import java.util.Arrays;

public class uniquePaths_62 {


    //本质上是一个杨辉三角形

    //首先容易想到高中排列组合的方法  但会出现溢出问题
    public static int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int min = m < n ? m : n;
        return factorial(m - 1 + n - 1, min - 1) / factorial(min - 1, min - 1);

    }

    //求n的阶乘
    public static int factorial(int n, int len) {
        int s = 1;
        while (len > 0) {
            s *= n;
            n = n - 1;
            len--;
        }
        return s;
    }


    //动态规划 dp[i][j]表示i到j的路径数
    public static int uniquePaths2(int m, int n) {

        if (m <= 0 || n <= 0) return 0;

        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) { //第一行和第一列只有一种走法
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    //优化dp的空间复杂度O(2n)
    public static int uniquePaths3(int m, int n) {
        if (m <= 0 || n <= 0) return 0;

        int pre[] = new int[n];
        int cur[] = new int[n];
        Arrays.fill(pre, 1); //初始化全1
        Arrays.fill(cur, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            int temp[] = pre;
            pre = cur;
            cur = temp;
        }
        return pre[n - 1];
    }

    //优化dp的空间复杂度O(n)  通过画出dp的二维矩阵来理解 是一个对称矩阵
    public static int uniquePaths4(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int cur[] = new int[n];
        Arrays.fill(cur, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + cur[j];
            }
        }

        return cur[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths3(4, 2));
    }
}
