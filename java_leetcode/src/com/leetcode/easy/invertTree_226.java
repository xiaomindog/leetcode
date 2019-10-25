package com.leetcode.easy;


public class invertTree_226 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right; //相当于后续遍历 左右根
        return root;
    }

}
