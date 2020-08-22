package com.leetcode.hard;

//154. 寻找旋转排序数组中的最小值 II   可能存在重复元素
public class findMin_154 {

    //更优美的代码
    public static int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int i = 0, j = len - 1;

        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < nums[j]) { //右半部分有序
                j = mid;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j--;
            }
        }
        return nums[i];
    }


    public static int findMin_1(int[] nums) {
        if (nums.length == 0) return -1;
        int len = nums.length;
        int i = 0, j = len - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (mid != j && nums[mid] == nums[j]) {  //mid!=j很重要 防止删除本身
                j--;
                continue;
            }
            if (nums[mid] < nums[j]) { //右半部分有序
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return nums[i - 1];
    }

    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 1, 2, 3, 0, 1};
        int b = findMin(a);
        System.out.println(b);
    }
}
