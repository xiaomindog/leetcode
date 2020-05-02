package com.leetcode.medium;

//打家劫舍Ⅱ
//分两种情况,第一种情况下，不包含最后一个元素  第二种则是不包含第一个元素，返回两种情况中的较大者即可
public class rob_213 {
    public int rob(int[] nums) {
        if (nums.length <= 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        //第一种情况
        int max1[] = new int[nums.length + 1];
        for (int i = 2; i < nums.length + 1; i++) {
            max1[i] = Math.max(max1[i - 1], max1[i - 2] + nums[i - 2]);
        }

        //第二种情况
        int max2[] = new int[nums.length + 1];
        for (int i = 2; i < nums.length + 1; i++) {
            max2[i] = Math.max(max2[i - 1], max2[i - 2] + nums[i - 1]);
        }

        return Math.max(max1[max1.length - 1], max2[max2.length - 1]);
    }
}
