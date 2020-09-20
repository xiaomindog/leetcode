package com.DP.backpack;

//给出一些不同价值和数量的硬币。 找出这些硬币可以组合在1〜n范围内的多少个值
//多重背包变种 LintCode 799: Backpack VIII (多重背包问题变种，DP经典题， 难!）
public class backpack_8 {
    //这种解法会超时
    public static int backpackVIII_1(int n, int[] V, int[] amount) {
        boolean[] dp = new boolean[n + 1];
        //状态转移：dp[j] = dp[j]||dp[i-V[i]]
        dp[0] = true;
        for (int i = 1; i <= V.length; i++) {
            for (int k = 1; k <= amount[i - 1]; k++) {
                for (int j = n; j >= V[i - 1]; j--) {
                    //dp[j] = dp[j] || dp[j - V[i - 1]];
                    if (!dp[j] && dp[j - V[i - 1]]) { //剪枝
                        dp[j] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= dp.length - 1; i++) {
            System.out.println(dp[i]);
            if (dp[i]) ans++;
        }
        return ans;
    }


    //优化 比较难想到
    public static int backpackVIII_2(int n, int[] V, int[] amount) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= V.length; i++) {
            int[] count = new int[n + 1];
            //count数组的含义  相同价值硬币的使用次数
            //count[x]即当前i的时候，多少个硬币i已经用了来和其他硬币凑出x的价值。
            for (int j = V[i - 1]; j <= n; j++) {
                //为什么正序遍历？

                /* 3种剪枝情况
                1. dp[j]已经为true 无须继续更新
                2. 加入当前[value]为true，需要保证[j-value]也为true
                3. 硬币使用数量受限
                * */
                if (!dp[j] && dp[j - V[i - 1]] && count[j - V[i - 1]] < amount[i - 1]) {
                    dp[j] = true;
                    count[j] = count[j - V[i - 1]] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= dp.length - 1; i++) {
            System.out.println(dp[i]);
            if (dp[i]) ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 10;
        int[] V = new int[]{1, 2, 4};
        int[] amount = new int[]{2, 1, 1};
        System.out.println(backpackVIII_2(n, V, amount));
    }
}
