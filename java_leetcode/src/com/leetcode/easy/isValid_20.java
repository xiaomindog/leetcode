package com.leetcode.easy;

import java.util.Stack;


public class isValid_20 {

    public static boolean isValid1(String strs) {

        while (strs.contains("[]") || strs.contains("{}") || strs.contains("()")) {
            if (strs.contains("[]")) {
                strs = strs.replace("[]", "");
            }
            if (strs.contains("{}")) {
                strs = strs.replace("{}", "");
            }
            if (strs.contains("()")) {
                strs = strs.replace("()", "");
            }
        }

        return strs.isEmpty();
    }

    public static boolean isValid2(String s) {

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push("(");
                    break;
                case ')':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals("(")) {
                        return false;
                    }
                    break;
                case '[':
                    stack.push("[");
                    break;
                case ']':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals("[")) {
                        return false;
                    }
                    break;
                case '{':
                    stack.push("{");
                    break;
                case '}':
                    if (stack.empty()) {
                        return false;
                    }
                    if (!stack.pop().equals("{")) {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for (char i : ch) {

            if (stack.isEmpty() || !isCompare(stack.peek(), i)) {
                stack.push(i);
            } else if (isCompare(stack.peek(), i)) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }


    public static boolean isCompare(char a, char b) {
        if (a == '[' && b == ']')
            return true;
        else if (a == '{' && b == '}') {
            return true;
        } else {
            return a == '(' && b == ')';
        }
    }

}
