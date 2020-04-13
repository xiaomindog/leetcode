package com.jianzhi;

public class Fibonacci_10 {
    public int Fibonacci(int n) {
        if(n<=0) return 0;
        int f1 = 0,f2=1;
        int f=1;
        for (int i =2;i<=n;i++){
            f = f1+f2;
            f1= f2;
            f2 = f;
        }
        return f;
    }
}
