package com.jianzhi;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第 n 个丑数。
 * 注：
 * 1 是丑数。
 * n 不超过1690。
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 */
public class nthUglyNumber_49 {
    //动态规划
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
            dp[i] = Math.min(n1, Math.min(n2, n3));
            if (dp[i] == n1) a++;
            if (dp[i] == n2) b++;
            if (dp[i] == n3) c++;
        }
        return dp[n - 1];
    }

    //一个超时的解法
    public static int nthUglyNumber_1(int n) {
        if (n <= 0) return 0;
        int count = 0;
        int i = 1;
        while (true) {
            if (isUglyNumber(i)) count++;
            if (count == n) return i;
            i++;
        }
    }

    public static boolean isUglyNumber(int n) {
        if (n % 2 == 0) return isUglyNumber(n / 2);
        if (n % 3 == 0) return isUglyNumber(n / 3);
        if (n % 5 == 0) return isUglyNumber(n / 5);
        return n == 1;
    }

    public static void main(String[] args) {
        int n = nthUglyNumber_1(1345);
        System.out.println(n);
    }
}

