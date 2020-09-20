package com.leetcode.medium;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出:"blue is sky the"
 * 示例 2：
 * <p>
 * 输入: " hello world! "
 * 输出:"world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good example"
 * 输出:"example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶：
 * 请选用 C 语言的用户尝试使用O(1) 额外空间复杂度的原地解法。
 **/
public class reverseWords_151 {


    public String reverseWords(String s) {
        List<String> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= s.length()) break;
            if (s.charAt(i) != ' ') {
                j = i;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                list.add(0, s.substring(i, j));
                i = j;
            }
        }
        StringBuffer str = new StringBuffer();
        for (String ss : list) {
            str.append(ss);
            str.append(' ');
        }
        if (str.length() == 0) return "";
        return str.substring(0, str.length() - 1);
    }

    //利用java split函数
    public String reverseWords_1(String s) {
        if (s.equals("")) return s;
        String[] spl = s.split(" ");
        StringBuffer str = new StringBuffer();
        for (int i = spl.length - 1; i >= 0; i--) {
            str.append(spl[i]);
            if (!spl[i].equals("")) {
                str.append(" ");
            }
        }
        if (str.length() == 0) return "";
        return str.substring(0, str.length() - 1);
    }
}
