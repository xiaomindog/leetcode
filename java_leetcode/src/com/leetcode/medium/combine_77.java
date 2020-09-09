package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class combine_77 {

    //数学方法，利用组合公式
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || n < k) return res;
        helper(n, k, new ArrayList<>(), res);
        return res;
    }

    //参数k表示还需要几个数
    public static void helper(int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (n < k) return;
        list.add(n);
        helper(n - 1, k - 1, list, res); //选了当前这个数 在剩下的n-1个中找k-1个
        list.remove(list.size() - 1);
        helper(n - 1, k, list, res); //未选当前这个数 在剩下的n-1个数中找k个
    }


    //回溯经典方法
    static List<List<Integer>> ans;

    public static List<List<Integer>> combine_1(int n, int k) {
        ans = new ArrayList<>();
        if (n == 0 || k == 0) return ans;
        dfs(1, new ArrayList<>(), n, k);
        return ans;
    }

    public static void dfs(int x, List<Integer> list, int n, int k) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //if (x > n) return;
        //list.add(x);
        for (int i = x; i <= n; i++) {
            list.add(i);
            dfs(i + 1, list, n, k);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(5, 2));
    }
}























