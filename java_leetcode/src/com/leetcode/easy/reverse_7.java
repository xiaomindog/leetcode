package com.leetcode.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。 # 2147483647  -2147483648
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class reverse_7 {

    //看到题解的一个做法 用到异常处理  性能24%
    public int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }
    }

    //性能100%
    public int reverse_1(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        boolean flag = x > 0;
        if (x < 0) x = -x;
        int xx = 0;
        while (x > 0) {
            if (flag && (xx > 214748364 || (xx == 214748364 && x % 10 > 7))) {
                return 0;  //正数越界
            }
            if (!flag && (xx > 214748364 || (xx == 214748364 && x % 10 > 8))) {
                return 0; //负数越界
            }
            xx *= 10;
            xx += (x % 10);
            x /= 10;
        }
        return flag ? xx : -xx;
    }

}
