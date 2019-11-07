package com.leetcode.medium;



/*
* 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
* 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2). */


import java.util.Arrays;

public class threeSumClosest_16 {

    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2]; //最小值作为初值
        for (int i = 0; i < nums.length - 1; i++) {
            int m = i + 1, n = nums.length - 1;
            while (m < n) {
                int sum = nums[i] + nums[m] + nums[n]; //记录当前的三数之和
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum; //保存离的更近的
                }
                if (sum > target) {
                    n--;
                } else if (sum < target) {
                    m++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {-3, -2, -5, 3, -4};
        int t = threeSumClosest(nums, -1);
        System.out.println(t);
    }
}
