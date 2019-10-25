package com.leetcode.easy;

public class mySqrt_69 {
	public static int ms1(int x) {
		if (x <= 0) {
			return 0;
		}

		double x0 = 1;
		double x1;
		while (true) {
			x1 = (x0 + x / x0) / 2;
			if (Math.abs(x1 - x0) < 1e-5) {
				break;
			}
			x0 = x1;
		}
		return (int) x1;
	}

	public static int ms2(int x) {
		if (x == 0) {
			return 0;
		}
		int l = 1;
		int r = x;
		int mid;
		while (l <= r) {
			mid = (l + r) / 2;
			if (mid > x / mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l - 1;
	}

	public static void main(String[] args) {
		System.out.println(ms2(10));
	}
}
