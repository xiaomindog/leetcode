package com.leetcode.medium;

//34. 在排序数组中查找元素的第一个和最后一个位置
//同剑指offer53
public class searchRange_34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int i = 0, j = nums.length - 1; //闭区间

        //1.寻找左边界
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int left = j;

        i = left + 1;
        j = nums.length - 1;
        //2.寻找右边界
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;
        if (right - left == 1) return new int[]{-1, -1};
        return new int[]{left + 1, right - 1};
    }


    public int[] searchRange_1(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        //寻找右边界
        int i = 0, j = nums.length - 1; //闭区间
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        int right = i;//已经得到了右边界 i确定
        //此时j的位置为右边界的前一个

        //寻找左边界
        i = 0;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int left = j;
        if (right - left == 1) return new int[]{-1, -1};
        return new int[]{left + 1, right - 1};
    }
}
