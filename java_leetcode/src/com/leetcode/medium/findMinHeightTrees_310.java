package com.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。
 * 图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * 格式
 * 该图包含n个节点，标记为0到n - 1。给定数字n和一个无向边edges列表（每一个边都是一对标签）。
 * 你可以假设没有重复的边会出现在edges中。由于所有的边都是无向边， [0, 1]和[1, 0]是相同的，因此不会同时出现在edges里。
 * 示例 1:
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * 0
 * |
 * 1
 * / \
 * 2   3
 * 输出: [1]
 * 示例 2:
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * 输出: [3, 4]
 * 说明:
 * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 */
public class findMinHeightTrees_310 {

    //参考题解：剥洋葱法：
    // https://leetcode-cn.com/problems/minimum-height-trees/solution/zui-rong-yi-li-jie-de-bfsfen-xi-jian-dan-zhu-shi-x/
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);//无向边
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.clear();
            while (size-- > 0) {
                int pre = queue.poll();
                res.add(pre);
                for (int cur : adj.get(pre)) {
                    if (--degree[cur] == 1) queue.offer(cur);
                }
            }
        }
        return res;
    }

    //该解法超时
    public static List<Integer> findMinHeightTrees_1(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        // boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);//无向边
            adj.get(e[1]).add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            int level = 0;
            queue.offer(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                level++;
                if (level > min) break;

                int size = queue.size();
                while (size-- > 0) {
                    int pre = queue.poll();
                    for (int cur : adj.get(pre)) {
                        if (visited[cur]) continue;
                        queue.offer(cur);
                        visited[cur] = true;
                    }
                }
            }
            if (level < min) {
                ans.clear();
                ans.add(i);
                min = level;
            } else if (level == min) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
