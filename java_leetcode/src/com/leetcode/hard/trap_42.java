package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class trap_42 {


    //双指针
    /*定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
    定理二：当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，
    但right_max对它而言是不可信的。（见下图，由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值）
    定理三：当我们从右往左处理到right下标时，右边的最大值right_max对它而言是可信的，但left_max对它而言是不可信的。
    *
    对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
    这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
    无论右边将来会不会出现更大的right_max，都不影响这个结果。
     所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
    */
    public int trap_5(int[] height) {
        int sum = 0;
        int max_left = 0, max_right = 0;
        int left = 0, right = height.length - 1;
        while (left <= right) { //取等
            if (max_left < max_right) {
                sum += Math.max(max_left - height[left], 0);
                max_left = Math.max(max_left, height[left]);
                left++;
            } else {
                sum += Math.max(max_right - height[right], 0);
                max_right = Math.max(max_right, height[right]);
                right--;
            }
        }
        return sum;
    }

    //维护一个单调递减栈(可以取等)
    public int trap_4(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                // 如果栈顶元素一直相等，那么全都pop出去，只留第一个。
                while (!stack.isEmpty() && height[stack.peek()] == height[top]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int left = stack.peek();
                    int high = Math.min(height[left], height[i]); //高度
                    int wide = i - left - 1;//宽度
                    sum += ((high - height[top]) * wide);
                }
            }
            stack.push(i);
        }
        return sum;
    }


    //基于方法二的动态规划做法
    public int trap_3(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }


        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    //按列 依次遍历每一列 考虑每一列可以放水的区域（这个区域由其左右两边最大来决定） 时间复杂度O(n^2)
    //可以通过 时间12%
    public int trap_2(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (max_left < height[j]) {
                    max_left = height[j];
                }
            }
            for (int j = i + 1; j < height.length; j++) {
                if (max_right < height[j]) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


    //暴力解法 按层来 时间复杂度O(m*n) 超时
    public int trap_1(int[] height) {
        int max_high = 0;
        for (int h : height) {
            if (max_high < h) {
                max_high = h;
            }
        }
        int sum = 0;
        for (int i = 1; i <= max_high; i++) {
            boolean left = false;
            int tmp = 0;
            for (int j = 0; j < height.length; j++) {
                if (left && height[j] < i) {
                    tmp++;
                }
                if (height[j] >= i) {
                    left = true;
                    sum += tmp;
                    tmp = 0;
                }
            }
        }
        return sum;
    }
}
