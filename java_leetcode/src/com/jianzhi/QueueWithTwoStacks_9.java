package com.jianzhi;

import java.util.Stack;

public class QueueWithTwoStacks_9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                int data = stack1.pop();
                stack2.push(data);
            }
        }
        int data = stack2.pop();

        return data;
    }
}
