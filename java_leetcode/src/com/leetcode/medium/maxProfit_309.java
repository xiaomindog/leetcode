package com.leetcode.medium;

/**
 * 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class maxProfit_309 {
    //分析一下状态
    //1. 持有股票 已经买入。
    //2. 不持有，冷冻期，不可买入
    //3. 不持有 可买入。

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int dp[][] = new int[prices.length][3];
        dp[0][0] = -prices[0];  //初始化 买入第一个股票！
        for (int i = 1; i < prices.length; i++) {
            //当前持有： 1）前一天持有，2）不持有可买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //冷冻期： 前一天持有并卖出
            // 第i天卖出的最大收益计算公式:第i-1天卖出最大收益 vs 第i-1天买入最大收益+当天股价
            dp[i][1] = dp[i - 1][0] + prices[i];
            // 当前不持有： 1）前一天冷冻期，2）前一天不持有
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]); //最后只有不持有股票才有最大利润。
    }
}
