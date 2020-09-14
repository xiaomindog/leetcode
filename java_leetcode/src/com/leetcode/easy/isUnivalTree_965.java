package com.leetcode.easy;

public class isUnivalTree_965 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.right == null && root.left == null) {
            return true;
        } else if (root.left == null) {
            return root.right.val == root.val && isUnivalTree(root.right);
        } else if (root.right == null) {
            return root.left.val == root.val && isUnivalTree(root.left);
        }
        return root.right.val == root.val && isUnivalTree(root.right) &&
                root.left.val == root.val && isUnivalTree(root.left);

    }
}
