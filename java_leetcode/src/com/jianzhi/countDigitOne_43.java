package com.jianzhi;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 **/
public class countDigitOne_43 {

    //感觉有点排列组合的意味
    public static int countDigitOne(int n) {
        if (n <= 0) return 0;

        //状态初始化
        int count = 0;
        int high = n / 10, low = 0;
        int digit = 1;
        int cur = n % 10; //表示当前digit位的值
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                count += high * digit;
            } else if (cur == 1) {
                count += high * digit + 1 + low; // 这里low+1 比如 low=3 指的是210 211 212 213 这样
            } else {
                count += (high + 1) * digit; // high+1 此位1的出现次数只由高位high决定
            }
            cur = high % 10;
            digit *= 10;
            low = n % digit;
            high /= 10;
        }
        return count;

    }

    //这种方法leetcode超时
    public static int countDigitOne_1(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int t = i;
            while (t > 0) {
                if (t % 10 == 1) count++;
                t /= 10;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countDigitOne_1(824883294);
        System.out.println(count);
    }
}
