package com.jianzhi;


//青蛙跳台阶问题
public class numWays_10 {
    public int numWays(int n) {
        if (n < 0) return 0;
        if(n==0) return 1;
        int f0 = 1, f1 = 1;
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f = (f0 + f1) % 1000000007;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
