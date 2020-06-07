package com.jianzhi;

import java.util.Stack;

public class CQueue_09 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int value) {
        stack1.push(value);  //队列尾部插入一个元素
    }

    public int deleteHead() {
        if(stack2.isEmpty()&&stack1.isEmpty()) return -1;
        if (stack2.isEmpty()) { //如果stack2为空把stack1的全部弹出到stack2中去
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

        }
        return stack2.pop();
    }


}
