package com.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class connect_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }

    public Node connect_1(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        Node p = root;
        queue.offer(p);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                p = queue.poll();
                if (i < size - 1) {
                    p.next = queue.peek();
                }
                //i=size-1时候 为null
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
        }
        return root;
    }
}
