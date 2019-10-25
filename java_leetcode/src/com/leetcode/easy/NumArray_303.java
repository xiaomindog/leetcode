package com.leetcode.easy;

import java.util.NavigableMap;

public class NumArray_303 {

    private int[] sums;
    public NumArray_303(int[] nums) { //构造器
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

    }
    //sum(i,j) = sum(j)-sum(i-1);
    public int sumRange(int i, int j) {
        if(i==0) {
            return sums[0];
        }
        return sums[j]-sums[i-1];

    }


}
