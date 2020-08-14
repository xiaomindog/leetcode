package com.leetcode.easy;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 **/
public class isPalindrome_125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        String ss = s.toLowerCase();
        char str[] = ss.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            while (i < j && !is_letter(str[i])) i++;
            while (i < j && !is_letter(str[j])) j--;
            if (i >= j) break;
            if (str[i] != str[j]) return false;
            else {
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean is_letter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
