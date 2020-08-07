package com.leetcode.easy;

public class addBinary_67 {

    public static String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();
        int jinwei = 0;
        int sum;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = jinwei;
            if (i >= 0) {
                sum += (a.charAt(i) - '0');
            }
            if (j >= 0) {
                sum += (b.charAt(j) - '0');
            }
            ans.append(sum % 2); //当前位加入ans
            jinwei = sum / 2; //更新进位
        }
        if (jinwei != 0) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }


    public static String addBinary_1(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {
        String a = "110";
        String b = "11";
        String x = addBinary(a, b);
        System.out.println(x);
    }
}
