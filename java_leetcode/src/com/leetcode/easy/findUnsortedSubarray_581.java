package com.leetcode.easy;

import java.util.Arrays;

public class findUnsortedSubarray_581 {

    //法一 开辟一个新数组 存储有序的序列然后比较
    public static int findUnsortedSubarray(int[] nums) {
        int[] temps = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temps[i] = nums[i];
        }
        Arrays.sort(temps);

        int l = 0, r = nums.length - 1;
        if (l < r) {
            while (temps[l] == nums[l]) {
                l++;
                if (l == nums.length) return 0;
            }
            while (temps[r] == nums[r]) r--;
            if (l < r) {
                return r - l + 1;
            }
        }


        return 0;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                flag = true;
            }
            if (flag) min = Math.min(min, nums[i + 1]); //找到无序子数组的最小值
        }
        flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]) {
                flag = true;

            }
            if (flag) max = Math.max(max, nums[i - 1]); // 最大值
        }

        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (min < nums[left]) break; //找到min有序的正确位置
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right]) break;
        }
        return right - left < 0 ? 0 : right - left + 1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int d = findUnsortedSubarray2(nums);
        System.out.println(d);
    }
}
