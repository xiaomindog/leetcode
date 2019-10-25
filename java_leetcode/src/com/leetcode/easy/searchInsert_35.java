package com.leetcode.easy;


/*����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
 * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
    ����Լ������������ظ�Ԫ�ء�*/
public class searchInsert_35 {
	public static int search01(int[] nums, int target) {
		// ��ͷ������
		int i = 0;
		if (target <= nums[i]) {
			return 0;
		}

		for (i = 1; i < nums.length; i++) {
			if (target > nums[i - 1] && target <= nums[i]) {
				return i;
			}
		}
		return nums.length;
	}

	public static int search02(int[] nums, int target) {
		//���ֲ��ҷ�
		int left = 0,right = nums.length-1;
		int mid=0;
		
		while(left<=right) {
			mid = (left+right)/2;
			if(nums[mid]==target) {
				return mid;
			}
			else if(nums[mid]>target) {
				right = mid -1;
			}
			else {
				left = mid +1;
			}
		}
		
		return mid;
	}

	public static void main(String[] args) {

	}
}
