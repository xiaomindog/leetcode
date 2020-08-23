package com.leetcode.medium;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
 * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
 * 示例 1: 
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 * 输入: [0,1]
 * 输出: 0
 */
public class rangeBitwiseAnd_201 {
    //一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的 1。
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        while (m < n) {
            n = n & (n - 1);
        }
        return n;
    }


    //2种右移位找到公共前缀的写法
    public int rangeBitwiseAnd_2(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd_1(int m, int n) {
        if (m == 0) return 0;
        if (m == n) return m;
        //从最高位开始比较 无符号 共31位
        int mask = 1 << 30;
        int res = 0;
        while (mask > 0 && (m & mask) == (n & mask)) {
            res = (m & mask) + res;
            mask >>= 1;
        }

        return res;
    }
}
