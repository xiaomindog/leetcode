package com.DP;

public class uniquePathsWithObstacles_63 {


    //空间复杂度0(2n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[] cur = new int[n];
        cur[0] = 1;
        for (int i = 1; i < n; i++) {
            if (cur[i - 1] == 1 && obstacleGrid[0][i] == 0) cur[i] = 1;
        }
        int[] pre = cur.clone();

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        cur[j] = 0;
                    } else {
                        cur[j] = pre[j];
                    }
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        cur[j] = 0;
                    } else {
                        cur[j] = cur[j - 1] + pre[j];
                    }
                }
            }
            pre = cur;
        }
        return cur[n - 1];
    }

    //时间复杂度空间复杂度都为O(M*N)
    public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (dp[i - 1][0] == 1 && obstacleGrid[i][0] == 0) dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (dp[0][i - 1] == 1 && obstacleGrid[0][i] == 0) dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //空间复杂度O(1)  修改原数组
    public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1)
                obstacleGrid[i][0] = -1;
            else break;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1)
                obstacleGrid[0][i] = -1;
            else break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {

                    if (obstacleGrid[i - 1][j] != 1 && obstacleGrid[i][j - 1] != 1) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                    } else if (obstacleGrid[i][j - 1] != 1) {
                        obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                    } else if (obstacleGrid[i - 1][j] != 1) {
                        obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                    } else {
                        obstacleGrid[i][j] = 0;
                    }

                }
            }
        }

        return -obstacleGrid[m - 1][n - 1];
    }

}
