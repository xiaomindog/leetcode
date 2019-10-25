package com.leetcode.easy;

/*给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/
public class maxSubArray_53 {
	public static int msa(int[] nums) {
		if (nums.length <= 0) {
			return 0;
		}

		int sum = 0, max = nums[0];
		for(int num:nums) {
			if(sum>0) {
				sum+=num;
			}
			else {
				sum=num;
			}
			max = max>sum?max:sum;
		}
		return max;
	}
}
