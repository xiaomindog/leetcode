package com.jianzhi;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，
 * 但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class reverseWords_58 {
    public static String reverseWords(String s) {
        List<String> list = new LinkedList<>();
        if (s.length() == 0) return "";
        int i = 0, j = 0;
        while (j < s.length()) {
            while (j < s.length()&& s.charAt(j) != ' ' ) j++;
            if (!s.substring(i, j).equals("")) {
                list.add(0, s.substring(i, j));
            }
            i = j + 1;
            j++;
        }
        StringBuffer res = new StringBuffer();
        for (int m = 0; m < list.size(); m++) {
            res.append(list.get(m));
            if (m < list.size() - 1)
                res.append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //String s = " I am a student. ";
        String s = "  I am a student.      ";
        String ss = reverseWords(s);
        System.out.println(ss);
    }
}
