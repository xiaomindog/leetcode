package com.jianzhi;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class treeToDoublyList_36 {
    public class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        //dfs之后pre已经指向了最后一个节点
        head.left = pre; //第一个结点的左指针指向最后一个结点
        pre.right = head; //最后一个节点的右指针指向第一个节点
        return head;
    }

    //中序遍历模板
    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null) pre.right = root; //构建每个结点的右指针
        else head = root; //访问元素最小的结点 设为头结点
        root.left = pre; //构建每个节点的左指针
        pre = root;
        dfs(root.right);
    }
}
