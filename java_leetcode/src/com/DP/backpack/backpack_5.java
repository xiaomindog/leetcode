package com.DP.backpack;

/**
 * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小,
 * 保证大小均为正数, 正整数 target 表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品只能使用一次
 **/
public class backpack_5 {
    public int backPackV_1(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; //不选当前元素
                if (j >= nums[i - 1]) { //选当前元素
                    // 这边+的时i-1 表示 如果选当前元素 之前没选过
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    public int backPackV_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // 目标为0  当前元素也不选
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }
}
