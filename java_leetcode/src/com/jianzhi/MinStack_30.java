package com.jianzhi;

import java.util.Stack;

public class MinStack_30 {

    /**
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.min();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.min();   --> 返回 -2.
     */
    Stack<Integer> s, m;

    public MinStack_30() {
        s = new Stack<>(); //维护栈
        m = new Stack<>(); //栈顶保存当前栈内最小值
    }

    public void push(int x) {
        s.push(x);
        if (m.empty() || x <= m.peek()) m.push(x);
    }

    public void pop() {
        s.pop();
        m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return m.peek();
    }
}
