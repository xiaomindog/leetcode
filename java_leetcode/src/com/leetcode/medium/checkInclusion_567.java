package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 */
public class checkInclusion_567 {

    //滑动窗口
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length() || s1.length() == 0) return false;
        int i = 0, j = s1.length() - 1;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int c = 0; c < s1.length(); c++) {
            if (map1.containsKey(s1.charAt(c))) {
                map1.put(s1.charAt(c), map1.get(s1.charAt(c)) + 1);
            } else {
                map1.put(s1.charAt(c), 1);
            }
        }
        for (int c = 0; c <= j; c++) {
            if (map2.containsKey(s2.charAt(c))) {
                map2.put(s2.charAt(c), map2.get(s2.charAt(c)) + 1);
            } else {
                map2.put(s2.charAt(c), 1);
            }
        }

        while (j < s2.length()) {
            //System.out.println(map1+"---"+map2);
            if (map1.equals(map2)) return true;
            j++;
            if (j >= s2.length()) break;

            if (map2.get(s2.charAt(i)) == 1) {
                map2.remove(s2.charAt(i));
            } else {
                map2.put(s2.charAt(i), map2.get(s2.charAt(i)) - 1);
            }

            if (map2.containsKey(s2.charAt(j))) {
                map2.put(s2.charAt(j), map2.get(s2.charAt(j)) + 1);
            } else {
                map2.put(s2.charAt(j), 1);
            }
            i++;
        }
        return map1.equals(map2);
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "cadeuqncbassssxxa";
        boolean f = checkInclusion(s1, s2);
        System.out.println(f);
    }
}
