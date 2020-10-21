package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 * 示例:
 * 输入:"aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class partition_131 {
    static List<List<String>> ans;

    //DP优化
    public static List<List<String>> partition(String s) {
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        ans = new ArrayList<>();
        if (s.length() == 0) return ans;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    //j-i=0 单独一个字符 j-i=1 两个相同字符 j-i=2 两个相同+中间
                    dp[j][i] = true;
                }
            }
        }
        helper(s, new ArrayList<>(), 0, dp);
        return ans;
    }

    public static void helper(String s, List<String> list, int idx, boolean[][] dp) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) { //循环：从每个字符开始都可以选择不同子串
            if (!dp[idx][i]) continue;
            list.add(s.substring(idx, i + 1)); //当前子串是回文串 加入list
            helper(s, list, i + 1, dp);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        partition("aab");
        System.out.println(ans);
    }

    public static List<List<String>> partition_1(String s) {
        ans = new ArrayList<>();
        if (s.length() == 0) return ans;
        dfs(s, new ArrayList<>(), 0);
        return ans;
    }

    public static void dfs(String s, List<String> list, int idx) {
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = idx; i < s.length(); i++) { //循环：从每个字符开始都可以选择不同子串
            if (!isPalindrome(s, idx, i)) continue;
            list.add(s.substring(idx, i + 1)); //当前子串是回文串 加入list
            dfs(s, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }
}
