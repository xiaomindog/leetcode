package com.DP;

/**
 * 给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 因此输出为 7。
 */
public class combinationSum4_377 {

    //把该问题看成完全背包问题 并且考虑顺序 所以target循环放在外部

    //转移方程：dp[i] = dp[i]+dp[i-num]  i为目标数
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3};
        System.out.println(combinationSum4(nums, 35));

    }
}