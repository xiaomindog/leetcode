package com.leetcode.medium;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 */
public class divide_29 {
    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        int flag = 1;
        //把所有的数都转成负数来计算 防止负数最小值转正时越界
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            flag = -1;
        }
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);


        int sum = 0;
        while (dividend <= divisor) { //与正数相反的大小比较
            int temp = divisor;
            int count = 1;
            while (dividend - temp <= temp) {  //判断的时候 dividend要和2*temp比较，由于所有的数都是负的，所以
                temp <<= 1;
                count <<= 1;
            }
            dividend -= temp;
            sum += count;
        }

        return sum * flag;
    }

}
