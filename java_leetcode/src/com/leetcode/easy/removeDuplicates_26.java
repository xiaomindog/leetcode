package com.leetcode.easy;



public class removeDuplicates_26 {

	public static int remove(int[] nums) {
		int i=0,j=0;
		if(nums.length==0) {
			return 0;
		}
		while(j<nums.length) {
			if(nums[i]==nums[j]) {
				j++;
			}
			else {
				nums[++i]=nums[j];
			}
		}
		
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		int[] n = {};
		int[] nn = {1,1,1,1,1,1};
		System.out.println(remove(nums));
		System.out.println(remove(nn));
	}
}
