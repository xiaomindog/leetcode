package com.BitManipulation;

//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

public class add_65 {


    //递归的写法
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }


    //a+b= 非进位和 + 进位
    public int add_1(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }
        return a;
    }

}
