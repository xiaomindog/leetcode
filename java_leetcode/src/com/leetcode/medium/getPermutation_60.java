package com.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class getPermutation_60 {
    //基于全排列的回溯可以做但是时间复杂度是较高的 剪枝的还不够彻底

    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) return "";

        boolean[] visited = new boolean[n + 1];

        //计算阶乘
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        StringBuffer str = new StringBuffer();
        dfs(visited, 0, n, k, str, factorial);
        return str.toString();
    }

    public void dfs(boolean[] visited, int idx, int n, int k, StringBuffer str, int[] factorial) {
        if (idx == n) return;
        int remain = factorial[n - 1 - idx];
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            if (k > remain) { //如果没有进行倒下一轮 remain都是一样的
                k -= remain;
                continue;
            }

            visited[i] = true;
            dfs(visited, idx + 1, n, k, str.append(i), factorial);
            //这里无须回溯 原因是：前面已经确认了第k个肯定在这个分支了
            return;
        }
    }
}
