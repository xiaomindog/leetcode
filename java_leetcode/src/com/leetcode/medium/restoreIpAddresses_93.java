package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 */
public class restoreIpAddresses_93 {
    static List<String> ans;

    public static List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if (s.length() <= 3) return ans;
        helper(s, 0, "", "", 0);
        return ans;
    }

    public static void helper(String s, int idx, String temp, String cur, int dot_cnt) {
        if (dot_cnt == 3 && idx == s.length()) {
            //if (s.substring(idx).compareTo("255") > 0) return;
            if (temp.charAt(temp.length() - 1) == '.') return;
            ans.add(temp);
        }
        if (idx >= s.length() || dot_cnt > 3) return;
        cur = cur + s.charAt(idx);
        if (Integer.parseInt(cur) > 255) return;
        if (cur.equals("0")) { //0单独作为一个位，不能出现010这种情况
            if (idx == s.length() - 1) { //0是最后一个元素，最后面无需加.
                helper(s, idx + 1, temp + s.charAt(idx), "", dot_cnt);
            } else {
                //当前元素位0，直接加.
                helper(s, idx + 1, temp + s.charAt(idx) + ".", "", dot_cnt + 1);
            }
        } else {
            //当前元素后面加.
            helper(s, idx + 1, temp + s.charAt(idx) + ".", "", dot_cnt + 1);
            //当前元素后面不加.
            helper(s, idx + 1, temp + s.charAt(idx), cur, dot_cnt);
        }
    }

    public static void main(String[] args) {
        String a = "25525511135";
        List<String> s = restoreIpAddresses(a);
        System.out.println(s);
    }

}
