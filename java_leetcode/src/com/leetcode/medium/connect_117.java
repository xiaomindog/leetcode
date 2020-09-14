package com.leetcode.medium;

/**
 * 给定一个二叉树
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class connect_117 {
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

        if (root.right != null) {
            root.right.next = getThisLevelNext(root);
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = getThisLevelNext(root);
            }
        }
        //注意要先递归右子树  因为递归左子树的时候可能会到右子树的节点上 如果next指针没建立好 出错
        root.right = connect(root.right);
        root.left = connect(root.left);
        return root;
    }

    public Node getThisLevelNext(Node root) {
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }


    //利用head头结点和tail尾结点的思路， 当next为空时候就另起一行
    public Node connect_1(Node root) {
        if (root == null) return null;

        Node p = root, tail; //p为遍历指针，tail为尾指针
        while (p != null) { //p往下走
            Node head = new Node();
            tail = head;
            while (p != null) {  //p往右走
                //下面一行的所有数 加到tail去
                if (p.left != null) {
                    tail.next = p.left;
                    tail = tail.next;
                }
                if (p.right != null) {
                    tail.next = p.right;
                    tail = tail.next;
                }
                p = p.next;
            }
            //需要另起一行
            p = head.next;
        }
        return root;
    }

}
