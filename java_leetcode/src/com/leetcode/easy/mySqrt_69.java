package com.leetcode.easy;

public class mySqrt_69 {

    public static int mySqrt_1(int x) {
        int i = 0, j = x;
        int ans = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if ((long) mid * mid > x) {
                j = mid - 1;
            } else {
                ans = mid;
                i = mid + 1;
            }
        }
        return ans;
    }

    public static int mySqrt(int x) {
        if (x == 0) return 0;
        double c = x, x0 = x;
        double x1;
        while (true) {
            x1 = 0.5 * (c / x0 + x0); //x0处切线与x轴的交点
            if (Math.abs(x1 - x0) < 1e-7) break;
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
        System.out.println(mySqrt(8));
    }
}
