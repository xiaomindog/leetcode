package com.leetcode.medium;

/**
 * <超级丑数>
 * 编写一段程序来查找第 n 个超级丑数。
 * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
 */
public class nthSuperUglyNumber_313 {
    //思路同丑数II，为每个质因数维护一个指针
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 1) return n;
        int p[] = new int[primes.length]; //每个质因数的指针
        int num[] = new int[primes.length]; //每个质因数对应的数
        int dp[] = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            for (int k = 0; k < num.length; k++) {
                num[k] = dp[p[k]] * primes[k];
            }
            dp[i] = min_arry(num);
            for (int k = 0; k < num.length; k++) {
                if (dp[i] == num[k]) p[k]++;
            }
        }
        return dp[n - 1];
    }

    public int min_arry(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        return min;
    }
}
