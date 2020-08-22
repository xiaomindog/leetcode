package com.leetcode.medium;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 */
public class canPartition_416 {


    //dfs+剪枝
    public static boolean canPartition(int[] nums) {
        if (nums.length <= 1) return false;
        int sum = 0;
        Integer[] temp = new Integer[nums.length];
        int x = 0;
        for (Integer num : nums) {
            temp[x++] = num;
        }
        Arrays.sort(temp, (t1, t2) -> t2 - t1);//逆序dfs
        //为什么逆序？：避免诸如 1,1,1,1,2,10，这类  产生死循环
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 == 1) return false;
        int target = sum / 2;
        return dfs(temp, target, 0);
    }

    public static boolean dfs(Integer[] nums, int target, int idx) {
        if (idx >= nums.length) return false;
        if (target < 0) return false;
        //if (target == 0) return true;
        if (nums[idx] == target) return true;
        else if (nums[idx] > target) return false;
        return dfs(nums, target - nums[idx], idx + 1) || dfs(nums, target, idx + 1);
    }


    //空间复杂度优化
    public static boolean canPartition_2(int[] nums) {
        if (nums.length <= 1) return false;

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false; //sum/2为目标价值
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        //初始化
//        if (nums[0] <= target) {
//            dp[nums[0]] = true;
//        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > 0; j--) {
                if (nums[i] == j) dp[j] = true;
                else if (nums[i] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 5};
        System.out.println(canPartition(nums));
    }

    //相当于01背包问题，且必须要正好装满背包
    public static boolean canPartition_1(int[] nums) {
        if (nums.length <= 1) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false; //sum/2为目标价值
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        //初始化：
        //第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[1][nums[0]] = true;
        }

        for (int i = 2; i < nums.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i - 1] == j) {
                    dp[i][j] = true;
                    continue;
                } else if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }
}