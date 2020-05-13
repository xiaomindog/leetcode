package com.leetcode.medium;


//整数拆分
/*给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
返回你可以获得的最大乘积。
示例 1:输入: 2 输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:输入: 10 输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。*/
public class integerBreak_343 {

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }
        return dp[n];
    }

    //参考题解的数学方法
    public static int integerBreak_2(int n) {
        if(n<=3) return n-1;

        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 2 * 2;
        return (int) Math.pow(3, a) * 2;

    }

    public static void main(String[] args) {
        int s = integerBreak(10);
        System.out.println(s);
    }
}
