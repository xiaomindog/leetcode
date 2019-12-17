package com.leetcode.medium;

public class uniquePathsWithObstacles_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1]==1||obstacleGrid[0][0]==1)return 0;

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
