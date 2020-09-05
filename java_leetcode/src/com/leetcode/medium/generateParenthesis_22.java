package com.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class generateParenthesis_22 {
    static List<String> ans;

    public static List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        if (n <= 0) return ans;
        dfs("", n, 0, 0);

        return ans;
    }

    public static void dfs(String s, int n, int left, int right) { //left,right记录左右括号个数
        if (s.length() == n * 2 && left == right) {
            ans.add(s);
            return;
        }
        if (left > n || right > n) return;
        if (left < right) return; //左括号数小于右括号数
        if (left < n) {
            dfs(s + '(', n, left + 1, right);
        }
        if (right<n){
            dfs(s + ')', n, left, right + 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
