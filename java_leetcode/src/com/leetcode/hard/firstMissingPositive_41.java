package com.leetcode.hard;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 提示：你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class firstMissingPositive_41 {

    //交换 把nums[i]放到nums[nums[i]-1]位置去
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int t = nums[nums[i] - 1];  //nums[i] == nums[nums[i] - 1]表明已经位置正确
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }


    //把小于等于0的数改为N+1，其他的把数对应的下标的数改为负数
    public int firstMissingPositive_2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int t = Math.abs(nums[i]);
            if (t <= len) {
                nums[t - 1] = -Math.abs(nums[t - 1]);
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return len + 1;
    }


    public int firstMissingPositive_1(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        //使用临时数组 如果该数在索引范围内，加入temp
        for (int i = 1; i <= len; i++) {
            //该数对应的下标合法
            if (nums[i - 1] <= len && nums[i - 1] >= 1) {
                temp[nums[i - 1]] = nums[i - 1];
            }
        }
        for (int i = 1; i <= len; i++) {
            if (i != temp[i]) {
                return i;
            }
        }
        return len + 1;
    }
}
