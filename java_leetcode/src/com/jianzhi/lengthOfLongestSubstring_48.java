package com.jianzhi;

import java.util.HashSet;

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
public class lengthOfLongestSubstring_48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashSet<Character> hash = new HashSet<>();
        int start = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                hash.remove(s.charAt(i - 1));  //单调队列的思路，去掉头部第一个，继续判断
            }
            while (start + 1 < s.length() && !hash.contains(s.charAt(start + 1))) {
                //如果当前没有重复 持续加入到set中去
                hash.add(s.charAt(start + 1));
                start++;
            }
            max = Math.max(max, start + 1 - i); //记录当前得max
        }
        return max;
    }
}
