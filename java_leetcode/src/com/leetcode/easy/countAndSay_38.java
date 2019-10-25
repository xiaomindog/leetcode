package com.leetcode.easy;

public class countAndSay_38 {
	public static String cas(int n) {
		if (n <= 0) {
			return "";
		}
		String[] seq = new String[n];
		seq[0] = "1";
		for (int i = 1; i < n; i++) {
			seq[i] = convert(seq[i - 1]);
		}
		return seq[n - 1];
	}

	public static String convert(String str) {
		StringBuilder ans = new StringBuilder();
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				ans.append(count).append(str.charAt(i));
				count = 1;
			}
		}
		return new String(ans);
	}

	public static void main(String[] args) {
		System.out.println(cas(5));
	}
}
