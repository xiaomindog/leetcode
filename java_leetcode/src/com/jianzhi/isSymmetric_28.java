package com.jianzhi;

//请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
public class isSymmetric_28 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        else if (a == null || b == null) return false;
        return a.val == b.val && equal(a.left, b.right) && equal(a.right, b.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return equal(root.left, root.right);
    }
}
