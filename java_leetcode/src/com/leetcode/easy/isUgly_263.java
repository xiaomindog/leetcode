package com.leetcode.easy;
/*编写一个程序判断给定的数是否为丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。*/

public class isUgly_263 {
    public boolean isUgly(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        if (num % 2 == 0) return isUgly(num / 2);
        if (num % 3 == 0) return isUgly(num / 3);
        if (num % 5 == 0) return isUgly(num / 5);
        return false;
    }

    public boolean isUgly_2(int num) {
        while (num != 0) {
            int t = num;
            if (num == 1) return true;
            if (num % 2 == 0) num /= 2;
            if (num % 3 == 0) num /= 3;
            if (num % 5 == 0) num /= 5;
            if (t == num) return false;
        }
        return false;
    }
}