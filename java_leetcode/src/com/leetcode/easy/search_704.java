package com.leetcode.easy;

//二分查找 主要搞懂边界情况 2种
public class search_704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])  //搜索右半部分
                left = mid + 1;
            else
                right = mid - 1;

        }
        return -1;
    }

    public int search02(int[] nums, int target) {
        int left = 0, right = nums.length; //左闭右开区间
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])  //搜索右半部分
                left = mid + 1;
            else
                right = mid;   //右开区间 所以右边界不减1
        }
        return -1;
    }

}
