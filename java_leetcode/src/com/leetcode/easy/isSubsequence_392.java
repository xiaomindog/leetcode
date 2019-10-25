package com.leetcode.easy;

public class isSubsequence_392 {


    //暴力法解决  时间复杂度o(n)
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int is = 0, it = 0;
        int pi = 0;

        while (it < t.length()) {
//               pi=it;
            if (s.charAt(is) == t.charAt(it)) {
                is++;
                if (is == s.length()) //最后一个也找到相等的  直接返回true
                    return true;
                it++;//如果相等 就继续往下找
            } else {
                it++; // 如果不等 t继续往下走
            }

        }
        return false;
    }

    //利用java自带的indexof()函数
    public static boolean isSubsequence2(String s,String t){
        int index =-1;
        for (char c:s.toCharArray()){
            index = t.indexOf(c,(index+1));
            if(index==-1)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "agc";
        String t = "ahbgdc";
        System.out.println(isSubsequence2(s, t));
    }

}
