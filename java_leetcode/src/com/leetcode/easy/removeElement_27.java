package com.leetcode.easy;

/*给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
*/

public class removeElement_27 {
	
	public static int remove(int[] nums,int val) {
		int k=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {  // 记录不是val的值 然后保存
				nums[k++]=nums[i];
			}
		}
		return k;
	}
	public static int remove2(int[] nums,int val) {
		int k=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==val) { //记录是val值的，非val值前移
				k++;
			}else {
				nums[i-k] = nums[i];
			}
		}
		
		return nums.length-k;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,3,0,4,2};
		int[] nums2 = {3,3};
		int[] nums3 = {2};
		System.out.println(remove2(nums, 2));
		System.out.println(remove2(nums2, 2));
		System.out.println(remove2(nums3, 5));

	}
}
