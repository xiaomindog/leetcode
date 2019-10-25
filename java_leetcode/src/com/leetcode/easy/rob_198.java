package com.leetcode.easy;

public class rob_198 {
    public int rob(int[] nums) {
        if (nums.length <= 0)
            return 0;
        //当前最大=max(前2天最大+当前值, 前1天的最大)
        int f1 = 0, f2 = 0;//f1 为前1天最大 f2为前2天最大
        int[] max = new int[nums.length]; //定义一个max矩阵
        for (int i = 0; i < nums.length; i++) {
            if(i<2) {
                f2 = nums[i]; //i<2 没有前2天的值
            }else {
                f2 =max[i-2]+nums[i];
            }
            int max_f1f2 = Math.max(f2, f1);
            max[i] = max_f1f2;
            f1 = max_f1f2; //f1记录下一个i的前一天的最大
        }
        return max[nums.length - 1];
    }
}
