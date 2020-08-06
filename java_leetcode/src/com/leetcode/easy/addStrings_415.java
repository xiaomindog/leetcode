package com.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
public class addStrings_415 {
    public static String addStrings(String num1, String num2) {
        StringBuffer ans = new StringBuffer();
        int len1 = num1.length() - 1, len2 = num2.length() - 1;
        int flag = 0;
        int t;
        while (len1 >= 0 || len2 >= 0) {
            int t1 = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int t2 = len2 >= 0 ? num2.charAt(len2) - '0' : 0;
            t = flag + t1 + t2;
            flag = t / 10;
            ans.append(t % 10);
            len1--;
            len2--;
        }
        if (flag != 0) {
            ans.append(flag);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addStrings("12", "8");
        System.out.println(s);
    }
}
