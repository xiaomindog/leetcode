package com.leetcode.medium;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */

public class letterCombinations_17 {

    //递归回溯 时间复杂度
    List<String> res;
    static Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations_1(String digits) {
        if (digits.equals("")) return new LinkedList<>();
        res = new LinkedList<>();
        dfs(digits, 0, "");
        return res;
    }

    //第3个参数不能传StringBuffer  。
    // 因为StringBuilder传入的都是同一个对象，所以在递归完成之后必须撤回上一次的操作，需要删除上一次添加的字符

    public void dfs(String digits, int idx, String s) {
        if (idx == digits.length()) { //递归地出口
            res.add(s);
            return;
        }
        char c = digits.charAt(idx);
        String letter = phone.get(c);
        for (int i = 0; i < letter.length(); i++) {
            dfs(digits, idx + 1, s + letter.charAt(i));
        }
    }


    //借用栈来保存
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> queue = new LinkedList<>(); //双端队列
        if (digits.equals("")) return new LinkedList<>();
//        char c = digits.charAt(0);
//        String letter = phone.get(c);
//        for (int i = 0; i < letter.length(); i++) {
//            queue.addLast(String.valueOf(letter.charAt(i)));
//        }
        int i = 0;
        while (i < digits.length()) {
            String s = "";
            if (!queue.isEmpty() && queue.peekFirst().length() == i) {
                s = queue.pollFirst();
            } else if (i != 0) {
                i++;
                continue;
            }
            char c = digits.charAt(i);
            String letter = phone.get(c);
            for (int j = 0; j < letter.length(); j++) {
                queue.addLast(s + letter.charAt(j));
            }
            if (i == 0) i++;
        }
        return queue;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
