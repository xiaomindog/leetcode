package com.leetcode.easy;

/**
 * 你的朋友正在使用键盘输入他的名字name。偶尔，在键入字符c时，
 * 按键可能会被长按，而字符可能被输入 1 次或多次。
 * 你将会检查键盘输入的字符typed。
 * 如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回True。
 * 示例 1：
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 */
public class isLongPressedName_955 {
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            // 当 name[i]=typed[j] 时，
            // 说明两个字符串存在一对匹配的字符，此时将 i,j 都加 1
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                //如果typed[j]=typed[j−1]，说明存在一次长按键入，此时只将 j 加 1。
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }


    public static boolean isLongPressedName_1(String name, String typed) {
        if (name.equals("") && !typed.equals("")) return false;
        if (typed.equals("")) return false;
        int i = 0, j = 0;
        while (i < name.length()) {
            //如果有连续的2个相等
            if (j >= typed.length()) return false;
            while ((i + 1) < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                if (typed.charAt(j) == name.charAt(i)) {
                    i++;
                    j++;
                }
            }
            if (j >= typed.length()) return false;
            if (typed.charAt(j) != name.charAt(i)) return false;
            while (j < typed.length() && typed.charAt(j) == name.charAt(i)) {
                j++;
            }
            i++;

        }
        return j==typed.length();
    }

    public static void main(String[] args) {
        String name = "saeed";
        String typed = "ssaaaaedd";
        boolean f = isLongPressedName(name, typed);
        System.out.println(f);
    }
}
