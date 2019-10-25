package com.leetcode.medium;

//  仅仅满足一个规则的BM算法
public class BM_01 {

    private static int SIZE = 256; //最大模式串长度

    public static void preBmBc(String str, int m, int[] bmBc) {
        for (int i = 0; i < SIZE; i++) {
            bmBc[i] = m;
        }
        for (int i = 0; i < str.length(); i++) {
            bmBc[str.charAt(i)] = i;  //按照ASCII值存入指定下标的位置
        }

    }

    public static int BoyerMooreSearch(String text, String pattern, int[] bmBs) {
        int M = text.length(); //文本长度
        int N = pattern.length(); //待查找的字符长度
        int skip;
        for (int i = 0; i <= M - N; i += skip) {
            skip = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = j - bmBs[text.charAt(i + j)]; //如果bmbs数组中不存在 即为-1
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        String pattern = "EXAMPLE";
        String text = "HERE IS A SIMPLE EXAMPLE";

        int[] bmBs = new int[SIZE];
        preBmBc(pattern, -1, bmBs);
        int s = BoyerMooreSearch(text, pattern, bmBs);
        System.out.println(s);
    }
}
