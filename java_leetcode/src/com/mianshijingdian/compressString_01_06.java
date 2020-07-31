package com.mianshijingdian;


import java.util.LinkedList;
import java.util.List;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，
 * 则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 */
public class compressString_01_06 {
    public static String compressString(String S) {
        StringBuffer ans = new StringBuffer();
        if (S.length() <= 1) return S;
        int i = 0, j = i;
        int c = 0;
        while (j < S.length()) {
            c = 0;
            ans.append(S.charAt(i));
            while (j < S.length() && S.charAt(i) == S.charAt(j)) {
                j++;
                c++;
            }
            i = j;
            ans.append(String.valueOf(c));
        }
        if (ans.length() >= S.length()) return S;
        return ans.toString();
    }

    public static void main(String[] args) {
        String a = "rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff";
        String aa = "VVVVVVVVVV";
        System.out.println(aa.length());
        String s = compressString(aa);
        System.out.println(s);
    }
}
