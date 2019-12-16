package com.leetcode.medium;
/*  最长回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例 1：
 输入: "babad"
 输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：
 输入: "cbbd"
输出: "bb"*/


public class longestPalindrome_5 {


    //https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
    //动态规划解法 时间复杂度 O(n^2) 空间复杂度O(1)

    public String longestPalindrome(String s) {
        //按中心展开 共有2n-1个中心 如果字母数为偶数，每2个元素之间的空格也要算为1个中心

        if(s.length()==0) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expend_from_center(s, i, i); // 考虑单个字母时候的len
            int len2 = expend_from_center(s, i, i + 1); //考虑2个字母为回文时候的len
            int len = Math.max(len1, len2);  //保存较长的

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }

    //以某个字母向两边扩展
    public int expend_from_center(String s, int left, int right) {
        while ((left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
