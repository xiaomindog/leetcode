package com.leetcode.medium;

/**
 * 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 **/
public class countNumbersWithUniqueDigits_357 {

    /*
     * 递推式：
     * f(1)=9
     * f(2) = 9*9+f(1)
     * f(3)=9*9*8+f(2)
     * */
    public static int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) return 0;
        if (n == 0) return 1;
        if (n == 1) return 10;
        int[] dp = new int[n + 1];
        int ans = 9;
        dp[1] = 10;
        for (int i = 9; i >= 11 - n; i--) {
            ans *= i;
            dp[11 - i] = ans + dp[10 - i];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(9));
    }
}
