package com.leetcode.medium;

//153. 寻找旋转排序数组中的最小值------假设数组中不存在重复元素。
public class findMin_153 {

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < nums[j]) { //右半部分必定有序
                //2种情况 1：1256789  67812345
                //要么mid自己本身最小 要么最小的在mid的左边
                j = mid;
            } else { //左半部分有序
                i = mid + 1;
            }
        }
        return nums[i - 1];
    }

    public int findMin_1(int[] nums) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < nums[j]) { //右半部分必定有序
                //2种情况 1：1256789  67812345
                //要么mid自己本身最小 要么最小的在mid的左边
                //满足mid本身最小的条件
                if (nums[mid] < nums[(mid - 1 + len) % len]) return nums[mid];
                j = mid - 1;
            } else { //左半部分有序
                i = mid + 1;
            }
        }
        return nums[i - 1];
    }
}
