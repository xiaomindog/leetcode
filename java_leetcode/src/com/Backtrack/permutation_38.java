package com.Backtrack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class permutation_38 {

    //全排列
    static List<String> ans = new LinkedList<>();
    static char c[];

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return ans.toArray(new String[ans.size()]);
        //toArray()方法导出的是Object类型数组，而toArray(T[] a)方法导出的是指定类型的数组。
    }

    public static void dfs(int x) {
        if (x == c.length - 1) {
            ans.add(String.valueOf(c));
            return;
        }
        Set<Character> dic = new HashSet<>(); //set用来保存已经确定位置的字符
        for (int i = x; i < c.length; i++) {
            if (dic.contains(c[i])) continue; //如果字符存在且位置确定 跳过
            dic.add(c[i]);   // 确定该字符位置
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        String[] s = permutation("abc");
        for (String x:s){
            System.out.println(x);
        }
    }
}
