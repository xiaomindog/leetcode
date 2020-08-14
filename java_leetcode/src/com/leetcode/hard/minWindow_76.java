package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/***76. 最小覆盖子串
 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 示例：
 输入：S = "ADOBECODEBANC", T = "ABC"
 输出："BANC"
 提示：
 如果 S 中不存这样的子串，则返回空字符串 ""。
 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class minWindow_76 {
    //去他妈的java HashMap, ASCII 128不香吗 坑了我这么久
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        //ASCII表总长128
        int[] need = new int[128];
        int[] window = new int[128];
        int count = 0;
        int[] temp = new int[]{0, s.length() + 1};

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (need[c] == 0) {
                j++;
                continue;
            }
            if (window[c] < need[c]) {
                count++;
            }
            window[c]++;
            j++;
            while (count == t.length()) {//当前window 满足要求
                if (temp[1] - temp[0] > j - i) {
                    temp[0] = i;
                    temp[1] = j;
                }
                char x = s.charAt(i);
                if (window[x] == 0) {
                    i++;
                    continue;
                }
                if (window[x] == need[x]) {
                    count--;
                }
                window[x]--;
                i++;
            }
        }
        return temp[1] == s.length() + 1 ? "" : s.substring(temp[0], temp[1]);
    }

    public static void main(String[] args) {
        String a = "ADOBECODEBANC";
        String b = "ABC";
        System.out.println(minWindow(a, b));
    }
}
