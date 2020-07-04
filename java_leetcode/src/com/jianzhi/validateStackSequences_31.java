package com.jianzhi;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
 * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class validateStackSequences_31 {


    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> push_stack = new Stack<>();
        int x = 0, y = 0; //x,y分别为入栈的元素位置和出栈的元素位置
        while (x < pushed.length) {
            push_stack.push(pushed[x]);
            while (!push_stack.empty() && push_stack.peek() == popped[y]) { //相当去向前去匹配
                // 例如： 12354 54321 匹配到3的时候
                push_stack.pop();
                y++;
                //if (y >= popped.length) return true;
            }
            x++;
        }
        return push_stack.empty();
    }

    public static void main(String[] args) {
        int[] push = {1, 0, 2,};
        int[] pop = {1, 2, 0};
        boolean f = validateStackSequences(push, pop);
        System.out.println(f);
    }
}
