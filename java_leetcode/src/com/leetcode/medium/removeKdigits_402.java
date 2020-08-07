package com.leetcode.medium;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * <p>
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * <p>
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * <p>
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 **/
public class removeKdigits_402 {
    //单调栈解法
    //：维护一个单调栈，遍历string，当遇到字符小于前一个字符时候，选择替换
    public static String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        LinkedList<Character> stack = new LinkedList<>();
        int m = num.length() - k;

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > num.charAt(i)) {
                stack.pollLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }

        while (!stack.isEmpty() && stack.peekFirst() == '0') {
            stack.pollFirst();
            m--;
        }
        System.out.println("m:" + m);
        if (m == 0) return "0";
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < m; i++) {
            res.append(stack.pollFirst());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String num = "10";
        String r = removeKdigits(num, 1);
        System.out.println(r);
    }
}
