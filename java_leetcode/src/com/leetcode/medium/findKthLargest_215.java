package com.leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class findKthLargest_215 {


    //堆排序的优化 只需要k个空间
    public static int findKthLargest(int[] nums, int k) {
        if (k <= 0 || k > nums.length) return 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap.peek() < nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap.peek();
    }

    //堆排序的思想
    public static int findKthLargest_1(int[] nums, int k) {
        //第K大即第num.length-k+1小
        if (k <= 0 || k > nums.length) return 0;
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            heap.poll();
        }
        return heap.peek();
    }


    //基于快速排序的思想
    public static int findKthLargest_2(int[] nums, int k) {
        if (k <= 0 || k > nums.length) return -1;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] s, int left, int right, int target) {
        int i = left, j = right, p = s[left];
        while (i < j) {
            while (i < j && s[j] > p) j--;
            if (i < j) {
                s[i++] = s[j];
            }
            while (i < j && s[i] < p) i++;
            if (i < j) {
                s[j--] = s[i];
            }
        }
        s[i] = p;

        if (i == target) return s[i];
        if (i < target) return quickSelect(s, i + 1, right, target); //target在右半部分 继续寻找
        else return quickSelect(s, left, i - 1, target);   //target在左边部分
    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 1, 5, 6, 4};
        int p = findKthLargest(a, 2);
        System.out.println(p);
    }
}
