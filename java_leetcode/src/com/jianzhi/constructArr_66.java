package com.jianzhi;

/**
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 ***/
public class constructArr_66 {
    //分成上三角和下三角 分开计算
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        int ans[] = new int[a.length];
        ans[0] = 1;
        //计算下三角
        for (int i = 1; i < a.length; i++) {
            ans[i] = ans[i - 1] * a[i - 1]; //ans这里相当于dp数组，当前的累成和=前n-1个累成*第n个
        }
        //计算上三，有点区别
        int tmp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            tmp *= a[i + 1]; //不能直接用ans[i+1]，ans中保存了下三角的值
            ans[i] *= tmp;
        }
        return ans;
    }

}
