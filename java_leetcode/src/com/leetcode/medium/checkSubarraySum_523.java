package com.leetcode.medium;

import javax.swing.*;
import java.util.HashMap;

/*给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，
其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。*/
public class checkSubarraySum_523 {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(0,-1); //sum%k=0的时候 需要这个
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (ans.containsKey(sum)) {
                if (i - ans.get(sum) > 1)
                    return true;//至少2个
            } else {
                ans.put(sum, i);
            }
        }
        return false;
    }


    //O(n2)暴力
    public static boolean checkSubarraySum_2(int[] nums, int k) {
        if (nums.length < 2) return false;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }

        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = dp[end] - dp[start] + nums[start];
                if ((k != 0 && sum % k == 0) || sum == k) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 10, 7};
        int k = 48;
        boolean s = checkSubarraySum(nums, k);
        System.out.println(s);
    }
}
