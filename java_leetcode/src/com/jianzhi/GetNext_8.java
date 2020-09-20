package com.jianzhi;


/*给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。*/
public class GetNext_8 {
    public class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode next = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode GetNext(TreeNode node) {
        if (node == null) return null;
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;

            }
            return node;
        }
        while (node.next != null) {
            //找到第一个作为左孩子的节点的父节点
            if (node.next.left == node) return node.next;
            node = node.next;
        }
        return null;
    }
}