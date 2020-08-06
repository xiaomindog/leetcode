package com.leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

/***
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class lengthOfLIS_300 {

    //用二分法优化后的O(NlogN)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] tail = new int[nums.length]; //tail维护的是一个严格升序数组
        int end = 0;  //表示有序数组最后一个已经赋值的元素索引
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i]; //如果当前元素比tail中最大的还要大，则添加在tail的尾部
            } else {// 二分查找，找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int l = 0, r = end;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return end + 1;
    }

    public int lengthOfLIS_1(int[] nums) {
        if (nums.length <= 0) return 0;
        int dp[] = new int[nums.length];
        //Arrays.fill(dp, 1);
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {  //满足严格递增的
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.remove(a.size() - 1);
        for (Integer i : a) {
            System.out.println(i);
        }
    }
}
