package com.leetcode.medium;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 */

public class removeDuplicates_80 {

    //最简短的方法
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public int removeDuplicates_1(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int size = 0;

        int i = 0, j = 0;
        while (i < nums.length) {
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j - 1 - i == 0) {
                nums[size++] = nums[i];
            } else {
                nums[size++] = nums[i];
                nums[size++] = nums[i];
            }
            i = j;
        }
        return size;
    }

}
