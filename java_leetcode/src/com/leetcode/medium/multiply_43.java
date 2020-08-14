package com.leetcode.medium;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 **/
public class multiply_43 {

    //  竖式加法的优化
    // 乘数 num1 位数为 M，被乘数 num2 位数为 N， num1 x num2 结果 res 最大总位数为 M+N
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int res[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1]; //tmp必定是2位数
                res[i + j + 1] = tmp % 10;
                res[i + j] += tmp / 10;
            }
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[0] == 0) continue;
            str.append(res[i]);
        }
        return str.toString();
    }

    public static String multiply_1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuffer sum = new StringBuffer("0");
        int tail_0 = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuffer str = new StringBuffer();
            int jinwei = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int tmp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + jinwei;
                str.append(tmp % 10);
                jinwei = tmp / 10;
            }
            if (jinwei != 0) {
                str.append(jinwei);
            }
            str.reverse();
            for (int k = tail_0; k > 0; k--) {
                str.append("0");
            }

            sum = add_string(sum, str);
            tail_0++;
        }
        return sum.toString();
    }

    public static StringBuffer add_string(StringBuffer n1, StringBuffer n2) {
        StringBuffer str = new StringBuffer();
        int l1 = n1.length() - 1, l2 = n2.length() - 1;
        int jinwei = 0;
        while (l1 >= 0 && l2 >= 0) {
            int tmp = (n1.charAt(l1) - '0') + (n2.charAt(l2) - '0') + jinwei;
            jinwei = tmp / 10;
            str.append(tmp % 10);
            l1--;
            l2--;
        }
        while (l1 >= 0) {
            int tmp = (n1.charAt(l1) - '0') + jinwei;
            jinwei = tmp / 10;
            str.append(tmp % 10);
            l1--;
        }
        while (l2 >= 0) {
            int tmp = (n2.charAt(l2) - '0') + jinwei;
            jinwei = tmp / 10;
            str.append(tmp % 10);
            l2--;
        }
        if (jinwei != 0) str.append(jinwei);
        return str.reverse();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0", "123"));
    }
}
