package com.mianshijingdian;

import java.util.HashSet;
import java.util.Set;

/***面试题 01.01. 判定字符是否唯一
 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 示例 1：
 输入: s = "leetcode"
 输出: false
 示例 2：
 输入: s = "abc"
 输出: true
 * */

public class isUnique_01_01 {

    //位运算的思路
    //26个字母 用26个二进制位表示 如果该位出现过了1 表示出现重复
    public static boolean isUnique(String astr) {
        int mark = 0; //二进制标记
        for (int i = 0; i < astr.length(); i++) {
            int move_bit = astr.charAt(i) - 'a';
            if ((mark & (1 << move_bit)) != 0) {
                return false;  //按位与 如果不相同的话，表明没有2个1在同一个位上
            } else {
                mark |= 1 << move_bit; //mark更新1 记录该数
            }
        }
        return true;
    }

    //如果是O(NlogN)

    //借用set集合
    public boolean isUnique_1(String astr) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < astr.length(); i++) {
            if (!set.contains(astr.charAt(i))) {
                set.add(astr.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean a = isUnique("bc");
    }
}
