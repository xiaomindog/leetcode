package com.jianzhi;

public class cuttingRope_14_2 {
    //要用到数学方法  不等式取最大值的问题
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;

//        int a = n / 3;
//        int b = n % 3;
//        if (b == 0) {
//            return (int) Math.pow(3, a)%1000000007;
//        }
//        if (b == 1) {
//            return (int) Math.pow(3, a - 1) * 2 * 2%1000000007;
//        }
//        return (int) Math.pow(3, a) * 2%1000000007;

        long rem = 1;
        while (n > 4) {   //n=4的时候 相当于余数为1
            rem *= 3;
            rem = rem % 1000000007;     //避免取余出错建议每部取余
            n -= 3;
        }
        return (int) (rem * n % 1000000007);
    }

}
