package com.leetcode.medium;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class nextPermutation_31 {
    //从后往前找到第一个降序的数字交换
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int j = nums.length - 1;
        while (j - 1 >= 0 && nums[j] <= nums[j - 1]) {
            j--;
        }
        if (j < 1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //找到后面第一个比不合理位置大的数
        int k = nums.length - 1;
        while (k >= 0 && nums[j - 1] >= nums[k]) {
            k--;
        }
        //if (k < 0) return;
        int temp = nums[j - 1];
        nums[j - 1] = nums[k];
        nums[k] = temp;
        reverse(nums, j, nums.length - 1);
    }

    public void reverse(int[] nums, int m, int n) {
        int i = m, j = n;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
