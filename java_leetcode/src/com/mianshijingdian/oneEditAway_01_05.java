package com.mianshijingdian;

import java.util.Map;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class oneEditAway_01_05 {

    //分别从两个字符串的两边向中间匹配，一旦不一样就停止，比较剩余的区间长度。
    // 如果长度均小于等于1（注意临界条件）则结果为True，否则False。
    public static boolean oneEditAway(String first, String second) {
        int i = 0, j = first.length() - 1, k = second.length() - 1;
        if (Math.abs(j - k) > 1) return false;

        while (i < first.length() && i < second.length() && (first.charAt(i) == second.charAt(i))) {
            i++;
        }
        if (i == second.length() || i == first.length()) return true;

        while (j >= 0 && k >= 0 && (first.charAt(j) == second.charAt(k))) {
            j--;
            k--;
        }

        if ((j - i) < 1 && (k - i) < 1) return true;
        return false;
    }

    //方法2:出现不同，比较剩余字符
    public boolean oneEditAway_1(String first, String second) {
        int a = first.length() - second.length();
        if (Math.abs(a) > 1) return false;

        boolean flag = false;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) == second.charAt(j)) continue; //前面的字符相同 直接跳过
            else if (flag) {  //如果已经出现了不等长的情况或者字符不匹配的情况，不能再次出现不等。
                return false;
            } else {
                if (a == -1) { //如果first少一个字符，i=i,j=j+1，继续比较
                    i--;
                } else if (a == 1) { //如果second少一个字符，i=i+1,j=j,继续比较
                    j--;
                }
                flag = true; //已经出现了个数不同 或者不等的，后面不能再出现了
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean a = oneEditAway("abcd","abcd");
        System.out.println(a);
    }
}
