package com.DP;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 */
public class waysToStep_08_01 {


    public int waysToStep(int n) {
        if (n <= 2) return n;
        if (n == 3) return 4;
        long a = 1, b = 2, c = 4;
        long res = 0;
        for (int i = 4; i <= n; i++) {
            res = (a + b + c) % 1000000007;
            a = b;
            b = c;
            c = res;
        }
        return (int)res;
    }

    //超时
    public int waysToStep_1(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return waysToStep_1(n - 1) % 1000000007 +
                waysToStep_1(n - 2) % 1000000007 + waysToStep_1(n - 3) % 1000000007;
    }
}
