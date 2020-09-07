package com.leetcode.medium;

import java.math.BigInteger;
import java.util.*;


/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class groupAnagrams_49 {


    //用26个质数分别表示26个字母   会溢出
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101}; //前26个质数
        Map<Integer, List<String>> hash = new HashMap<>();
        for (String s : strs) {
            Integer hashcode = 1;
            char[] ch = s.toCharArray();
            for (char c : ch) {
                hashcode *= primes[(c - 'a')];
            }
            if (!hash.containsKey(hashcode)) {
                hash.put(hashcode, new ArrayList<>());
            }
            hash.get(hashcode).add(s);
        }
        return new ArrayList<>(hash.values());
    }


    public List<List<String>> groupAnagrams_1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>(); //map中使用数组作为键的话是错误的
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        // [["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"],["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"]]
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".length());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa".length());
    }
}
