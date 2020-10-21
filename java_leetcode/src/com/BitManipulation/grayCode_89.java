package com.BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 * 格雷编码序列必须以 0 开头。
 * 示例 1:
 * 输入:2
 * 输出:[0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1]也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 示例2:
 * 输入:0
 * 输出:[0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 * 给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
 * 因此，当 n = 0 时，其格雷编码序列为 [0]。
 */
public class grayCode_89 {

    //常规的回溯思路
    static List<Integer> res;

    public static List<Integer> grayCode(int n) {
        res = new ArrayList();
        boolean[] visited = new boolean[1 << n];
        dfs(0, n, visited);
        return res;
    }

    static void dfs(int cur, int n, boolean[] visited) {
        if (res.size() == (1 << n)) return;
        if (visited[cur]) return;
        visited[cur] = true;
        res.add(cur);
        for (int i = 0; i < n; i++) {
            dfs(cur ^ (1 << i), n, visited); ////这里改变cur的某一位，用异或
        }
    }

    public static List<Integer> grayCode_2(int n) {
        List<Integer> gray = new ArrayList<>();
        for (int binary = 0; binary < (1 << n); binary++) {
            gray.add(binary ^ (binary >> 1));
        }
        return gray;
    }


    //迭代的写法 找规律 参考博客：https://blog.csdn.net/guoziqing506/article/details/51554879
    public static List<Integer> grayCode_1(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 0) return ans;
        ans.add(0);
        if (n == 0) return ans;
        ans.add(1);
        for (int i = 2; i <= n; i++) {
            int len = ans.size() - 1;
            for (int j = len; j >= 0; j--) {
                int t = ans.get(j);
                ans.remove(j);
                ans.add(j, t << 1);
                ans.add((t << 1) + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(grayCode(3));
        //[0, 1, 3, 2, 6, 7, 5, 4]
    }

}