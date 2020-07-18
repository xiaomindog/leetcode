package com.jianzhi;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 **/
public class reverseLeftWords_58_II {
    public static String reverseLeftWords(String s, int n) {
        char[] str = new char[s.length()];
        for (int m = 0; m < s.length(); m++) {
            str[m] = s.charAt(m);
        }
        reverse(str, 0, n);
        reverse(str, n, str.length);
        reverse(str, 0, str.length);
        return String.valueOf(str);
    }

    public static void reverse(char[] str, int l, int r) {
        while (l < r) {
            char temp = str[l];
            str[l] = str[r - 1];
            str[r - 1] = temp;
            l++;
            r--;
        }
    }

    //字符串遍历拼接 O(n) O(n)
    public static String reverseLeftWords_1(String s, int n) {
        StringBuffer str = new StringBuffer();
        for (int i = n; i < s.length(); i++) {
            str.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String s = reverseLeftWords_1("abcdefg", 2);
        System.out.println(s);
    }
}
