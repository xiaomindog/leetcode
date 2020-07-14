package com.jianzhi;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
 * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */
public class findNthDigit_44 {
    //1数9个 2位数90个 3位数900 以此类推 可发现规律
    public static int findNthDigit(int n) {
        if (n <= 9) return n;
        int digit = 1; //n所在的数的位数
        int start = 10; //digit位数 开始的数字
        //1.先判断出该数字所在数的位数
        while (true) {
            if (n <= start - 1) break;
            start *= 10;
            digit++;
        }
        start /= 10;

        //在判断是digit位数的第几个数 和第几位
        int x = (n - start) / digit;
        int num = start + x; //当前该数字
        int yushu = x % digit;
        return num / (int) Math.pow(10, digit - yushu - 1) % 10;
    }
    public static void main(String[] args) {
        int s = findNthDigit(12);
        System.out.println(s);
    }
}
