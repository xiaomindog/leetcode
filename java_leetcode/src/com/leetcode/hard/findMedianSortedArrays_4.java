package com.leetcode.hard;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class findMedianSortedArrays_4 {
    /**
     * 问题可以转化成寻找两个有序数组中的第 k小的数，
     * 其中 k为 (m+n)/2或 (m+n)/2+1
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m + n <= 0) return 0.0;
        if ((m + n) % 2 == 1) {
            int k = (m + n) / 2 + 1;
            return getK(nums1, nums2, 0, m - 1, 0, n - 1, k) * 1.0;
        } else {
            int k = (m + n) / 2;
            return getK(nums1, nums2, 0, m - 1, 0, n - 1, k + 1) * 0.5
                    + getK(nums1, nums2, 0, m - 1, 0, n - 1, k) * 0.5;
        }
    }


    //非递归
    public static int getK(int[] num1, int[] num2, int l1, int r1, int l2, int r2, int k) {
        while (true) {
            int len1 = r1 - l1 + 1;
            int len2 = r2 - l2 + 1;
            if (len1 == 0) {
                return num2[l2 + k - 1];
            }
            if (len2 == 0) {
                return num1[l1 + k - 1];
            }
            if (k == 1) return Math.min(num1[l1], num2[l2]);
            int i = l1 + Math.min(len1, k / 2) - 1;
            int j = l2 + Math.min(len2, k / 2) - 1;
            if (num1[i] <= num2[j]) {
                k -= (i - l1 + 1);
                l1 = i + 1;

            } else {
                k -= (j - l2 + 1);
                l2 = j + 1;
            }
        }
    }


    //递归的方式
    public static int findK(int[] num1, int[] num2, int l1, int r1, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if (len1 == 0) {
            return num2[l2 + k - 1];
        }
        if (len2 == 0) {
            return num1[l1 + k - 1];
        }

        if (k == 1) return Math.min(num1[l1], num2[l2]);
        //如果k/2-1越界 则下标指向该数组最后一个元素
        int i = l1 + Math.min(len1, k / 2) - 1;
        int j = l2 + Math.min(len2, k / 2) - 1;
        if (num1[i] <= num2[j]) {  //如果num1数组的第k/2-1小 排除num2 前k/2-2个数i，新的num1的开始位置更新
            return findK(num1, num2, i + 1, r1, l2, r2, k - (i - l1 + 1));
        } else {
            return findK(num1, num2, l1, r1, j + 1, r2, k - (j - l2 + 1));
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        double d = findMedianSortedArrays(nums1, nums2);
        System.out.println(d);
    }
}
