package com.jianzhi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue_59_II {
    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
     * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     */
    Deque<Integer> queue, mq;

    public MaxQueue_59_II() {
        queue = new LinkedList<>();
        mq = new LinkedList<>(); //维护一个单调队列  元素单调递减
    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return mq.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!mq.isEmpty() && mq.getLast() < value) {
            //保证单调队列元素的单调递减性
            mq.removeLast();
        }
        mq.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peekFirst().equals(mq.peekFirst())) {
            mq.removeFirst();
        }
        return queue.removeFirst();
    }
}
