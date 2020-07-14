package com.jianzhi;

import java.util.*;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * s = "abaccdeff"
 * 返回 "b"
 * s = ""
 * 返回 " "
 */
public class firstUniqChar_50 {
    //利用哈希表存储
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Boolean> hash = new HashMap<>();
        char str[] = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            hash.put(str[i], !hash.containsKey(str[i]));
        }

        for (int i = 0; i < str.length; i++) {
            if (hash.get(str[i])) return str[i];
        }
        return ' ';
    }

    //利用java自带的indexof函数
    public char firstUniqChar_1(String s) {
        if (s.length() == 0) return ' ';
        char str[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //首次出现位置为当前位置 下一个出现位置为-1
            if (s.indexOf(str[i]) == i && s.indexOf(str[i], i + 1) == -1) {
                return str[i];
            }
        }
        return ' ';
    }
}
