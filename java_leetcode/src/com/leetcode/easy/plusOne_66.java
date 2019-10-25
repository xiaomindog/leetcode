package com.leetcode.easy;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class plusOne_66 {
	public static int[] po(int[] digits) {
		// ���Ԫ��ȫΪ9 ��1���鳤������
		int flag = 1;
		for (int d : digits) {
			if (d != 9) {
				flag = 0;
				break;
			}
		}

		if (flag == 1) {
			int[] nums = new int[digits.length + 1];
			nums[0] = 1;
			for (int i = 1; i < nums.length; i++) {
				nums[i] = 0;
			}
			return nums;
		}

		int i;
		for (i = digits.length - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				break;
			} else {
				digits[i] = 0;
			}

		}

		digits[i] += 1;
		return digits;
	}

	public static int[] po2(int[] digits) {

		int len = digits.length;
		int i, count = 0;
		for (i = len - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				break;
			} else {

				digits[i] = 0;
				count++;
			}
		}
		if (count == len) {
			digits = new int[len + 1]; // �½�һ��len+1�� ȫΪ0������
			digits[0] = 1;
			return digits;
		}
		digits[i] += 1;
		return digits;

	}

	public static int[] po3(int[] digits) {
		int len = digits.length;
		for (int i = len - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] %= 10;
			if (digits[i] != 0)
				return digits;
		}
		digits = new int[len + 1]; // �½�һ��len+1�� ȫΪ0������
		digits[0] = 1;
		return digits;
	}

	public static void main(String[] args) {
		int[] dig = new int[] { 1, 2, 3, 4, 5 };
		dig = new int[dig.length + 1];
		System.out.println(Arrays.toString(dig));
	}
}
