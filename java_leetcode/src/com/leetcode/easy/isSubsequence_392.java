package com.leetcode.easy;

import javax.swing.*;

public class isSubsequence_392 {


    //暴力法解决  时间复杂度o(n)
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int is = 0, it = 0;
        int pi = 0;

        while (it < t.length()) {
//               pi=it;
            if (s.charAt(is) == t.charAt(it)) {
                is++;
                if (is == s.length()) //最后一个也找到相等的  直接返回true
                    return true;
                it++;//如果相等 就继续往下找
            } else {
                it++; // 如果不等 t继续往下走
            }

        }
        return false;
    }

    //利用java自带的indexof()函数
    public static boolean isSubsequence2(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, (index + 1));
            if (index == -1) return false;
        }
        return true;
    }


    //动态规划方法
    public static boolean isSubsequence3(String s, String t) {
        boolean[][] d = new boolean[s.length() + 1][t.length() + 1];

        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        for (int j = 0; j < t.length(); j++) {
            d[0][j] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {  //如果当前的最后一位相同 比较s的前一位和t的前一位
                    d[i][j] = d[i - 1][j - 1];

                } else {
                    d[i][j] = d[i][j - 1]; //否则比较s和t的前一位
                }
            }
        }
        return d[s.length()][t.length()];
    }




    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        //System.out.println(isSubsequence2(s, t));
        boolean q = isSubsequence3(s, t);
        System.out.println(q);


    }
}
