package com.leetcode.medium;

import javax.swing.*;

public class longestPalindromeSubseq_516 {


    //动态规划 二维数组作为状态矩阵 下三角稀疏 可优化
    public static int longestPalindromeSubseq(String s) {
        if (s.length() == 0) return 0;

        int dp[][] = new int[s.length()][s.length()];
        //想清楚为什么从后往前遍历 保证了i,j之间的子序列的状态的更新
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;//单个字母的最长回文子序列一定是1
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        //输出dp数据测试
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }

        return dp[0][s.length() - 1];
    }


    //二维数据降为一维数组
    public static int longestPalindromeSubseq2(String s) {
        if (s.length() == 0) return 0;

        int[] pre = new int[s.length()]; // 前一步状态矩阵
        int[] cur = new int[s.length()]; //当前状态矩阵 最后一个元素永远保存当前的最大回文子序列长度

        for (int i = s.length() - 1; i >= 0; i--) {
            cur[i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    cur[j] = pre[j - 1] + 2;
                } else {
                    cur[j] = Math.max(pre[j], cur[j - 1]);
                }
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        int c = longestPalindromeSubseq2(s);
        System.out.println(c);
    }
}
