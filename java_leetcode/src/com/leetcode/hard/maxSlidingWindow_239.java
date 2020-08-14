package com.leetcode.hard;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 */
public class maxSlidingWindow_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k) return new int[0];
        int ans[] = new int[nums.length - k + 1];
        //维护一个单调递减的队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; j++, i++) { //i为滑动窗口的第一个元素 j为最后一个元素

            while (!queue.isEmpty() && queue.getLast() < nums[j]) {
                queue.pollLast();
            }
            queue.addLast(nums[j]);
            if (i >= 0 && !queue.isEmpty()) {
                ans[i] = queue.peekFirst();
                if (nums[i] == ans[i]) {
                    queue.pollFirst();
                }
            }
        }
        return ans;
    }
}
