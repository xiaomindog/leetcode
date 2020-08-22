package com.leetcode.medium;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 */
public class findPeakElement_162 {
    /**
     * 由于nums[-1]=nums[n]=-∞ ，必定存在峰值
     * 考虑4种情况包含峰值：
     * 1.数组单调增，峰值为nums[n-1]
     * 2.数组单调减，峰值为nums[0]
     * 3.数组先增后减，峰值为单调减的左闭区间
     * 4.数组先减后增，峰值为左右端点中的任意一个
     */

    public static int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] > nums[mid + 1]) { //单调减
                j = mid; //右半部分为开区间，所以循环的结束条件没有等号
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{3, 2, 1, 0, 1, 2};
        System.out.println(findPeakElement(nums));
    }

    //线性扫描，遇到前者大于后者说明遇到了峰值 否则数组最后一个元素为峰值
    public static int findPeakElement_1(int[] nums) {
        if (nums.length == 0) return -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
