package com.jianzhi;

/*输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。*/
public class printNumbers_17 {

    public int[] printNumbers(int n) {
        int p[] = new int[(int) Math.pow(10, n) - 1];
        for (int i = 0; i < Math.pow(10, n) - 1; i++) {
            p[i] = i + 1;
        }
        return p;
    }

    char[] num;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int n;
    int nine = 0, start; //start为左边界  nine为进位的个数
    int count = 0;
    int[] res;

    public int[] printNumbers_2(int n) {
        this.n = n;
        num = new char[n];
        res = new int[(int) Math.pow(10, n) - 1];
        start = n - 1; //左边界初始化为n-1
        dfs(0);
        return res;
    }

    public void dfs(int x) {
        if (x == n) {
            //去除高位的'0'
            String s = String.valueOf(num).substring(start); //substring start:
            if (!s.equals("0")) //第一个单独的"0"不需要
                res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

}
