package com.mianshijingdian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。
 * 机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 */
public class pathWithObstacles_08_02 {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> list = new LinkedList<>();
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return list;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return list;
        boolean[][] visited = new boolean[m][n];
        dfs(obstacleGrid, 0, 0, list, visited);
        System.out.println(list);
        return list;
    }

    public boolean dfs(int[][] obstacleGrid, int i, int j, List<List<Integer>> list, boolean[][] visited) {
        if (i < 0 || i >= obstacleGrid.length || j < 0 || j >= obstacleGrid[0].length
                || visited[i][j] || obstacleGrid[i][j] == 1) {
            return false;
        }
        visited[i][j] = true;
        list.add(Arrays.asList(i, j));

        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return true;
        }
        if (dfs(obstacleGrid, i + 1, j, list, visited) || dfs(obstacleGrid, i, j + 1, list, visited))
            return true;
        list.remove(list.size() - 1);
        return false;
    }
}
