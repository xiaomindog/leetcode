package com.jianzhi;

import javax.sound.midi.Soundbank;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
public class maxSlidingWindow_59 {

    //单调队列 滑动窗口->双端队列  保证队列里的元素是单调减的 滑动时每次需要移除队头元素
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int res[] = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        //i 作为返回数组得下标
        for (int i = 1 - k, j = 0; j < nums.length; j++, i++) {
            //维护一个单调队列
            while (!queue.isEmpty() && queue.getLast() < nums[j]) { //如果队列里元素小于新增元素 删除
                queue.removeLast();
            }
            queue.add(nums[j]); //新来的元素入队
            if (i >= 0 && !queue.isEmpty()) {
                if (nums[i] == queue.peekFirst()) {
                    res[i] = queue.removeFirst();
                } else {
                    res[i] = queue.peekFirst();
                }
            }
        }
        return res;
    }

    //暴力
    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int res[] = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < k + i; j++) {
                if (max < nums[j]) max = nums[j];
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {

        int n[] = new int[]{0, 1, 3, -1, -3, 5, 3, 6, 7};
        int s[] = maxSlidingWindow(n, 3);
        for (int i : s) {
            System.out.println(i);
        }
    }
}
