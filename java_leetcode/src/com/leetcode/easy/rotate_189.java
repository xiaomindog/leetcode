package com.leetcode.easy;

public class rotate_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length; //移动的位置
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int m, int n) {
        int temp;
        while (m < n) {
            temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
            m++;
            n--;
        }
    }

    //环状改编
    public void retate2(int[] nums, int k) {
        k%=nums.length;

    }
}
