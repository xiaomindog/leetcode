package com.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 无重叠区间
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 * 示例 1:
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * 输入: [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * 输入: [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 **/
public class eraseOverlapIntervals_435 {


    //贪心算法 优化的
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (t1, t2) -> t1[1] == t2[1] ? t1[0] - t2[0] : t1[1] - t2[1]);
        int m = 1;
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] <= intervals[i][0]) {
                m++;
                temp = intervals[i];
            }
        }
        return intervals.length - m;
    }

    //尝试贪心的思路
    public int eraseOverlapIntervals_3(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (t1, t2) -> t1[1] == t2[1] ? t1[0] - t2[0] : t1[1] - t2[1]);
        //考虑[2,5]和[3,4]，应该先分配[3,4]更合理
        List<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(0)[1] <= intervals[i][0]) {
                list.add(0, intervals[i]);
            }
        }
        return intervals.length - list.size();
    }

    //2. 按照开始时间升序排序
    public int eraseOverlapIntervals_2(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]); //按照开始时间升序排序
        int[] dp = new int[intervals.length];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = 1; //单独成列
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return intervals.length - max;
    }

    //1.动态规划 思想同 最长上升子序列 ————按照结束时间升序排序
    public int eraseOverlapIntervals_1(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (t1, t2) -> t1[1] - t2[1]); //按照结束时间升序排序
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        for (int i = 1; i < intervals.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return intervals.length - max;
    }
}