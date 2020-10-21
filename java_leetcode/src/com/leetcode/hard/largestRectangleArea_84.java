package com.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
public class largestRectangleArea_84 {

    //增加了首尾哨兵的单调栈
    //不用判断栈是否为空了
    public static int largestRectangleArea_3(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>(newHeights.length);
        stack.push(0);
        int max_rec = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[i] < newHeights[stack.peek()]) {
                int top = stack.pop();
                max_rec = Math.max(max_rec, newHeights[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return max_rec;
    }

    //单调递增栈  https://blog.csdn.net/Zolewit/article/details/88863970
    //当第i个柱子进栈时，如果栈顶柱子（此处记作柱子A）的高度低于或等于第i个柱子，则第i个柱子进栈；
    //如果高于第i个柱子，则出栈，并计算以柱子A为高的矩形最大面积。
    public static int largestRectangleArea_2(int[] heights) {
        if (heights.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int max_rec = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                while (!stack.isEmpty() && heights[stack.peek()] == heights[top]) {
                    stack.pop();  // 小优化 重复元素不必重复计算
                }
                //如果栈为空 表示左边没有比他矮的 不考虑了
                //如果不为空，i
                max_rec = Math.max(max_rec, heights[top] *
                        (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            while (!stack.isEmpty() && heights[stack.peek()] == heights[top]) {
                stack.pop();
            }
            max_rec = Math.max(max_rec, heights[top] *
                    (stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1));
        }
        return max_rec;
    }

    public static void main(String[] args) {
        int a[] = new int[]{2, 1, 5, 6, 2, 3};
        int s = largestRectangleArea_3(a);
        System.out.println(s);
    }

    //暴力法，以每个高度向左右2边扩散  时间复杂度O(N^2)
    public int largestRectangleArea_1(int[] heights) {
        int max_rec = 0;
        for (int i = 0; i < heights.length; i++) {
            //左半部分
            int j = i - 1, tmp = 0;
            while (j >= 0 && heights[j] >= heights[i]) {
                j--;
                tmp += heights[i];
            }

            //右半部分
            j = i + 1;
            while (j < heights.length && heights[j] >= heights[i]) {
                j++;
                tmp += heights[i];
            }
            tmp += heights[i];
            max_rec = Math.max(max_rec, tmp);
        }
        return max_rec;
    }
}
