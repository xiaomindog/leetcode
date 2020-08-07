package com.leetcode.medium;

/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；
 * 非负整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。
 * 如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class maxProfit_714 {

    //dp的空间复杂度的优化
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int have = -prices[0], no = 0;
        for (int i = 1; i < prices.length; i++) {
            no = Math.max(no, have - fee + prices[i]);
            have = Math.max(have, no - prices[i]);
        }
        return no;
    }

    //动态规划思路 空间复杂度喂O(2n) 用2个数组分别表示持有股票时的当前利润和不持有股票时候的当前利润
    public int maxProfit_1(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[prices.length][2];
        //dp[i][0]表示当前不持有股票
        //dp[i][1]表示当前持有股票
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - fee + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0]; //最后肯定是不持有股票的利润高
    }
}
