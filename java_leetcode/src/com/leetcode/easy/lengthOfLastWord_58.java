package com.leetcode.easy;

public class lengthOfLastWord_58 {
	public static int lolw(String s) {
		
		int count = 0;
		for (int i = s.length() - 1;i >= 0; i--) {
			if(s.charAt(i)!=' ') {
				count++;
			}
			else if(count!=0){
				break;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "hello world";
		String s2 = "a   awa ";
		System.out.println(lolw(s));
		System.out.println(lolw(s2));
	}
}
