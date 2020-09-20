package com.leetcode.medium;

import java.util.Stack;

/**
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括+,-,*,/。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例1：
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例2：
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例3：
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * 该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
 */
public class evalRPN_150 {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            char c = tokens[i].charAt(0);
            if ((c <= '9' && c >= '0') || (c == '-' && tokens[i].length() > 1)) {
                stack.add(tokens[i]);
            } else {
                int f1 = Integer.parseInt(stack.pop());
                int f2 = Integer.parseInt(stack.pop());
                if (tokens[i].equals("+")) {
                    stack.add(String.valueOf(f2 + f1));
                } else if (tokens[i].equals("-")) {
                    stack.add(String.valueOf(f2 - f1));
                } else if (tokens[i].equals("*")) {
                    stack.add(String.valueOf(f1 * f2));
                } else if (tokens[i].equals("/")) {
                    stack.add(String.valueOf(f2 / f1));
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] str = new String[]{"4", "3", "-"};
        int out = evalRPN(str);
        System.out.println(out);
    }
}
