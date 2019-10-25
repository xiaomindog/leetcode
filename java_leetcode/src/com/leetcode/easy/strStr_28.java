package com.leetcode.easy;

public class strStr_28 {

	public static int strStr01(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		}
		int j = 0, f, k;

		while (j < haystack.length()) {
			k = 0;
			f = j;
			while (k < needle.length() && j < haystack.length() && needle.charAt(k) == haystack.charAt(j)) {
				k++;
				j++;
			}

			if (k == needle.length()) {
				return f;
			}
			j = f;
			j++;
		}

		return -1;
	}

	public static int strStr02(String haystack, String needle) {
		
		
		
		
		
		
		
		
		
		
		
		
		return -1;
	}
	public static void main(String[] args) {
		String haystack = "aabaaaa";
		String needle = "baaaa";
		int t = strStr01(haystack, needle);
		System.out.println(t);
	}
}
