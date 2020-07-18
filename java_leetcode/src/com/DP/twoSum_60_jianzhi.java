package com.DP;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 ***/
public class twoSum_60_jianzhi {
    ////动态规划 优化 一维数组
    //每一阶段的当前点数 只与前一阶段最多i*6有关
    public double[] twoSum(int n) {
        if (n <= 0) return new double[0];
        int dp[] = new int[6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;  //第一个撒子的结果
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i * 6; j >= i; j--) {
                dp[j] = 0; //这边要清0 否则重复计算了
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur < i - 1) break; //每一阶段的更新到i为止
                    dp[j] += dp[j - cur]; //当前状态为前面状态之和
                }
            }
        }
        double res[] = new double[5 * n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[i + n] * 1.0 / Math.pow(6, n);
        }
        return res;
    }

    //动态规划  二维数组 相对好理解
    public double[] twoSum_1(int n) {
        if (n <= 0) return new double[0];

        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {  //n=1时候初始化
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) { //i表示第几个撒子
            for (int j = i; j <= 6 * i; j++) {  //j表示不同的撒子点数和
                for (int cur = 1; cur <= 6; cur++) { //cur表示当前撒子的点数
                    if (j - cur <= 0) break;
                    dp[i][j] += dp[i - 1][j - cur]; //状态转移
                }
            }
        }

        double res[] = new double[5 * n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][i + n] * 1.0 / Math.pow(6, n);
        }
        return res;
    }
}
