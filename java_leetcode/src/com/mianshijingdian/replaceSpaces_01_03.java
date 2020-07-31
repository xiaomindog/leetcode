package com.mianshijingdian;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */

public class replaceSpaces_01_03 {
    public static String replaceSpaces(String S, int length) {

        int bland = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) == ' ') bland++;
        } //计算空格的个数

        char[] str = new char[length + bland * 2];
        int j = str.length - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (S.charAt(i) == ' ') {
                str[j--] = '0';
                str[j--] = '2';
                str[j--] = '%';
            } else {
                str[j--] = S.charAt(i);
            }
        }
        return  new String(str);
    }

    public static void main(String[] args) {
        String c = "Mr John Smith   ";
        String s = replaceSpaces(c, 13);
        System.out.println(s);
    }
}
