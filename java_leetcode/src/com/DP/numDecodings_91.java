package com.DP;

/**
 * 解码方法1
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 示例 1:
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 */
public class numDecodings_91 {

    //状态转移：dp[i] = dp[i-1]*1 (如果s[i]!=0) dp[i]+=dp[i-2](如果s[i-1]s[1]能够解码)
    //边界条件  1.首字母为'0'时，不可以解码。
    //2. 字符串中0不能单独解码，需要10 20 才可以解码

    //空间复杂度可以降低到O(1)
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int d1 = 1, d2, d3 = 0;  //用3个变量保存更新的值

        int t = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        if (t > 10 && t <= 26 && t != 20) {  //10 解码只有1种
            d2 = 2;
        } else if (t > 20 && t % 10 == 0) {
            return 0;
        } else {
            d2 = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) - '0' > 2) {
                return 0;
            }  //如 301 这种解码结果为0

            if (s.charAt(i) != '0') {
                d3 = d2;
            }
            t = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (t >= 10 && t <= 26) {
                d3 += d1;
            }
            d1 = d2;
            d2 = d3;
            d3 = 0;
        }
        return d2;
    }

    public int numDecodings_1(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int dp[] = new int[s.length()];
        dp[0] = 1;
        int t = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';

        if (t > 10 && t <= 26 && t != 20) {  //10 解码只有1种
            dp[1] = 2;
        } else if (t > 20 && t % 10 == 0) {
            return 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) - '0' > 2) {
                return 0;
            }  //如 301 这种解码结果为0

            //1010
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            t = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
            if (t >= 10 && t <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }
}
