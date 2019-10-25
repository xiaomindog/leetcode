package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class twoSum_1 {
	
	public static int[] two_sum01(int[] nums, int target){

		int[] temp = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		return temp;
	}

	public static int[] two_sum02(int[] nums, int target){
		int t[] =new int[2];
		Map<Integer,Integer> map =new HashMap<>();
		for(int i=0;i<nums.length;i++){
			map.put(nums[i],i);
		}

		for(int i=0;i<nums.length;i++){
			int temp = target-nums[i];
			if(map.containsKey(temp)&&map.get(temp)!=i){
				t[0]=i;
				t[1]=map.get(temp);
			}
		}
		return t;
	}
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 9, 15 };
		int[] temp = new int[2];
		int target = 9;
		temp = two_sum01(nums, target);
		System.out.println(temp.toString());
	}
}
