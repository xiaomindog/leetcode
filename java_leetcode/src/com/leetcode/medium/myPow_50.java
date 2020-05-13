package com.leetcode.medium;


/*实现 pow(x, n) ，即计算 x 的 n 次幂函数。*/
public class myPow_50 {

    //递归的方法  x8 = x2->x4->x8
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, long n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    //迭代
    public double myPow_2(double x, int n) {
        if (x == 0.0) return 0.0;
        long n_ = n;
        if (n_ < 0) {
            x = 1 / x;
            n_ = -n_;
        }
        double y = 1.0;
        while (n_ > 0) {
            if ((n_ & 1) == 1) y *= x;
            x *= x;
            n_ >>= 1;
        }
        return y;
    }
}
