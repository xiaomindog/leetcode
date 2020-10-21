package com.leetcode.medium;

import java.util.*;

/**
 * 给定两个单词（beginWord和 endWord）和一个字典，
 * 找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出:0
 * 解释:endWord "cog" 不在字典中，所以无法进行转换。
 */
public class ladderLength_127 {

    //双向bfs
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        set1.add(beginWord);
        set2.add(endWord);
        int count = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) {
                int size = queue2.size();
                while (size-- > 0) {
                    String head = queue2.poll();
                    for (int i = 0; i < wordList.size(); i++) {
                        String s = wordList.get(i);
                        if (set2.contains(s)) continue;
                        if (!is_single_diff(head, s)) continue;
                        if (set1.contains(s)) return count + 1;
                        set2.add(s);
                        queue2.add(s);
                    }
                }
            } else {
                int size = queue1.size();
                while (size-- > 0) {
                    String head = queue1.poll();
                    for (int i = 0; i < wordList.size(); i++) {
                        String s = wordList.get(i);
                        if (set1.contains(s)) continue;
                        if (!is_single_diff(head, s)) continue;
                        if (set2.contains(s)) return count + 1;
                        set1.add(s);
                        queue2.add(s);
                    }
                }
            }
        }
        return 0;
    }

    public static int ladderLength_1(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int idx = wordList.indexOf(beginWord); //若list中存在beginWorld，需要修改标记
        if (idx != -1) {
            visited[idx] = true;
        }
        queue.offer(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String head = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    String s = wordList.get(j);
                    if (visited[j] || !is_single_diff(head, s)) continue;
                    if (s.equals(endWord)) return count + 1;
                    visited[j] = true;
                    queue.offer(s);
                }
            }
        }
        return 0;
    }

    //判断2个单词只相差1个字符
    public static boolean is_single_diff(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt += 1;
            if (cnt > 1) return false;
        }
        return cnt == 1;
    }

    public static void main(String[] args) {
        System.out.println(is_single_diff("hot", "hot"));
    }

}
