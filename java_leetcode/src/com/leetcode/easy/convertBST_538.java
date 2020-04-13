package com.leetcode.easy;

/*给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
使得每个节点的值是原来的节点值加上所有大于它的节点值之和。*/

import java.util.Stack;

public class convertBST_538 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    //用栈迭代
    public TreeNode convertBST_2(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.add(p);
                p = p.right;
            }
            p = stack.pop();
            sum += p.val;
            p.val = sum;

            p = p.left;
        }
        return root;
    }

}
