package com.leetcode.easy;

public class maxProfit_122 {

    //DP
    public static int maxProfit(int[] prices) {
        if (prices.length <= 0) return 0;
        int[][] dp = new int[prices.length][2];  //表示第i天持有或不持有的利润
        dp[0][0] = 0; //0表示不持有股票
        dp[0][1] = -prices[0]; //1表示持有
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);  //昨天不持有  今天卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);  //昨天持有  昨天买入
        }
        return dp[prices.length - 1][0]; //最后一天不持有
    }

    //贪心算法
    public int maxProfit2(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                max+=prices[i]-prices[i-1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
