package com.leetcode.easy;

public class climbStairs_70 {
	//ѭ������
	public static int cs1(int n) {
		if(n<=2) {
			return n;
		}
		int f1 = 1,f2 = 2;
		int f3=0;
		for(int i=3;i<=n;i++) {
			f3 = f1+f2;
			f1 = f2;
			f2 = f3;
		}
		return f3;
	}
	//�ݹ�  ����ʱ������
	public static int cs2(int n) {
		if(n<=0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		
		return cs2(n-1)+cs2(n-2);
		
	}
	
	public static int cs3(int n) {
		if(n<=1) {
			return n;
		}
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	//���Ž�
	public static int cs4(int n) {
		if(n<=2) {
			return n;
		}
		int t1 = 1;
		int t2 = 2;
		int i=3;
		for(i=3;i<=n;i++) {
			if(i%2==1) {
				t1 = t1+t2;
			}
			else {
				t2 = t1+t2;
			}
		}
		
		return n%2==1?t1:t2;
	}
	
	public static void main(String[] args) {
		
		System.out.println(cs4(3));
	}
}
