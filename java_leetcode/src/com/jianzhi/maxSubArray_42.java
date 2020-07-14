package com.jianzhi;

//连续子数组的最大和
public class maxSubArray_42 {
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int t[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = maxSubArray(t);
        System.out.println(max);
    }
}
