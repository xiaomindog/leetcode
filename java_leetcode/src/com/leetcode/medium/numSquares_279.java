package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

//完全平方
public class numSquares_279 {
    //1.这种思路类似322题硬币个数的题目 非最优解

    public static int numSquares(int n) {
        if (n <= 0) return 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; j * j <= n; j++) {
                if (i - j * j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j * j]+1);
                }
            }
        }
        return dp[n];
    }


    /*四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和。
    推论：满足四数平方和定理的数n（四个整数的情况），必定满足 n=4^a(8b+7)  */
    public static int numSquares_3(int n) {
        return 0;
    }

    public static void main(String[] args) {
        int s = numSquares(5);
        System.out.println(s);
    }
}
