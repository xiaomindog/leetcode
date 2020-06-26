package com.jianzhi;

//剑指 Offer 16. 数值的整数次方
public class myPow_16 {

    //迭代
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        double y = 1.0;
        long _n = n;
        if (n < 0) {
            x = 1 / x;
            _n = -_n;
        }
        while (_n > 0) {
            if ((_n & 1) == 1) {
                y *= x;
            }
            x *= x;
            _n >>= 1;

        }
        return y;
    }

    //递归 终止条件n=0
    public double myPow_2(double x, int n) {
        if (n == 0) return 1;
        double half = myPow_2(x, n / 2);
        if (n / 2 == 0) return half * half;
        if (n > 0) return half * half * x;
        return half * half / x;
    }
}
