package com.DP;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 **/
public class maxValue_47_jianzhi {

    //递推关系 f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
    public int maxValue(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];//初始化第一列
        }
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1]; //初始化第一行
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }


}
