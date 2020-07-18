package com.jianzhi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 */
public class lastRemaining_62 {

    //数学公式的方法
    //递推公式 f(n) = (f(n-1)+m)%n

    public int lastRemaining(int n, int m) {
        int s = 0; //只剩1个数时候的位置
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }


    public int lastRemaining_1(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int len = list.size();
        int s = 0;
        while (len > 1) {
            list.remove((s + m - 1) % len); //每次删除起始位置开始的第m个数，这个数作为下个删除数的起始位置
            s = (s + m - 1) % len;
            len--;
        }
        return list.get(0);
    }
}
