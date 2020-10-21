package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出:1
 * 示例2:
 * 输入:
 * [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 */
public class numIslands_200 {

    //并查集
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length, n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                }
            }
        }

        public int find_1(int i) {
            if (parent[i] != i) parent[i] = find_1(parent[i]);
            return parent[i];
        }

        public int find(int i) {
            int r = i;
            while (r != parent[r]) r = parent[r];
            //路径压缩
            int j = i, temp;
            while (j != r) {
                temp = parent[j];
                parent[j] = r;
                j = temp;
            }
            return parent[i];
        }


        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
//            if (rootx != rooty) {
//                if (rank[rootx] > rank[rooty]) {
//                    parent[rooty] = rootx;
//                } else if (rank[rootx] < rank[rooty]) {
//                    parent[rootx] = rooty;
//                } else {
//                    parent[rooty] = rootx;
//                    rank[rootx] += 1;
//                }
//                --count;
//            }
            if (rootx != rooty) {
                parent[rootx] = rooty;
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        uf.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        uf.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }

    //DFS
    public int numIslands_1(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        boolean[][] dp = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!dp[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, dp); //标记属于同一个岛屿的1
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] dp) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                dp[i][j] || grid[i][j] == '0') return;
        dp[i][j] = true;
        dfs(grid, i + 1, j, dp);
        dfs(grid, i, j + 1, dp);
        dfs(grid, i - 1, j, dp);
        dfs(grid, i, j - 1, dp);
    }

    //bfs
    public int numIslands_2(char[][] grid) {
        if (grid.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{i, j});
        while (!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            if (temp[0] < 0 || temp[0] >= grid.length || temp[1] < 0 || temp[1] >= grid[0].length
                    || grid[temp[0]][temp[1]] == '0') continue;
            grid[temp[0]][temp[1]] = '0';
            queue.offer(new Integer[]{temp[0] + 1, temp[1]});
            queue.offer(new Integer[]{temp[0], temp[1] + 1});
            queue.offer(new Integer[]{temp[0] - 1, temp[1]});
            queue.offer(new Integer[]{temp[0], temp[1] - 1});
        }
    }
}
