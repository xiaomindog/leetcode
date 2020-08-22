package com.leetcode.medium;


/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * <p>
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
//搜索旋转数组的延申  可能存在重复元素
public class search_81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[j]) {
                j--;
                continue;
            }

            if (target > nums[mid]) {
                //先判断哪部分有序 哪部分无序
                if (nums[mid] < nums[j]) { //右半部分有序
                    if (target == nums[j]) {
                        return true;
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
                        return true;
                    } else if (target > nums[j]) {
                        j = mid - 1;
                    } else {
                        i = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
