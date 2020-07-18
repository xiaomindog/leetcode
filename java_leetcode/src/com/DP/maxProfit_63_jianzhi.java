package com.DP;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class maxProfit_63_jianzhi {
    //动态规划
    //确定转移方程： 第i天利润最大 =  max(第i-1天最大，第i天值-前i-1天的最小)
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int[] dp = new int[prices.length];
        int min = prices[0];//记录前i-1天的最小值
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) min = prices[i];
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }
}
