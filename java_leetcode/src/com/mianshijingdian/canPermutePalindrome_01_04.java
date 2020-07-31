package com.mianshijingdian;

import java.util.HashMap;

/**
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 * 回文串不一定是字典当中的单词。
 */
public class canPermutePalindrome_01_04 {


    //位运算的思路 有限制条件：当字符只可能出现a-z字母是才行
    //26个二进制位存储不同的字符。按位异或，最后出现偶数位的字符为0，出现奇数个的为1
    public static boolean canPermutePalindrome(String s) {
        long res = 0; //字符ascii超过63可能出错了
        for (int i = 0; i < s.length(); i++) {
            res ^= (1 << s.charAt(i));
        }
        return (res & (res - 1)) == 0; //res与res-1异或：检查res中为1的位数
    }

    public boolean canPermutePalindrome_1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int count = 0;
        for (Integer i : map.values()) {
            if (i % 2 == 1) count++;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String s = "AaBb//a";
        boolean x = canPermutePalindrome(s);
        System.out.println(x);
    }
}
