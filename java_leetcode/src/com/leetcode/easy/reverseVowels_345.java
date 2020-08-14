package com.leetcode.easy;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 */
public class reverseVowels_345 {
    public String reverseVowels(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        char str[] = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !is_vowel(str[i])) i++;
            while (i < j && !is_vowel(str[j])) j--;
            if (i >= j) break;
            else {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(str);
    }

    public boolean is_vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
