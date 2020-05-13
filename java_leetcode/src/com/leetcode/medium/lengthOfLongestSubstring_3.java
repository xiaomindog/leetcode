package com.leetcode.medium;


import java.util.HashSet;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class lengthOfLongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) return 0;
        int max = 0;
        int start = -1;
        HashSet<Character> str = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                str.remove(s.charAt(i - 1)); //移除左边字符
            }
            while (start + 1 < s.length() && !str.contains(s.charAt(start + 1))) {
                str.add(s.charAt(start + 1));
                start++;
            }
            max = Math.max(max, start + 1 - i);
        }
        return max;
    }
}
