package com.leetcode.easy;

/*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
注意你不能在买入股票前卖出股票。
*/

public class maxProfit_121 {
	// 最蠢的2层循环
	public static int mp(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max;
	}
	//动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
	public static int mp2(int[] prices) {
		if(prices.length<=0)
			return 0;
		int maxi_1 = 0;
		int max = 0;
		int id = prices[0];  //记录最小的价格
		for(int i =1;i<prices.length;i++){
			//id = Math.min(prices[i-1],id);
			if(prices[i-1]<id){
				id = prices[i-1];
			}
			if(prices[i]-id>0){
				maxi_1 = Math.max(max,prices[i]-id); // 第i天的价格-前i-1天中的最小价格
				max = maxi_1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] prices1 = { 7, 1, 5, 3, 6, 4 };
		int[] prices2 = { 7, 5, 3, 2, 1 };
		System.out.println(mp(prices1));
		System.out.println(mp(prices2));
	}

}
