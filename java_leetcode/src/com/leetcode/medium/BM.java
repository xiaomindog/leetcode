package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class BM {


    public static void BM(String pattern, String text) {
        int m = pattern.length();
        int n = text.length();
        Map<String, Integer> bmBc = new HashMap<String, Integer>();
        int[] bmGs = new int[m];
        // proprocessing
        preBmBc(pattern, m, bmBc);
        preBmGs(pattern, m, bmGs);
        // searching
        int j = 0;
        int i = 0;
        int count = 0;
        while (j <= n - m) {
            for (i = m - 1; i >= 0 && pattern.charAt(i) == text.charAt(i + j); i--) { // 用于计数
                count++;
            }
            if (i < 0) {
                System.out.println("one position is:" + j);
                j += bmGs[0];
            } else {
                j += Math.max(bmGs[i], getBmBc(String.valueOf(text.charAt(i + j)), bmBc, m) - m + 1 + i);
            }
        }
        System.out.println("count:" + count);
    }


    /*
    * 本函数用于生成pattern字符串里每一个字符距离最后一个字符串的距离 如：example  --> {p=2, a=4, e=6, x=5, l=1, m=3}
    */
    private static void preBmBc(String pattern, int patLength, Map<String, Integer> bmBc) {
        //System.out.println("bmbc start process...");
        {
            for (int i = patLength - 2; i >= 0; i--)
                if (!bmBc.containsKey(String.valueOf(pattern.charAt(i) ))) {
                    bmBc.put(String.valueOf(pattern.charAt(i)), (Integer) (patLength - i - 1));
                }
        }
    }

    private static void preBmGs(String pattern, int patLength, int[] bmGs) {
        int i, j;
        int[] suffix = new int[patLength];
        suffix(pattern, patLength, suffix);
        // 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
        for (i = 0; i < patLength; i++) {
            bmGs[i] = patLength;
        }
        // 模式串中没有子串匹配上好后缀，但找到一个最大前缀
        j = 0;
        for (i = patLength - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
                for (; j < patLength - 1 - i; j++) {
                    if (bmGs[j] == patLength) {
                        bmGs[j] = patLength - 1 - i;
                    }
                }
            }
        }
        // 模式串中有子串匹配上好后缀
        for (i = 0; i < patLength - 1; i++) {
            bmGs[patLength - 1 - suffix[i]] = patLength - 1 - i;
        }
        System.out.print("bmGs:");
        for (i = 0; i < patLength; i++) {
            System.out.print(bmGs[i] + ",");
        }
        System.out.println();
    }

    //更新后缀匹配矩阵
    private static void suffix(String pattern, int patLength, int[] suffix) {
        suffix[patLength - 1] = patLength;
        int q = 0;
        for (int i = patLength - 2; i >= 0; i--) {
            q = i;
            while (q >= 0 && pattern.charAt(q) == pattern.charAt(patLength - 1 - i + q)) {
                q--;
            }
            suffix[i] = i - q;
        }
    }

    private static int getBmBc(String c, Map<String, Integer> bmBc, int m) {
        // 如果在规则中则返回相应的值，否则返回pattern的长度
        if (bmBc.containsKey(c)) {
            return bmBc.get(c);
        } else {
            return m;
        }
    }


    public static void main(String[] args) {
        String text = "here is a simple example";
        String pattern = "example";
        BM bm = new BM();
        bm.BM(pattern, text);
        //Map<String, Integer> bmBc = new HashMap<String, Integer>();
        //preBmBc(pattern,pattern.length(),bmBc);
        //System.out.println(bmBc);
    }
}
