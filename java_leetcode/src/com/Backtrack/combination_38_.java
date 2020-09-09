package com.Backtrack;


import java.util.LinkedList;
import java.util.List;


//剑指offer38题拓展： 字符串的组合
public class combination_38_ {


    static List<String> list;

    public static List<String> combination(String s) {
        list = new LinkedList<>();

        for (int m = 1; m <= s.length(); m++) {
            dfs(s, 0, m, new StringBuffer());
        }
        return list;
    }

    //len表示还剩下多少长度字符未加入
    public static void dfs(String s, int begin, int len, StringBuffer result) {
        if (s.length() == 0) return;
        //这个if要在前一个if的后面，

        if (len == 0) {
            list.add(result.toString());
            return;
        }
        if (begin >= s.length()) return;

        result.append(s.charAt(begin));//当前的字符被选中
        dfs(s, begin + 1, len - 1, result);//则从索引位置为begin+1的位置开始选择剩下的num-1个字符
        result.deleteCharAt(result.length() - 1);//当前的字符未被选中
        dfs(s, begin + 1, len, result); //则从索引位置为begin+1的位置继续选择num个字符
    }

    public static void main(String[] args) {
        System.out.println(combination("abcd"));
    }
}
