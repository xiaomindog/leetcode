package com.jianzhi;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且
 * 只有一个数字不在该数组中，请找出这个数字。
 */
public class missingNumber_53 {

    //主要考察还是二分法：
    //左子数组  num[i]==i
    //右子数组  num[i] !=i 返回右边界的第一个
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i; //返回的是右子数组第一个索引的元素
    }

    public int missingNumber_1(int[] nums) {
        if (nums.length <= 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) continue;
            else return i;
        }
        return nums.length;
    }
}
