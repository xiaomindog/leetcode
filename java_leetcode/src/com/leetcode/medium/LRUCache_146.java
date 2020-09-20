package com.leetcode.medium;

import java.util.*;

/**
 * 运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
 * 从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在O(1) 时间复杂度内完成这两种操作？
 * 示例:
 * LRUCache cache = new LRUCache( 2 缓存容量  );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得关键字 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得关键字 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 **/
public class LRUCache_146 {
    HashMap<Integer, Node> map; //为什么value是node  可以直接get到链表中其所在位置 而不必查找
    int capacity;
    int size;
    Node head, tail; //双向链表

    //定义一个存储键值对的Node
    public class Node {
        public int key, val;
        public Node next, pre;

        public Node() {

        }

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    public LRUCache_146(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        //初始化头尾结点（哨兵）
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        //把该结点移到头部
        //way：先删除该结点 然后再移动到头部
        removeNode(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            //添加新节点到头部
            map.put(key, newNode);
            addToHead(newNode);
            size++;
            //判断长度 超长需要移除尾部结点
            if (size > capacity) {
                Node t = tail.pre;
                removeTail();
                map.remove(t.key);
                size--;
            }
        } else {
            //找到该链，删除，添加到头部,更新map
            node.val = value;
            removeNode(node);
            addToHead(node);
        }
    }

    public void removeTail() {
        removeNode(tail.pre);
    }

    public void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */