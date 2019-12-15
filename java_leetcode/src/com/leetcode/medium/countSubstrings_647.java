package com.leetcode.medium;

public class countSubstrings_647 {
    int count = 0;

    public int countSubstrings(String s) {
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            expend_from_center(s, i, i);
            expend_from_center(s, i, i + 1);

        }
        return count;
    }

    //以某个字母向两边扩展
    public void expend_from_center(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

    }


}
