package com.leetcode.easy;

public class addBinary_67 {
	public static String add(String a, String b) {
		
		int aa=0,bb=0;
		int i=0,j=0;
		while(i<a.length()) {
			aa = aa*10+a.charAt(i)-'0';
			i++;
		}
		while(j<b.length()) {
			bb=bb*10+b.charAt(j)-'0';
			j++;
		}
		
		
		return  Integer.toBinaryString(twoToTen(aa)+twoToTen(bb)) ;
	}
	
	public static int twoToTen(long a) {
		int t = 0;
		int q = 1;
		while(a>0) {
			t+= q*(a%10);
			q= q*2;
			a/=10;
		}
		return t;
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(twoToTen(110010)+twoToTen(100)));
		System.out.println(twoToTen(110010));
	
	}
}
