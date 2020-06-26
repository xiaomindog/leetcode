package com.jianzhi;

public class hammingWeight_15 {

    //每个位的数和1求与 ，时间复杂度为O(logN)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }


    //n&(n-1)的思路 太骚了
    //每次去除数字最右边的一个1 当n=0时循环结束
    //时间复杂度为O(m) m为1的个数
    public int hammingWeight_2(int n) {
        int count = 0;
        while (n != 0) {
            count += 1;
            n = n & (n - 1);
        }
        return count;
    }

}
