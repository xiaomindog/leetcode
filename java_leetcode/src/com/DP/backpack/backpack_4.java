package com.DP.backpack;

/**
 * 给出n个物品, 以及一个数组,nums[i]代表第i个物品的大小,
 * 保证大小均为正数并且没有重复, 正整数target表示背包的大小, 找到能填满背包的方案数。
 * 每一个物品可以使用无数次
 */
public class backpack_4 {
    //爬楼梯 零钱兑换II
    //看成多重背包问题
    public static int backPackIV_1(int[] nums, int target) {
        if (target < 0) return 0;
        int[][] dp = new int[nums.length + 1][target + 1];

        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1; //target=0时,对于任意硬币来说 都可以不选  所以都为1
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; //当前元素不选
                if (j - nums[i - 1] >= 0) { //当前元素选
                    dp[i][j] += dp[i][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }


    public int backPackIV_2(int[] nums, int target) {
        if (target < 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= nums.length; i++) { //加入第i个元素
            for (int j = nums[i - 1]; j <= target; j++) {  //当前元素可能的组合个数
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5};
        int target = 7;
        System.out.println(backPackIV_1(nums, target));
    }
}
