package com.leetcode.medium;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class search_33 {


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                //先判断哪部分有序 哪部分无序
                if (nums[mid] < nums[j]) { //右半部分有序
                    if (target == nums[j]) {
                        return j;
                    } else if (target > nums[j]) {//同大 取大
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                } else {
                    i = mid + 1;
                }
            } else { // target<nums[mid]
                if (nums[mid] < nums[j]) { //右半部分有序
                    j = mid - 1;
                } else { //左半部分有序
                    if (target == nums[j]) {
                        return j;
                    } else if (target > nums[j]) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n[] = new int[]{4, 5, 6, 7, 0, 1, 2};
        int b = search(n, 0);
        System.out.println(b);
    }

}
