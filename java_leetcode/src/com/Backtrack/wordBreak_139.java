package com.Backtrack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词
 */
public class wordBreak_139 {


    //动态规划方法:dp[]数组表示当前长度i（0,i）是否满足条件
    public static boolean wordBreak_1(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        if (wordDict.contains(s)) return true;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //方法二：记忆化回溯
    HashMap<String, Boolean> visited = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        if (wordDict.contains(s)) return true;
        HashSet<String> set = new HashSet<>(wordDict);
        return dfs(s, set);
    }

    public boolean dfs(String s, HashSet<String> set) {
        if (visited.containsKey(s)) return visited.get(s); //当前子字符串出现在visited 可以直接返回
        if (s.length() == 0) return true;

        for (int i = 1; i <= s.length(); i++) {
            if (set.contains(s.substring(0, i))) {
                if (dfs(s.substring(i), set)) {
                    return true; //(0,i)的子字符串满足 且 (i,s.length())子字符串也满足
                }
            }
        }
        visited.put(s, false);//当前该子串不满足，返回false
        return false;
    }

}
