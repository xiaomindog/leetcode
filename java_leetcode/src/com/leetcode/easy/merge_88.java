package com.leetcode.easy;
/*
88.给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
*/

import javax.swing.*;

public class merge_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //if (nums2.length == 0) return;
        int i = m - 1, j = n - 1;
        int len_nums1 = nums1.length;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[--len_nums1] = nums1[i];
                i--;
            } else {
                nums1[--len_nums1] = nums2[j];
                j--;
            }
        }
        while (i>=0){
            nums1[--len_nums1] = nums1[i];
            i--;
        }
        while (j>=0){
            nums1[--len_nums1] = nums2[j];
            j--;
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 0, 0, 0};
        int m = 1;
        int nums2[] = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }

    }
}
