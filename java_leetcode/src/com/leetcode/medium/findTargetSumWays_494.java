package com.leetcode.medium;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 **/
public class findTargetSumWays_494 {

    //题解大佬的想法
    /*记x为负数的和，y为正数的和，有：x+y=S,y-x=sum; 所以有S+sum为偶数
    把x,y分别看成一个集合： x={}, y={}
    只要找出其中一个集合，就确定了一种背包选择 y = (sum+S)/2
     * */
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // 背包容量为整数，sum+S为奇数的话不满足要求
        if ((sum + S) % 2 == 1) return 0;
        // 目标和不可能大于总和
        if (S > sum) return 0;
        int len = (sum + S) / 2; //为正数的总和，只要找出正数的方案即可
        int[] dp = new int[len + 1];
        dp[0] = 1; //表示从前0个物品中选取若干放入背包承重量为0的恰好装满的方案数

        for (int num : nums) {
            for (int j = len; j >= num; j--) {
                dp[j] += dp[j - num]; //当前总和为j 取决于 前面j-num ,j-num 表示取＋号
            }
        }
        return dp[len];
    }

    //01背包的空间优化
    public static int findTargetSumWays_3(int[] nums, int S) {
        if (nums.length <= 0) return 0;
        if (S > 1000) return 0;
        int[] pre = new int[2001];
        pre[1000 + nums[0]] = 1;
        pre[1000 - nums[0]] += 1;

        for (int i = 1; i < nums.length; i++) { //表示数组的第i个数
            int[] cur = new int[2001];
            for (int j = 0; j <= 2 * 1000; j++) {
                if (pre[j] > 0) {
                    cur[j - nums[i]] += pre[j];
                    cur[j + nums[i]] += pre[j];
                }
            }
            pre = cur;
        }
        return pre[S + 1000];
    }

    //尝试看成01背包问题
    public static int findTargetSumWays_2(int[] nums, int S) {
        if (nums.length <= 0) return 0;
        if (S > 1000) return 0;
        int[][] dp = new int[nums.length + 1][1000 * 2 + 1];//表示第i个数组成和为j的情况
        //dp[0][0] = 1;
        dp[1][nums[0] + 1000] = 1;
        dp[1][1000 - nums[0]] += 1;
        for (int i = 2; i < nums.length + 1; i++) {
            for (int j = 0; j <= 2 * 1000; j++) {
                if (dp[i - 1][j] > 0) {//前面必须存在路径才可继续往下走
                    dp[i][j - nums[i - 1]] += dp[i - 1][j];
                    dp[i][j + nums[i - 1]] += dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][S + 1000];

    }


    //递归 效率较低
    int sum = 0;

    public int findTargetSumWays_1(int[] nums, int S) {
        dfs(nums, 0, S);
        return sum;
    }

    public void dfs(int[] nums, int idx, int target) {
        if (idx >= nums.length) return;
        if (idx == nums.length - 1) {
            if (target == nums[idx]) sum++;
            if (target == -nums[idx]) sum++;
        }
        dfs(nums, idx + 1, target - nums[idx]);
        dfs(nums, idx + 1, target + nums[idx]);
    }

    public static void main(String[] args) {
        int n[] = new int[]{1, 1, 3, 1, 1};
        System.out.println("huohuo" + findTargetSumWays(n, 5));
    }
}
